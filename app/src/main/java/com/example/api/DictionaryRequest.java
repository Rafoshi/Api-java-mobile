package com.example.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DictionaryRequest extends AsyncTask<String,Integer,String> {

    final String app_id = "e7894443";
    final String app_key = "84ff4daccd68dbfe6709fb9a37add7ee";
    String myUrl;
    Context context;

    DictionaryRequest(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        myUrl = params[0];
        try {
            URL url = new URL(myUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String def;
        String def2;
        try{
            JSONObject js = new JSONObject(s);
            JSONArray results = js.getJSONArray("results");

            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries");

            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries");

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");

            JSONObject d = sensesArray.getJSONObject(0);
            JSONArray de = d.getJSONArray("definitions");

            def = de.getString(0);

            Toast.makeText(context, def, Toast.LENGTH_SHORT).show();

        }catch(JSONException e){
            e.printStackTrace();
        }

        try{
            JSONObject js = new JSONObject(s);
            JSONArray results = js.getJSONArray("results");

            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries");

            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries");

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");

            JSONObject d = sensesArray.getJSONObject(0);
            JSONArray de = d.getJSONArray("subsenses");

            JSONObject vv = sensesArray.getJSONObject(0);
            JSONArray dev = dvv.getJSONArray("definitions");

            def2 = dev.getString(0);

            Toast.makeText(context, def2, Toast.LENGTH_SHORT).show();

        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}