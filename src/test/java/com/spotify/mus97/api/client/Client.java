package com.spotify.mus97.api.client;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Client {
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private HttpPost request;
    private String token = "Bearer BQAje98myA9LOf3-HZobWQOD27jYjMRMYvLnOKXH_aHEfhdyuOkIgzjnlmkGfS97QdwTJ5Op37KgfL_4LGDvJv1LzGgB8uYmO6lQQhRDyNYx-NNuwnoTD0NhpfwWm9grf9mNFqoQ0Oza9Lk2cp8tiA4yx2xXLFhkWDcW-Igzxw3JfEed-qNlgJnRsL6WYK162tsrKSEeAG146RbJanpuMCeFBdELa_V7fuURLoOc33B3Iduo3bLT2jSpTOZZAY33tmPMgb3Rgl7zhsCFEwgUszeNIpLxUFsMJ473e2cXnaQAQn1kRomm";

    private int statusCode;
    private String body;
    private static final Logger logger = LogManager.getLogger();


    public Client() {
        client = HttpClientBuilder.create().setDefaultHeaders(Arrays.asList(new BasicHeader("Authorization", token))).build();
    }

    public void sendGet(String url) {
        try {
            response = client.execute(new HttpGet(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
    public void sendPost(String url, StringEntity params) {
        try {
            request = new HttpPost(url);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            response = client.execute(request);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
    public void sendPut(String url) {
        try {
            response = client.execute(new HttpPut(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
    public void sendDelete(String url) {
        try {
            response = client.execute(new HttpDelete(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        logger.info("Status code: " + statusCode);
        return statusCode;
    }

    public String getBody() {
        try {
//            InputStream bodyAsInputStream = response.getEntity().getContent();
//            body = new BufferedReader(
//                    new InputStreamReader(bodyAsInputStream, StandardCharsets.UTF_8))
//                    .lines()
//                    .collect(Collectors.joining("\n"));

            body = EntityUtils.toString(response.getEntity());
            logger.info(body);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return body;
    }

    public List<String> getListBodyValuesByKey(String key) {
        List<String> valuesList = new ArrayList<>();
        if (body.startsWith("[")){
            JSONArray jsonArray = new JSONArray(body);
            List<JSONObject> jsonObjectList = new ArrayList<>();
            for (Object jsonObject : jsonArray) {
                jsonObjectList.add( ((JSONObject) jsonObject).getJSONObject(key));
            }for (JSONObject jsonObject : jsonObjectList) {
                valuesList.add(jsonObject.optString(key));
            }
        }
        else {
            JSONObject jsonObject = new JSONObject(body);
            valuesList.add(jsonObject.optString(key));
        }
        logger.info(valuesList);
        return valuesList;
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

}
