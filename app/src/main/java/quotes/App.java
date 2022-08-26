/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    static Gson gson = null;


    public static void main(String[] args) throws IOException {

        OnlineQuote quote = onlineQuote(urlConnector());
        Path filePath = Paths.get("app/src/main/resources/quotes.json");

        if (filePath.toFile().canRead()){
            File file = filePath.toFile();
            quoteFileWriter(quote,file);

        } else createFile();


    }
    public static String getaQuote(int index){
        Path jsonFile = Paths.get("app/src/main/resources/recentquotes.json");
        List<Books> books = null;
        try {

            Reader reader = Files.newBufferedReader(jsonFile);
            books = new Gson().fromJson(reader, new TypeToken<List<Books>>() {}.getType());

//            books.forEach(System.out::println);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assert books != null;
        return books.get(index).toString();
    }


    public static HttpURLConnection urlConnector() throws IOException {
        //1. Make a url to talk to the API
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        //2.Make a connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //3. make a method for get
        con.setRequestMethod("GET");
        return con;
    }

    public static OnlineQuote onlineQuote(HttpURLConnection con) throws IOException {
        //Create object from JSON data using a class constructor

        gson = new GsonBuilder().setPrettyPrinting().create();
        InputStreamReader quoteReader = new InputStreamReader(con.getInputStream());
        String quoteData = null;
        try(BufferedReader reader = new BufferedReader(quoteReader))
        {
           quoteData = reader.readLine();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        OnlineQuote quote = gson.fromJson(quoteData, OnlineQuote.class);

        return quote;

    }
    public static void createFile() {
        File savedQuotes = new File("app/src/main/resources/quotes.json");
    }
    public static void quoteFileWriter(OnlineQuote quote, File quoteFile) throws IOException{
        try(FileWriter quoteFileWriter = new FileWriter(quoteFile,true)) {
            gson.toJson(quote, quoteFileWriter);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //once we get the quote push to an array list
    // Write list to a file



}

