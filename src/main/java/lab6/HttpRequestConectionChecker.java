package lab6;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpRequest;

public class HttpRequestConectionChecker {
    private URL url;
    public HttpRequestConectionChecker(URL url) {
        this.url = url;
    }
    public void tryConnection(){
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        catch (Exception e){
            throw new IllegalConditionException("Cannot connect to " + this.url.toString());
        }
    }
}
