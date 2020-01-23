import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Twitter {


  public static void main(String arg[]) throws IOException {

    int numUsers = 1000;

    ArrayList<ArrayList<String>> followerTable = new ArrayList<ArrayList<String>>();

    // populate the follower table
    for (int i = 0; i< numUsers; i++) {

      ArrayList<String> list1 = new ArrayList<String>();

      int l1, l2;
      l1 = (int)(Math.random() * ((numUsers) + 1));
      l2 = (int)(Math.random() * ((numUsers) + 1));
      // make sure they not same, assume can't follow self
      while (l1 == l2) {
        l2 = (int)(Math.random() * ((numUsers) + 1));
      }

      list1.add(String.valueOf(l1)); // follower
      list1.add(String.valueOf(l2)); // followee

      followerTable.add(list1);

    }

    // write all the follower data to the csv
    FileWriter csvWriter = new FileWriter("new.csv");

    for (List<String> rowData : followerTable) {
      csvWriter.append(String.join(",", rowData));
      csvWriter.append("\n");
    }

    csvWriter.flush();
    csvWriter.close();


    // MAKE TWEETS
    ArrayList<ArrayList<String>> tweetsTable = new ArrayList<ArrayList<String>>();

    int numTweets = 1000000; //million
    Random rnd = new Random();

    for (int i = 0; i < numTweets; i++) {

      Date date = new Date(Math.abs(System.currentTimeMillis() - (int) (999999999 * Math.random())));
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      String strDate = dateFormat.format(date);

      // chose a Character random from this String
      String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
              + "0123456789"
              + "abcdefghijklmnopqrstuvxyz";

      // create StringBuffer size of AlphaNumericString
      int tweetMaxSize = 100;
      String sb = "";

      for (int j = 0; j < (int)(tweetMaxSize * Math.random()); i++) {

        // generate a random number between
        // 0 to AlphaNumericString variable length
        int index = (int)(AlphaNumericString.length() * Math.random());

        // add Character one by one in end of sb
        sb += AlphaNumericString.charAt(index);
      }

      ArrayList<String> list1 = new ArrayList<String>();
      list1.add(String.valueOf(i));
      list1.add(String.valueOf((int)(Math.random() * numUsers)));
      list1.add(strDate);
      list1.add(sb);

      tweetsTable.add(list1);

    }


    // write all the tweet data to the csv
    FileWriter csvWriter2 = new FileWriter("new2.csv");

    for (List<String> rowData : tweetsTable) {
      csvWriter2.append(String.join(",", rowData));
      csvWriter2.append("\n");

    }
    csvWriter2.flush();
    csvWriter2.close();

  }

}
