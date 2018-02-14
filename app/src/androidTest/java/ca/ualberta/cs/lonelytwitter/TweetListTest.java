package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Abinsi on 2/13/2018.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");

        try{
            tweets.add(tweet);
        }catch (IllegalArgumentException e){
            assertEquals(e, "Tweet already exists in list");
        }

        try {
            tweets.add(tweet);
        }catch (IllegalArgumentException e){
            assertEquals(e, "Tweet already exists in list");
        }

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        //using index
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("new message");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }


    public void testDeleteTweet () {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("message");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("message");

        assertEquals(tweets.getCount(),0);
        tweets.add(tweet);
        assertEquals(tweets.getCount(),1);
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        ArrayList<Tweet> sortedTweets;

        Tweet tweetBefore= new NormalTweet("message1");
        Tweet tweet = new NormalTweet("message2");
        Tweet tweetAfter = new NormalTweet("message3");


        tweets.add(tweetAfter);
        tweets.add(tweet);
        tweets.add(tweetBefore);


        sortedTweets = tweets.getTweets();

        assertEquals(tweetBefore,sortedTweets.get(0));
        /*
        assertEquals(tweetBefore.getDate(),sortedTweets.get(0).getDate());
        assertEquals(tweetBefore.getMessage(),sortedTweets.get(0).getMessage());


        assertEquals(tweet.getDate(),sortedTweets.get(1).getDate());
        assertEquals(tweet.getMessage(),sortedTweets.get(1).getMessage());

        assertEquals(tweetAfter.getDate(),sortedTweets.get(2).getDate());
        assertEquals(tweetAfter.getMessage(),sortedTweets.get(2).getMessage());
        */

    }
}
