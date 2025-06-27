package com.biz.spark.quetions

import com.biz.spark.common.SparkConnection.spark.implicits._
import com.biz.spark.common.SparkConnection.spark
import org.apache.spark.sql.functions._

object LongestSessionPerUser {
  def main(args: Array[String]): Unit = {
    val events = Seq(
      (1, 1, "2025-06-26 10:00:00"), // login
      (1, 1, "2025-06-26 11:00:00"), // logout
      (1, 1, "2025-06-26 09:00:00"), // second login, NO logout -> use month-end
      (1, 2, "2025-06-26 08:00:00"), // login
      (1, 2, "2025-06-26 18:30:00") // logout
    ).toDF("appid", "user_id", "ts")
      .withColumn("ts", to_timestamp($"ts"))

    events.createOrReplaceTempView("user_logs")

    val result = spark.sql(
      """
WITH ordered AS (
    SELECT
        appid,
        user_id,
        ts,
        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY ts)         AS rn,
        LEAD(ts) OVER (PARTITION BY user_id ORDER BY ts)             AS next_ts
    FROM user_logs
),
sessions AS (
    /* Keep only login rows (odd rn) and pair with the next row */
    SELECT
        user_id,
        ts AS login_time,
        COALESCE(
            next_ts,
            -- If no logout, take last day-of-month 23:59:59
            LAST_DAY(ts) + INTERVAL 23 HOURS + INTERVAL 59 MINUTES + INTERVAL 59 SECONDS
        ) AS logout_time
    FROM ordered
    WHERE rn % 2 = 1
)
SELECT
    user_id,
    MAX(UNIX_TIMESTAMP(logout_time) - UNIX_TIMESTAMP(login_time)) AS max_session_secs
FROM sessions
GROUP BY user_id
""")

    result.show(false)

  }
}
