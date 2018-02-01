/*
 * Important Tweet
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
 * Represents an important Tweet
 *
 * @author cbinns
 * @version 1.5
 * @see Tweet
 */

public class ImportantTweet extends Tweet {
    /**
     * Constructor for an Important Tweet
     *
     * @param message Tweet Message
     */
    ImportantTweet(String message){
        super(message);
    }

    /**
     * Constructor for Important tweet, with date specified
     *
     * @param message Tweet message
     * @param date Tweet date
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Flag the tweet as important
     *
     * @return Boolean True
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
