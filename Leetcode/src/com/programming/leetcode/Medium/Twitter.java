package com.programming.leetcode.Medium;

import java.util.*;

public class Twitter {

    class Tweet{
        int tweetId;
        int userId;
        long timeStamp;

        public Tweet(int tweetId, int userId, long timeStamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timeStamp = timeStamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tweet)) return false;
            Tweet tweet = (Tweet) o;
            return tweetId == tweet.tweetId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(tweetId);
        }
    }

    Map<Integer, Set<Integer>> followersMap;
    Set<Tweet> tweetsCollection;
    long timeStamp = 0;
    /** Initialize your data structure here. */
    public Twitter() {
        followersMap = new HashMap<>();
        tweetsCollection = new TreeSet<>( (a,b)->{
            if(b.timeStamp > a.timeStamp) return 1;
            else if(b.timeStamp < a.timeStamp) return -1;
            else return 0;
        });
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetsCollection.add(new Tweet(tweetId, userId, timeStamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followerIds = followersMap.get(userId);
        List<Integer> res = new ArrayList<>();
        Iterator<Tweet> tweetsIterator = tweetsCollection.iterator();
        while(tweetsIterator.hasNext() && res.size() < 10){
            Tweet crt = tweetsIterator.next();
            if((followerIds != null && followerIds.contains(crt.userId))|| crt.userId == userId){
                res.add(crt.tweetId);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId,k-> new HashSet<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.containsKey(followerId)){
            Set<Integer> followings = followersMap.get(followerId);
            followings.remove(followeeId);
            followersMap.put(followerId,followings);
        }
    }



     class TwitterV1 {

        private int timeStamp=0;

        // easy to find if user exist
        private Map<Integer, User> userMap;

        // Tweet link to next Tweet so that we can save a lot of time
        // when we execute getNewsFeed(userId)
        private class TweetV1{
            public int id;
            public int time;
            public TweetV1 next;

            public TweetV1(int id){
                this.id = id;
                time = timeStamp++;
                next=null;
            }
        }


        // OO design so User can follow, unfollow and post itself
        public class User{
            public int id;
            public Set<Integer> followed;
            public TweetV1 tweet_head;

            public User(int id){
                this.id=id;
                followed = new HashSet<>();
                follow(id); // first follow itself
                tweet_head = null;
            }

            public void follow(int id){
                followed.add(id);
            }

            public void unfollow(int id){
                followed.remove(id);
            }


            // everytime user post a new tweet, add it to the head of tweet list.
            public void post(int id){
                TweetV1 t = new TweetV1(id);
                t.next=tweet_head;
                tweet_head=t;
            }
        }




        /** Initialize your data structure here. */
        public TwitterV1() {
            userMap = new HashMap<Integer, User>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!userMap.containsKey(userId)){
                User u = new User(userId);
                userMap.put(userId, u);
            }
            userMap.get(userId).post(tweetId);

        }



        // Best part of this.
        // first get all tweets lists from one user including itself and all people it followed.
        // Second add all heads into a max heap. Every time we poll a tweet with
        // largest time stamp from the heap, then we add its next tweet into the heap.
        // So after adding all heads we only need to add 9 tweets at most into this
        // heap before we get the 10 most recent tweet.
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new LinkedList<>();

            if(!userMap.containsKey(userId))   return res;

            Set<Integer> users = userMap.get(userId).followed;
            PriorityQueue<TweetV1> q = new PriorityQueue<>(users.size(), (a,b)->(b.time-a.time));
            for(int user: users){
                TweetV1 t = userMap.get(user).tweet_head;
                // very imporant! If we add null to the head we are screwed.
                if(t!=null){
                    q.add(t);
                }
            }
            int n=0;
            while(!q.isEmpty() && n<10){
                TweetV1 t = q.poll();
                res.add(t.id);
                n++;
                if(t.next!=null)
                    q.add(t.next);
            }

            return res;

        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!userMap.containsKey(followerId)){
                User u = new User(followerId);
                userMap.put(followerId, u);
            }
            if(!userMap.containsKey(followeeId)){
                User u = new User(followeeId);
                userMap.put(followeeId, u);
            }
            userMap.get(followerId).follow(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(!userMap.containsKey(followerId) || followerId==followeeId)
                return;
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    public static void main(String[] args) {
          Twitter obj = new Twitter();
          obj.postTweet(1,5);
          obj.postTweet(1,3);
          System.out.println(obj.getNewsFeed(1));
          obj.follow(1,2);
          obj.postTweet(2,6);
          System.out.println(obj.getNewsFeed(1));
          obj.unfollow(1,2);
          System.out.println(obj.getNewsFeed(1));
    }
}
