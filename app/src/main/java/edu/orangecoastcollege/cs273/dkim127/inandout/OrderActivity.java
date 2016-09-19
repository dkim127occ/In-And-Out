package edu.orangecoastcollege.cs273.dkim127.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity {

    // model
    private Order currentOrder = new Order();

    // views
    private TextView doubleDoubleTextView,
            cheeseburgerTextView,
            frenchFriesTextView,
            shakesTextView,
            drinkSmallTextView,
            drinkMediumTextView,
            drinkLargeTextView;

    private EditText doubleDoubleEditText,
            cheeseburgerEditText,
            frenchFriesEditText,
            shakesEditText,
            drinkSmallEditText,
            drinkMediumEditText,
            drinkLargeEditText;

    private Button placeOrderButton;

    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        doubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        cheeseburgerEditText = (EditText) findViewById(R.id.cheeseburgerEditText);
        frenchFriesEditText = (EditText) findViewById(R.id.frenchFriesEditText);
        shakesEditText = (EditText) findViewById(R.id.shakesEditText);
        drinkSmallEditText = (EditText) findViewById(R.id.drinkSmallEditText);
        drinkMediumEditText = (EditText) findViewById(R.id.drinkMediumEditText);
        drinkLargeEditText = (EditText) findViewById(R.id.drinkLargeEditText);

        doubleDoubleTextView = (TextView) findViewById(R.id.doubleDoubleTextView);
        cheeseburgerTextView = (TextView) findViewById(R.id.cheeseburgerTextView);
        frenchFriesTextView = (TextView) findViewById(R.id.frenchFriesTextView);
        shakesTextView = (TextView) findViewById(R.id.shakesTextView);
        drinkSmallTextView = (TextView) findViewById(R.id.drinkSmallTextView);
        drinkMediumTextView = (TextView) findViewById(R.id.drinkMediumTextView);
        drinkLargeTextView = (TextView) findViewById(R.id.drinkLargeTextView);

        placeOrderButton = (Button) findViewById(R.id.placeOrderButton);

        // oh my god why
        TextView[] texts = {doubleDoubleTextView, cheeseburgerTextView, frenchFriesTextView,
        shakesTextView,drinkSmallTextView, drinkMediumTextView, drinkLargeTextView};
        EditText[] fields = {doubleDoubleEditText, cheeseburgerEditText, frenchFriesEditText,
        shakesEditText, drinkSmallEditText, drinkMediumEditText, drinkLargeEditText};
        int i = 0;
        for (final Menu menu : Menu.values())
        {
            texts[i].setText(texts[i].getText().toString() + formatter.format(menu.getPrice()));

            fields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {
                        if (s.length() > 0)
                            currentOrder.setOrderCount(menu, Integer.parseInt(s.toString()));
                        else
                            currentOrder.setOrderCount(menu, 0);
                    }
                    catch (NumberFormatException e)
                    {
                        currentOrder.setOrderCount(menu, 0);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            i++;
        }


    }

    /**
     * Constructs an intent to pipe all data to SummaryActivity, packages all relevant data into it,
     * and then starts the SummaryActivity.
     * @param view
     */
    public void startSummary(View view)
    {
        Intent orderIntent = new Intent(this, SummaryActivity.class);

        orderIntent.putExtra(Keys.SUBTOTAL.toString(), currentOrder.getSubTotal());
        orderIntent.putExtra(Keys.TOTAL.toString(), currentOrder.getTotal());
        orderIntent.putExtra(Keys.ITEMS.toString(), currentOrder.getTotalOrderCount());
        orderIntent.putExtra(Keys.TAX.toString(), currentOrder.getTax());

        Log.d("startSummary", "This had better be an actual string value or I'm going to be really ticked off: " + Keys.SUBTOTAL);

        startActivity(orderIntent);
    }

}
