package com.example.myapp;

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

    // Declare views
    private CheckBox pizzaCheckBox, burgerCheckBox, pastaCheckBox, saladCheckBox;
    private TextView selectedFoodsTextView, quantityTextView, priceTextView, ratingTextView;
    private RadioGroup radioGroupDrinks;
    private Button incrementButton, decrementButton, orderButton;
    private RatingBar ratingBar;
    private Switch feedbackSwitch;
    private EditText feedbackEditText;

    private int quantity = 0;
    private static final int PRICE_PER_ITEM = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);


        pizzaCheckBox = findViewById(R.id.pizza);
        burgerCheckBox = findViewById(R.id.burger);
        pastaCheckBox = findViewById(R.id.pasta);
        saladCheckBox = findViewById(R.id.salad);
        selectedFoodsTextView = findViewById(R.id.selectedFoods);
        quantityTextView = findViewById(R.id.quantityTextView);
        priceTextView = findViewById(R.id.priceTextView);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        incrementButton = findViewById(R.id.increment);
        decrementButton = findViewById(R.id.decrement);
        orderButton = findViewById(R.id.order_btn);
        ratingBar = findViewById(R.id.ratingBar);
        ratingTextView = findViewById(R.id.rating);
        feedbackSwitch = findViewById(R.id.feedbackSwitch);
        feedbackEditText = findViewById(R.id.feedbackEditText);


        View.OnClickListener foodListener = v -> {
            StringBuilder selectedFoods = new StringBuilder();
            if (pizzaCheckBox.isChecked()) selectedFoods.append("Pizza ");
            if (burgerCheckBox.isChecked()) selectedFoods.append("Burger ");
            if (pastaCheckBox.isChecked()) selectedFoods.append("Pasta ");
            if (saladCheckBox.isChecked()) selectedFoods.append("Salad ");
            selectedFoodsTextView.setText(selectedFoods.toString());
        };
        pizzaCheckBox.setOnClickListener(foodListener);
        burgerCheckBox.setOnClickListener(foodListener);
        pastaCheckBox.setOnClickListener(foodListener);
        saladCheckBox.setOnClickListener(foodListener);


        incrementButton.setOnClickListener(v -> {
            quantity++;
            updateQuantityAndPrice();
        });

        decrementButton.setOnClickListener(v -> {
            if (quantity > 0) {
                quantity--;
                updateQuantityAndPrice();
            } else {
                Toast.makeText(this, "Quantity cannot be less than 0", Toast.LENGTH_SHORT).show();
            }
        });


        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                ratingTextView.setText("Rating: " + rating));


        feedbackSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->
                feedbackEditText.setVisibility(isChecked ? View.VISIBLE : View.GONE));

        orderButton.setOnClickListener(v -> {
            String selectedDrink = ((RadioButton) findViewById(radioGroupDrinks.getCheckedRadioButtonId())).getText().toString();
            String feedback = feedbackEditText.getVisibility() == View.VISIBLE ? feedbackEditText.getText().toString() : "No feedback provided";
            Toast.makeText(this, "Order placed!\nDrink: " + selectedDrink + "\nFeedback: " + feedback, Toast.LENGTH_LONG).show();
        });
    }

    private void updateQuantityAndPrice() {
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText("BDT " + (quantity * PRICE_PER_ITEM));
    }
}
