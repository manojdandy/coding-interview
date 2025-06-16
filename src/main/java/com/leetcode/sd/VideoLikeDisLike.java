package com.leetcode.sd;

import java.util.HashMap;
import java.util.Map;

class VideoStats {
    int like = 0;
    int dislike = 0;
    Map<Integer, String> userReactions = new HashMap<>();
}

public class VideoLikeDisLike {
    Map<Integer, VideoStats> videoStatsMap = new HashMap<>();

    public static void main(String[] args) {
        VideoLikeDisLike videoLikeDisLike = new VideoLikeDisLike();
        VideoStats stats = videoLikeDisLike.videoStatsMap.get(111);
        System.out.println("stats :: " + stats);
        System.out.println("hello");
    }

    /**
     *
     * @param userId
     * @param videoId
     */
    void like(int userId, int videoId) {
        VideoStats videoStats = videoStatsMap.getOrDefault(videoId, new VideoStats());
        String prev = videoStats.userReactions.get(userId);
        if ("like".equals(prev)) return;
        if ("dislike".equals(prev)) {
            videoStats.dislike--;
        } ;
        videoStats.like++;
        videoStats.userReactions.put(userId,"like");
        videoStatsMap.put(videoId,videoStats);
    }

    void  dislike(int userId,int videoId) {
        VideoStats stats = videoStatsMap.getOrDefault(videoId,new VideoStats());
        String prev = stats.userReactions.get(userId);
        if("dislike".equals(prev)) return;;
        if("like".equals(prev)) {
            stats.like--;
        }
        stats.dislike++;
        stats.userReactions.put(userId,"dislike");
        videoStatsMap.put(videoId,stats);
    }
    void removeReaction(int userId,int videoId) {
        VideoStats stats = videoStatsMap.get(videoId);
        if(stats == null) return;
        videoStatsMap.put(videoId,null);
    }

}

