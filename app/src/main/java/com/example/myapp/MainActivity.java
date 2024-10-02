package com.example.myapp;

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
    private TextView textViewMessage;
    private ImageView imageViewExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        buttonShowText = findViewById(R.id.buttonShowText);
        buttonShowImage = findViewById(R.id.buttonShowImage);
        textViewMessage = findViewById(R.id.textViewMessage);
        imageViewExample = findViewById(R.id.imageViewExample);
        buttonGoToRadioActivity = findViewById(R.id.buttonGoToRadioActivity); // Fixed extra space
        buttonGoToFormActivity = findViewById(R.id.buttonGoToFormActivity); // Fixed extra space


        // Hide the image and text initially
        textViewMessage.setVisibility(View.GONE);
        imageViewExample.setVisibility(View.GONE);

        // Set a click listener for the button to show text
        buttonShowText.setOnClickListener(v -> {
            textViewMessage.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Text Shown", Toast.LENGTH_SHORT).show();
        });

        // Set a click listener for the button to show image
        buttonShowImage.setOnClickListener(v -> {
            imageViewExample.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Image Shown", Toast.LENGTH_SHORT).show();
        });

        // Set a click listener for the button to go to RadioActivity
        buttonGoToRadioActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RadioActivity.class);
            startActivity(intent); // Added missing semicolon
        });
        buttonGoToFormActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent); // Added missing semicolon
        });
    }
}
