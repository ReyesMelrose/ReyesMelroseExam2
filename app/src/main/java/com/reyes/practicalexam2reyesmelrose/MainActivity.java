package com.reyes.practicalexam2reyesmelrose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ACTIVITY REGISTRATION");
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        et1 = findViewById(R.id.editText);
    }
    public void writeData (View v) {
        String cbt1 = cb1.getText().toString();
        String cbt2 = cb2.getText().toString();
        String cbt3 = cb3.getText().toString();
        String cbt4 = cb4.getText().toString();
        String cbt5 = cb5.getText().toString();
        String cbt6 = cb6.getText().toString();
        String cbt7 = cb7.getText().toString();
        String cbt8 = cb8.getText().toString();
        String input1 = et1.getText().toString();

        FileOutputStream writer = null;
        try {
                writer = openFileOutput("data.txt", MODE_PRIVATE);
                if (cb1.isChecked()) {
                    writer.write(cbt1.getBytes());
                }
                if (cb2.isChecked()) {
                    writer.write(cbt2.getBytes());
                }
                if (cb3.isChecked()) {
                    writer.write(cbt3.getBytes());
                }
                if (cb4.isChecked()) {
                    writer.write(cbt4.getBytes());
                }
                if (cb5.isChecked()) {
                    writer.write(cbt5.getBytes());
                }
                if (cb6.isChecked()) {
                    writer.write(cbt6.getBytes());
                }
                if (cb7.isChecked()) {
                    writer.write(cbt7.getBytes());
                }
                if (cb8.isChecked()) {
                    writer.write(cbt8.getBytes());
                }
            writer.write(input1.getBytes());
            } catch (FileNotFoundException e) {
                Log.d("error", "writeData: File not found...");
            } catch (IOException e) {
                Log.d("error", "writeData: IO error...");
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    Log.d("error", "writeData: File not found...");
                }
            }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }
        public void next(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
