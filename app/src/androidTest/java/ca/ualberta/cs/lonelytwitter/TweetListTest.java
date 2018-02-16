package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.JANUARY, 1);

        Date beforeDate = cal.getTime();

        cal.set(2014, Calendar.JANUARY, 1);
        Date date = cal.getTime();

        cal.set(2015, Calendar.JANUARY, 1);
        Date afterDate = cal.getTime();


        Tweet tweetBefore= new NormalTweet("message1");
        tweetBefore.setDate(beforeDate);

        Tweet tweet = new NormalTweet("message2");
        tweet.setDate(date);

        Tweet tweetAfter = new NormalTweet("message3");
        tweetAfter.setDate(afterDate);

        tweets.add(tweetAfter);
        tweets.add(tweet);
        tweets.add(tweetBefore);

        sortedTweets = tweets.getTweets();

        Log.i("first tweet msg", tweets.getTweet(0).getMessage());

        assertEquals(tweetBefore,sortedTweets.get(0));
        assertEquals(tweet,sortedTweets.get(1));
        assertEquals(tweetAfter, sortedTweets.get(2));




    }
}
