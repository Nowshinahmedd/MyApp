package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare the buttons, text view, and image view
    private Button buttonShowText, buttonShowImage, buttonGoToRadioActivity,
            buttonGoToFormActivity, buttonGoToCheckActivity, buttonGoToRecyclerActivity;
    private TextView textViewMessage;
    private ImageView imageViewExample;
    private CheckBox checkBox;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        buttonShowText = findViewById(R.id.buttonShowText);
        buttonShowImage = findViewById(R.id.buttonShowImage);
        textViewMessage = findViewById(R.id.textViewMessage);
        imageViewExample = findViewById(R.id.imageViewExample);
        buttonGoToRadioActivity = findViewById(R.id.buttonGoToRadioActivity);
        buttonGoToFormActivity = findViewById(R.id.buttonGoToFormActivity);
        buttonGoToCheckActivity = findViewById(R.id.buttonGoToCheckActivity);
        buttonGoToRecyclerActivity = findViewById(R.id.buttonGoToRecyclerActivity);
        checkBox = findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);

        // Initially hide message and image
        textViewMessage.setVisibility(View.GONE);
        imageViewExample.setVisibility(View.GONE);

        // Set up click listener for "Show Text" button
        buttonShowText.setOnClickListener(v -> {
            textViewMessage.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Text Shown", Toast.LENGTH_SHORT).show();
        });

        // Set up click listener for "Show Image" button
        buttonShowImage.setOnClickListener(v -> {
            imageViewExample.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Image Shown", Toast.LENGTH_SHORT).show();
        });

        // Set up click listener for "Go to Radio Activity" button
        buttonGoToRadioActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RadioActivity.class);
            startActivity(intent);
        });

        // Set up click listener for "Fill The Form" button
        buttonGoToFormActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
        });

        // Set up click listener for "Check list view" button
        buttonGoToCheckActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        // Set up click listener for "Go to RecyclerView" button
        buttonGoToRecyclerActivity.setOnClickListener(v -> {
            // Navigate to RecyclerActivity
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });
    }
}
