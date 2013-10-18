package se.citerus.labs;

import org.json.JSONException;
import org.json.JSONObject;

import static se.citerus.labs.HttpRequester.put;

public class HueController {

    private final String apiUrl;
    private final String username;
    private int lightId;

    public HueController(String apiUrl, String username, int lightId) {
        this.apiUrl = apiUrl;
        this.username = username;
        this.lightId = lightId;
    }

    public void on() {
        putState(asJson("on", true));
    }

    public void off() {
        putState(asJson("on", false));
    }

    private JSONObject asJson(String key, boolean value) {
        try {
            return new JSONObject().put(key, value).put("transitiontime", 1);
        } catch (JSONException e) {
            throw new RuntimeException("Json error", e);
        }
    }

    private void putState(JSONObject jsonObject) {
        put(apiUrl + username + "/lights/" + lightId + "/state", jsonObject);
    }
}
