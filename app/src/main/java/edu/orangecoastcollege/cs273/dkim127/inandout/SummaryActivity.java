package edu.orangecoastcollege.cs273.dkim127.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class SummaryActivity extends AppCompatActivity {

    private TextView orderTotalTextView;
    private TextView itemsOrderedTextView;
    private TextView subtotalTextView;
    private TextView taxTextView;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // link views & control
        orderTotalTextView = (TextView) findViewById(R.id.orderTotalTextView);
        itemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        subtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        taxTextView = (TextView) findViewById(R.id.taxTextView);

        /* orderTotalTextView.setText(
        String.format(
                getString(R.string.order_total),
                formatter.format(intent.getDoubleExtra(Keys.TOTAL.toString(), 0.0)))); */
        Intent intent = getIntent();
        orderTotalTextView.setText(getString(R.string.order_total) +
                formatter.format(intent.getDoubleExtra(Keys.TOTAL.toString(), 0.0)));
        itemsOrderedTextView.setText(getString(R.string.items_ordered) +
                intent.getIntExtra(Keys.ITEMS.toString(), 0));
        subtotalTextView.setText(getString(R.string.subtotal) +
                formatter.format(intent.getDoubleExtra(Keys.SUBTOTAL.toString(), 0.0)));
        taxTextView.setText(getString(R.string.tax) +
                formatter.format(intent.getDoubleExtra(Keys.TAX.toString(), 0.0)));

    }

    /**
     * Ends the current Activity and returns to the previous one.
     * @param view
     */
    public void endCurrentIntent (View view)
    {
        this.finish();
    }
}
