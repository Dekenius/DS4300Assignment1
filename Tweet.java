/**
 * A class representing a Tweet
 */
public class Tweet {
    private int userID;
    private String content;
    private String date;

    /**
     * Constructor for Tweet class
     * @param id user's unique id
     * @param content the text of the tweet
     * @param date the date the tweet is posted
     */
    Tweet(int id, String content, String date) {
        this.userID = id;
        this.content = content;
        this.date = date;
    }

    int getUserID() {
        return this.userID;
    }

    String getDate() {
        return this.date;
    }

    String getContent() {
        return this.content;
    }
}
