/*
 * Tweetable
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
 * Represents an Tweet interface
 *
 * @author cbinns
 * @version 1.5
 * @see Tweet
 * @see NormalTweet
 * @see ImportantTweet
 */
public interface Tweetable {
    /**
     * Return the message of a Tweet
     *
     * @return message Tweet message
     */
    public String getMessage();

    /**
     * Return Tweet date
     *
     * @return date Tweet date
     */
    public Date getDate();
}
