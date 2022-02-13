package com.example.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainAcitivity","Has Whipped Cream: " + hasWhippedCream);


        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkBoxChocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainAcitivity","Has Chocolate: " + hasChocolate);

        CheckBox cinnamonCheckBox = (CheckBox) findViewById(R.id.checkBoxCinnamon);
        boolean hasCinnamon = cinnamonCheckBox.isChecked();

        CheckBox iceCreamCheckBox = (CheckBox) findViewById(R.id.checkBoxIceCream);
        boolean hasIceCream = iceCreamCheckBox.isChecked();


        EditText text = (EditText) findViewById(R.id.album_description_view);
        String value = text.getText().toString();
        Log.v("MainActivity", "Name:" + value);

        CheckBox Cake = (CheckBox) findViewById(R.id.carrotCake);
        boolean hasCake = Cake.isChecked();

        CheckBox Crossoient = (CheckBox) findViewById(R.id.Crossoient);
        boolean hasCrossoient = Crossoient.isChecked();

        CheckBox Donut = (CheckBox) findViewById(R.id.Donut);
        boolean hasDonut = Cake.isChecked();

        CheckBox Pasteries = (CheckBox) findViewById(R.id.Pasteries);
        boolean hasPasteries = Pasteries.isChecked();





       int price = calculatePrice(hasWhippedCream, hasChocolate,hasCinnamon, hasIceCream , hasCake, hasCrossoient, hasDonut, hasPasteries);
       String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, value,hasCinnamon, hasIceCream,hasCake, hasCrossoient, hasPasteries, hasDonut);
       displayMessage(priceMessage);

    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate, boolean hasCinnamon, boolean hasIceCream, boolean hasCake, boolean hasDonut, boolean hasCrossoient, boolean hasPasteries) {

        int basePrice = 5;

        if( hasWhippedCream) {
            basePrice +=1;
        }
        if(hasChocolate) {
            basePrice +=1;
        }
        if(hasCinnamon) {
            basePrice +=1;
        }
        if(hasIceCream) {
            basePrice +=1;
        }
        if(hasCake) {
            basePrice +=10;
        }
        if(hasCrossoient) {
            basePrice +=7;

        }
        if(hasDonut) {
            basePrice +=4;
        }
        if(hasPasteries) {
            basePrice +=15;
        }
        return quantity * basePrice;
    }



    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;

        display(quantity);


    }


    public void decrement(View view) {
        if(quantity ==1) {
            Toast.makeText(this, "You cannot have less than 1 coffees", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        display(quantity);

    }

    public String createOrderSummary(int price , boolean hasWhippedCream, boolean hasChocolate, String value, boolean hasCinnamon, boolean hasIcecream, boolean hasCake, boolean hasDonut, boolean hasCrossoient, boolean hasPasteries) {

        String priceMessage =  "Name : "+ value   +"\nAdd Whipped Cream: "+hasWhippedCream+ "\nAdd Chocolate: "+ hasChocolate +"\nAdd Cinnamon:"+hasCinnamon+"\nAdd Ice Cream:"+hasIcecream+"\nAdd Cake:"+hasCake+"\nAdd Donut:"+hasDonut+"\nAdd Crossoient:"+hasCrossoient+"\nAdd Pasteries:"+hasPasteries+"\nQuantity:" + quantity + "\nTotal:$" + price + "\nThank You";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + num);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
