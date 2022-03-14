package quotes;
import com.google.gson.Gson;
import java.io.*;
public class FileOperations {
    public String getQuote(String quotesFile) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(quotesFile);
        BufferedReader br =new BufferedReader(reader);

        Quotes[] testCase = gson.fromJson(br, Quotes[].class);
        int radnomQuote = (int)(Math.random()*(testCase.length-1));
        return "Name Of Author: "+testCase[radnomQuote].getAuthor() + "\nThe Quote : " + testCase[radnomQuote].getText() ;
    }

    public void insertDataInFile(String author , String text , String quotesFile) throws Exception{
        FileReader file = new FileReader(quotesFile);
        BufferedReader fileData = new BufferedReader(file);
        String newData = "";
        String s = "";
        while ((s=fileData.readLine())!=null){
            newData+=s+"\n" ;
        }
        file.close();
        fileData.close();
        String newStr = newData.substring(0 , newData.length()-3);
        String addedQuote = String.format(",\n{\n\"author\":\"%s\",\n\"text\":\"%s\"\n}\n]" , author , text);
        newStr+=addedQuote ;
        FileWriter fileWriter = new FileWriter(quotesFile);
        BufferedWriter newFile = new BufferedWriter(fileWriter);
        newFile.write(newStr);
        newFile.close();
    }
}
