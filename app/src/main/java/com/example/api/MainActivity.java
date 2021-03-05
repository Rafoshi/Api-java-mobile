package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn_serach,btn_add;
    EditText editWord;
//    ListView listView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_serach = findViewById(R.id.btnSearch);
        btn_add = findViewById(R.id.btnView);
        editWord = findViewById(R.id.editTextWord);
//        listView = findViewById(R.id.listView);
        url = dictionaryEntries();

    }

    public void requestApiButtonClick(View v){


        DictionaryRequest dictionaryRequest =  new DictionaryRequest(this);
        dictionaryRequest.execute(url);
    }

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = "order";
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
}