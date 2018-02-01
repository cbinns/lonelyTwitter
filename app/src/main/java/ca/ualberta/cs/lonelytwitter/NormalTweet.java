/*
 * Normal Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 *  Copyright © 2018 Team X. CMPUT 301 University of Alberta - All Rights Reserved.
 *  You may use, distribute or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 *  You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Normal Tweet
 *
 * @author cbinns
 * @version 1.5
 * @see Tweet
 */
public class NormalTweet extends Tweet {
    /**
     * Constructor for a normal Tweet
     *
     * @param message Tweet message
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Constructor for a normal Tweet, with specified date
     *
     * @param message Tweet message
     * @param date Tweet date
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Flag the tweet as not important
     *
     * @return Boolean False
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
