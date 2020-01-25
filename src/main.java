import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;


public class main {
    public static void main(String [] args) throws IOException, SQLException {
        tweetTest();
        timelineTest();
    }


    private static void tweetTest() throws IOException, SQLException {
        BufferedReader csvReader = new BufferedReader(new FileReader("new2.csv"));

        // Connect to DB
        //TODO: Add URL to DB
        TweetAPIMySql api = new TweetAPIMySql("jdbc:mysql://localhost:3306/twitter", "user1", "root");
        api.importFollowers();
        // Start a timer
        System.out.println("Starting tweet test.");
        Instant start = Instant.now();

        // For each line, post a tweet
        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            Tweet t = new Tweet(Integer.parseInt(data[1]), data[3], data[2]);
            api.postTweet(t);
        }
        csvReader.close();
        // Print a "done" message / close timer
        Instant end = Instant.now();
        System.out.println("Finished tweet test. Duration: " + Duration.between(start, end));
    }

    private static void timelineTest() throws IOException, SQLException {
        // Connect to DB
        //TODO: Add URL to DB
        TweetAPIMySql api = new TweetAPIMySql("jdbc:mysql://localhost:3306/twitter", "user1", "root");
        // Start a timer
        System.out.println("Starting timeline test.");
        Instant start = Instant.now();

        // Pick random user's timeline
        for (int i = 0; i < 1000; ++i) {
            api.getTimeline((int)(Math.random() * 1000));
        }

        // Print a "done" message / close timer
        Instant end = Instant.now();
        System.out.println("Finished timeline test. Duration: " + Duration.between(start, end));
    }
}
