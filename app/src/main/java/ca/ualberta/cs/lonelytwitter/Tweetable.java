package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

//3. made interface package-private

interface Tweetable {
    String getMessage();        //1. Removed unnecessary "public"

    Date getDate();             //2. Removed unnecessary "public"

}
