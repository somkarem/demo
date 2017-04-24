package uk.gov.hmcts.todolist.app.util;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.inject.Inject;

public class JsonUtils {

    JSONParser parser;
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

    @Inject
    public void setJSONParser(JSONParser parser){
        this.parser = parser;
    }

    /**
     * Method used to transform a string to a JSONObject
     * @param jsonString the string to transform
     * @return the JSONObject or null when parsing fails
     */
    public JSONObject stringToJson(String jsonString) {
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            LOGGER.error("Error parsing jsonString to JSONObject", e);
        }
        return jsonObject;
    }
}
