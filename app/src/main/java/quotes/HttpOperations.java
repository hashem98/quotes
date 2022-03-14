package quotes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpOperations {
    private String url ;
    private String method ;
    private String data ;

    public HttpOperations(String url){
        this.url = url ;
    }
    public HttpOperations(String url , String method){
        this.url = url ;
        this.method = method.toUpperCase();
    }

    public void setUrl(String url){
        this.url = url ;
    }
    public void setMethod(String method){
        this.method = method.toUpperCase() ;
    }

    public String startConnection() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestMethod(this.method);
        request.setConnectTimeout(5000);
        request.setReadTimeout(5000);
        int resCode ;
        try {
            resCode = request.getResponseCode() ;
        } catch (Exception e){
            resCode = -1 ;
        }
        if(resCode != HttpURLConnection.HTTP_OK) return "failed";
        InputStreamReader reader = new InputStreamReader(request.getInputStream());
        BufferedReader data = new BufferedReader(reader);
        StringBuilder requestedData = new StringBuilder();
        String read = "";
        while((read = data.readLine())!=null){
            requestedData.append(read);
        }
        request.disconnect();
        this.data = requestedData.toString();
        return "success" ;
    }
    public String getData(){
        return this.data ;
    }
}
