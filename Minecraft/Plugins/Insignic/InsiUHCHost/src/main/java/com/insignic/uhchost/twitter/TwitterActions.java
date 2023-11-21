package com.insignic.uhchost.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterActions {

    public static void postTweet(String message){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KEY")
                .setOAuthConsumerSecret("KEY_SECRET")
                .setOAuthAccessToken("TOKEN")
                .setOAuthAccessTokenSecret("TOKEN_SECRET");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {

            twitter.updateStatus(message);

        } catch (TwitterException e) {

            e.printStackTrace();

        }

    }

}
