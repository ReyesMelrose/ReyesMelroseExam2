package com.reyes.practicalexam2reyesmelrose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("CONFIRMATION");
        FileInputStream reader = null;
        String str = "";
        int token;
        try {
            reader = openFileInput("data.txt");
            while ((token = reader.read()) != -1) {
                str = str + (char)token;
            }
            reader.close();
            try {
                String[] list = str.split("_");
                ((TextView) (findViewById(R.id.textView12))).setText(list[0]);
                ((TextView) (findViewById(R.id.textView13))).setText(list[1]);
            } catch (Exception e) {
                Log.d("error", "onCreate: subject not found...");
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "onCreate: file not foumd...");
        } catch (IOException e) {
            Log.d("error", "onCreate: IO error");
        }
    }
    public void send(View v){
        setTitle("SUMMARY");
        Toast.makeText(this,"registration sent...", Toast.LENGTH_LONG).show();
    }

    public void previous(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
