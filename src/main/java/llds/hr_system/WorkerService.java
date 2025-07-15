package llds.hr_system;

import llds.hr_system.models.Employee;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerService {
    MessageQueue queue = new MessageQueue();
    private final HRAPI hrapi;
    private final SecurityAPI securityAPI;
    private final Map<Integer,Long> cache = new ConcurrentHashMap<>();
    private final long TTL_MILLIS = 10_000;

    public WorkerService(MessageQueue queue, HRAPI hrapi, SecurityAPI securityAPI) {
        this.queue = queue;
        this.hrapi = hrapi;
        this.securityAPI = securityAPI;
    }
    public void start() {
        while (true) {
            try {
                int userID = queue.receive();
                long now = System.currentTimeMillis();
                if(cache.containsKey(userID) && now - cache.get(userID) < TTL_MILLIS) {
                    continue;
                }
                cache.put(userID,now);
                Employee emp = hrapi.getEmployee(userID);
                securityAPI.updateAccess(userID,emp.getStatus());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
