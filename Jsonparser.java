package com.example.bilal.myapp;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.security.PublicKey;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Bilal on 6/30/2017.
 */

 public class Jsonparser {

    final OkHttpClient client= new OkHttpClient();
    MediaType JSON;
    JSONArray jarray;

    public void Jsonparser() {
        jarray=new JSONArray();
        JSON = MediaType.parse("application/json; charset=utf-8");
    }

    public void makeGetRequest(String url)  {
        GetTask task = new GetTask();
        task.execute(url);
    }


    public class GetTask extends AsyncTask<String, Void, String>  {
        private Exception exception;

        protected String doInBackground(String... params) {
            try {
                String url=params[0];
                String getResponse = get(url);
                return getResponse;
            } catch (Exception e) {
                this.exception = e;
                return "I am in exception";
            }
        }

        protected void onPostExecute(String getResponse)
        {
            System.out.println(getResponse);
            try {
                JSONObject jObj = new JSONObject(getResponse);
                jarray=jObj.getJSONArray("event");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            setResponseArray(jarray);
        }

        public String get(String url) {
            final String u=url;
            Request request = new Request.Builder()
                    .url(u)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }
            catch (Exception e)
            {
                System.out.println("I am in 2nd e xecption");
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
    public void setResponseArray(JSONArray jArray)
    {
        jarray=jArray;
    }

    public JSONArray getResponseArray()
    {
        return jarray;
    }
    public void makePostRequest(String []url) throws IOException {
        PostTask task = new PostTask();
        task.execute(url);
    }


    public class PostTask extends AsyncTask<String,Void,String> {

        private Exception exception;

        protected String doInBackground(String... urls)  {
            try {
                String url=urls[0];
                String data=urls[1];
                String getResponse = post(url, data);
                return getResponse;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        protected void onPostExecute(String getResponse) {
            System.out.println(getResponse);
        }

        private String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }

        }
    }
//    public String bowlingJson(String mail, String pass) {
//
//        return "{'email':'"+mail+"',"
//
//                + "'password':'"+pass+"',"+"}";
//
//    }
//
//

}



