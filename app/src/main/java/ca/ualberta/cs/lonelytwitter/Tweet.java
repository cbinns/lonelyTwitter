/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 *  Copyright © 2018 Team X. CMPUT 301 University of Alberta - All Rights Reserved.
 *  You may use, distribute or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 *  You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Represents a Tweet
 *
 * @author cbinns
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Constructs a tweet object, Date set to current date
     *
     * @param message tweet message
     */
    Tweet(String message){
        this.message = message;
        date = new Date();
    }

    /**
     * Constructs a tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the message of a tweet object
     *
     * @return string message
     */
    public String getMessage(){
        return message;
    }



    /**
     * Sets tweet message.
     *
     * @param newMessage tweet message
     * @throws TweetTooLongException the tweet message is over 140 characters
     */
    public void setMessage(String newMessage) throws TweetTooLongException{
        if (newMessage.length() < 140){
            this.message = newMessage;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Returns the date of a Tweet
     *
     * @return date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets a date for a tweet
     *
     * @param date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Classifies tweet as important or not
     *
     * @return Boolean
     */
    public abstract Boolean isImportant();


    /**
     * Returns date of a tweet as a string
     *
     * @return string date
     */
    public String toString() {
        return date.toString() + " | " + message;
    }

}
