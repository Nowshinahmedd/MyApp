package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioActivity extends AppCompatActivity {

    private CheckBox pizza, burger, pasta, salad;
    private RadioGroup radioGroupDrinks;
    private TextView quantityTextView;
    private TextView priceTextView;
    private Button orderButton;
    private RatingBar ratingBar;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch feedbackSwitch;
    private EditText feedbackEditText;

    private int quantity = 0;
    private final int pricePerItem = 200;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Change to your actual layout file name

        // Initialize UI components
        pizza = findViewById(R.id.pizza);
        burger = findViewById(R.id.burger);
        pasta = findViewById(R.id.pasta);
        salad = findViewById(R.id.salad);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        TextView selectedFoods = findViewById(R.id.selectedFoods);
        quantityTextView = findViewById(R.id.quantityTextView);
        priceTextView = findViewById(R.id.priceTextView);
        ratingBar = findViewById(R.id.ratingBar);
        TextView rating = findViewById(R.id.rating);
        feedbackSwitch = findViewById(R.id.feedbackSwitch);
        feedbackEditText = findViewById(R.id.feedbackEditText);
        Button decrement = findViewById(R.id.decrement);
        Button increment = findViewById(R.id.increment);
        orderButton = findViewById(R.id.order_btn);

        // Set listeners
        decrement.setOnClickListener(v -> {
            if (quantity > 0) {
                quantity--;
                updateQuantityAndPrice();
            } else {
                Toast.makeText(RadioActivity.this, "Cannot decrease below 0", Toast.LENGTH_SHORT).show();
            }
        });

        increment.setOnClickListener(v -> {
            quantity++;
            updateQuantityAndPrice();
        });

        // Feedback switch listener
        feedbackSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                feedbackEditText.setVisibility(View.VISIBLE);
            } else {
                feedbackEditText.setVisibility(View.GONE);
            }
        });

        // Order button listener
        orderButton.setOnClickListener(v -> {
            StringBuilder selectedItems = new StringBuilder("Selected Foods: ");
            if (pizza.isChecked()) selectedItems.append("Pizza ");
            if (burger.isChecked()) selectedItems.append("Burger ");
            if (pasta.isChecked()) selectedItems.append("Pasta ");
            if (salad.isChecked()) selectedItems.append("Salad ");

            int selectedDrinkId = radioGroupDrinks.getCheckedRadioButtonId();
            RadioButton selectedDrink = findViewById(selectedDrinkId);
            if (selectedDrink != null) {
                selectedItems.append("\nDrink: ").append(selectedDrink.getText());
            } else {
                selectedItems.append("\nDrink: None");
            }

            selectedItems.append("\nQuantity: ").append(quantity);
            selectedItems.append("\nTotal Price: BDT ").append(quantity * pricePerItem);
            selectedItems.append("\nRating: ").append(ratingBar.getRating());

            String feedback = feedbackSwitch.isChecked() ? feedbackEditText.getText().toString() : "No feedback provided.";

            // Show summary in a Toast
            Toast.makeText(RadioActivity.this, selectedItems.toString() + "\nFeedback: " + feedback, Toast.LENGTH_LONG).show();
        });
    }

    private void updateQuantityAndPrice() {
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText("BDT " + (quantity * pricePerItem));
    }
}
