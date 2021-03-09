package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  DataBaseHelper db;

    Button btn_search,btn_add,btn_all;
    EditText editWord;
    String url;
    ListView list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);

        btn_all = findViewById(R.id.btnAll);
        btn_search = findViewById(R.id.btnSearch);
        btn_add = findViewById(R.id.btnView);
        editWord = findViewById(R.id.editTextWord);
        list = findViewById(R.id.list);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerModel cm = new CustomerModel();
                cm.setDefinition(editWord.getText().toString());
                db.addData(cm);

                Toast.makeText(getBaseContext(), "Resultado salvo com sucesso no Banco de Dados", Toast.LENGTH_SHORT).show();
            }
        });

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                List<CustomerModel> everyone = dataBaseHelper.getEveryone();

                ArrayAdapter customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                list.setAdapter(customerArrayAdapter);

//                Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void requestApiButtonClick(View v){
        url = dictionaryEntries();
        DictionaryRequest dictionaryRequest =  new DictionaryRequest(this);
        dictionaryRequest.execute(url);
    }

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = editWord.getText().toString();
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
}