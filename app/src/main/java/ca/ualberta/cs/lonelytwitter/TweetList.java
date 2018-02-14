package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Abinsi on 2/13/2018.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        for (int i = 0;  i<tweets.size(); i++){
            if (tweets.get(i).getMessage().equals(tweet.getMessage())
                    && tweets.get(i).getDate().equals(tweet.getDate())){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);

    }

    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Tweet already exists in list");
        }else {
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets(){
        // return list of tweets sorted in choronological order
        // TODO sort in chronological order
        ArrayList<Tweet> sortedTweets = new ArrayList<Tweet>();
        int size= tweets.size();
        int firstTweetIndex;
        Tweet firstTweet;

        while(sortedTweets.size()< size) {
            firstTweet = tweets.get(0);                       //initialize first with first tweet in array
            firstTweetIndex=0;
            for (int i = 0; i < tweets.size(); i++) {
                if (tweets.get(i).getDate().before(firstTweet.getDate())) {
                    firstTweetIndex=i;
                    firstTweet=tweets.get(i);
                }
            }
            sortedTweets.add(tweets.get(firstTweetIndex));
            tweets.remove(firstTweet);
        }

        return sortedTweets;
    }

    public int getCount(){
        return tweets.size();
    }

}
