import java.sql.*;

/**
 * A class implementing TweetAPI for MySQL databases
 */
public class TweetAPIMySql implements TweetAPI {
    private Connection con = null;

    /**
     * Constructor for API object
     * @param url the URL the database is located
     * @param user the username being used to connect to the database
     * @param password the password being used to connect to the database
     */
    TweetAPIMySql(String url, String user, String password) {
        this.con = this.getConnection(url, user, password);
    }

    /**
     * Used to create a connection with the MySQL database
     * @param url the location of the database
     * @param user the username for the database
     * @param password the password for the database
     * @return a connection object to the database
     */
    private Connection getConnection(String url, String user, String password) {
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
        return con;
    }

    @Override
    public void postTweet(Tweet t) {

        String sql = "INSERT into Tweets (userid, tweets_ts, tweet_text) " +
                "VALUES (" + t.getUserID() + ", " + t.getDate() + ", " + t.getContent() + ");";

        try {
            Statement s = con.createStatement();
            s.execute(sql);
            s.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getTimeline(int userID) {

        String sql = "select t.* FROM Tweets t join follows f on t.user_id = f.follows_id " +
                "where f.follower_id = " + userID + " order by t.datetime desc limit 20";

        try {
            // get connection and initialize statement
            Statement s = this.con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                // TODO: something here?
            }
            rs.close();
            s.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


    }
}