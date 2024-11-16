package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonShowText;
    private Button buttonShowImage;
    private Button buttonGoToRadioActivity;
    private Button buttonGoToFormActivity;
    private Button buttonGoToCheckActivity;
    private TextView textViewMessage;
    private ImageView imageViewExample;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonShowText = findViewById(R.id.buttonShowText);
        buttonShowImage = findViewById(R.id.buttonShowImage);
        textViewMessage = findViewById(R.id.textViewMessage);
        imageViewExample = findViewById(R.id.imageViewExample);
        buttonGoToRadioActivity = findViewById(R.id.buttonGoToRadioActivity);
        buttonGoToFormActivity = findViewById(R.id.buttonGoToFormActivity);
        buttonGoToCheckActivity = findViewById(R.id.buttonGoToCheckActivity);



        textViewMessage.setVisibility(View.GONE);
        imageViewExample.setVisibility(View.GONE);


        buttonShowText.setOnClickListener(v -> {
            textViewMessage.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Text Shown", Toast.LENGTH_SHORT).show();
        });

        buttonShowImage.setOnClickListener(v -> {
            imageViewExample.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Image Shown", Toast.LENGTH_SHORT).show();
        });


        buttonGoToRadioActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RadioActivity.class);
            startActivity(intent);
        });
        buttonGoToFormActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
        });
        buttonGoToCheckActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });
    }
}
