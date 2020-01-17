import java.sql.SQLException;

public interface TweetAPI {

    /**
     * Posts a tweet to the database
     * @param t the tweet to be posted
     * @throws SQLException if something SQL-ey is going wrong
     */
    void postTweet(Tweet t) throws SQLException;

    /**
     * Returns the most recent 20 tweets from users the specified user follows
     * @param userID the user whose timeline is to be retrieved
     */
    void getTimeline(int userID);
}
