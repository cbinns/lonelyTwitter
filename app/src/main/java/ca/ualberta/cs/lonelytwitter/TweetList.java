package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        ArrayList<Tweet> sortedTweets = (ArrayList<Tweet>) tweets.clone();
        Collections.sort(sortedTweets, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        return sortedTweets;

    }

    public int getCount(){
        return tweets.size();
    }

}
