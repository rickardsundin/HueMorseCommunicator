package se.citerus.labs;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONObject;

public class HttpRequester {

    public static int put(String url, JSONObject jsonObject) {
        PutMethod put = new PutMethod(url);
        try {
            put.setRequestEntity(new StringRequestEntity(jsonObject.toString(), "application/json", "UTF-8"));
            HttpClient httpclient = new HttpClient();
            return httpclient.executeMethod(put);
        } catch (Exception e) {
            throw new RuntimeException("Http error: ", e);
        } finally {
            put.releaseConnection();
        }
    }
}
