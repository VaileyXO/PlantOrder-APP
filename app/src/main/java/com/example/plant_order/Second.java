package com.example.plant_order;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
//    public static
    public static final String EXTRA_MESSAGE = "com.example.plant_order.extra.MESSAGE";
    public static final String EXTRA_PRODUCT = "com.example.plant_order.extra.MESSAGE";
//    private int
    private String product;
    private int totalQty = 0;
    private int intQty1 = 0, intQty2 = 0, intQty3 = 0, intQty4=0;
    private int priceQty1 = 33, priceQty2 = 15, priceQty3= 25, priceQty4=39;
    private int leftQty1 = 50, leftQty2 = 23, leftQty3 = 60, leftQty4 = 44;
    private int subtotal = 0;
    private int[] products = {0,0,0,0,0};
//    private String
    private String show_id;
    private String show_leftId;
//    private TextView
    private TextView totalSelected;
    private TextView subtotalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        qty1 = (TextView) findViewById(R.id.quantity1);
        totalSelected = (TextView) findViewById(R.id.textView_itemSelected);
        subtotalPrice = (TextView) findViewById(R.id.textView_pricesubtotal);
        setSupportActionBar(toolbar);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }



    public void checkOut(View view) {
            products[0]=intQty1;
            products[1]=intQty2;
            products[2]=intQty3;
            products[3]=intQty4;
            products[4]=subtotal;
        if (intQty1>0 || intQty2>0||intQty3>0||intQty4>0){
            Intent thirdIntent = new Intent(Second.this, Third.class);
            String subtotal_String = subtotalPrice.getText().toString();
            thirdIntent.putExtra(EXTRA_MESSAGE, subtotal_String);
            thirdIntent.putExtra(EXTRA_PRODUCT, products);
            startActivity(thirdIntent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Please select an item",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void validateId(View view){
        switch(view.getId()) {
            case R.id.plus1:
                show_id = "quantity1";
                show_leftId ="qtyLeft1";
                plusInc();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.minus1:
                show_id = "quantity1";
                show_leftId ="qtyLeft1";
                minusDec();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.plus2:
                show_id = "quantity2";
                show_leftId ="qtyLeft2";
                plusInc();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.minus2:
                show_id = "quantity2";
                show_leftId ="qtyLeft2";
                minusDec();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.plus3:
                show_id = "quantity3";
                show_leftId ="qtyLeft3";
                plusInc();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.minus3:
                show_id = "quantity3";
                show_leftId ="qtyLeft3";
                minusDec();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.plus4:
                show_id = "quantity4";
                show_leftId ="qtyLeft4";
                plusInc();
                calculateSubtotal();
                updateInt();
                break;
            case R.id.minus4:
                show_id = "quantity4";
                show_leftId ="qtyLeft4";
                minusDec();
                calculateSubtotal();
                updateInt();
                break;
        }
    }
    public void calculateSubtotal(){
        subtotal = priceQty1*intQty1+priceQty2*intQty2+priceQty3*intQty3+priceQty4*intQty4;
    }
    public void plusInc() {
        if(show_id == "quantity1" && leftQty1>0){
            ++intQty1;
            --leftQty1;
            ++totalQty;
        }
        else if (show_id == "quantity2"&& leftQty2>0) {
            ++intQty2;
            --leftQty2;
            ++totalQty;
        }
        else if (show_id == "quantity3"&& leftQty3>0) {
            ++intQty3;
            --leftQty3;
            ++totalQty;
        }
        else if (show_id == "quantity4"&& leftQty4>0) {
            ++intQty4;
            --leftQty4;
            ++totalQty;
        }
    }

    public void minusDec() {
        if(show_id == "quantity1"){
            if(intQty1 > 0){
                --intQty1;
                --totalQty;
                ++leftQty1;
            }
        }
        else if (show_id == "quantity2"){
            if(intQty2 > 0){
                --intQty2;
                --totalQty;
                ++leftQty2;
            }
        }

        else if (show_id == "quantity3"){
            if(intQty3 > 0){
                --intQty3;
                --totalQty;
                ++leftQty3;
            }
        }

        else if (show_id == "quantity4"){
            if(intQty4 > 0){
                --intQty4;
                --totalQty;
                ++leftQty4;
            }
        }

    }

    public void updateInt() {
        int resID = getResources().getIdentifier(show_id, "id", getPackageName());
        int resLeftID = getResources().getIdentifier(show_leftId, "id", getPackageName());
        TextView field_id, field_leftId;
        field_id = (TextView) findViewById(resID);
        field_leftId = (TextView) findViewById(resLeftID);

        if (show_id == "quantity1") {
            field_id.setText(Integer.toString(intQty1));
            field_leftId.setText(Integer.toString(leftQty1) + " Left");
        } else if (show_id == "quantity2") {
            field_id.setText(Integer.toString(intQty2));
            field_leftId.setText(Integer.toString(leftQty2) + " Left");
        } else if (show_id == "quantity3") {
            field_id.setText(Integer.toString(intQty3));
            field_leftId.setText(Integer.toString(leftQty3) + " Left");
        } else if (show_id == "quantity4") {
            field_id.setText(Integer.toString(intQty4));
            field_leftId.setText(Integer.toString(leftQty4) + " Left");
        }
        totalSelected.setText("[ " + Integer.toString(totalQty) + " Item Selected ]");
        subtotalPrice.setText("$ " + Integer.toString(subtotal) + ".00 ");
    }
    public void snakeplant(View view) {
        displayToast(getString(R.string.snake_plant_message));
    }

    public void pothos(View view) {
        displayToast(getString(R.string.pothos_message));
    }

    public void dracaena(View view) {
        displayToast(getString(R.string.dracaena_message));
    }

    public void philodendrongreen(View view) {
        displayToast(getString(R.string.philodendron_green_message));
    }

    public void share(View view) {
        String mimeType = "text/plain";
        switch (view.getId()){
            case R.id.imageButton1:
                product = getResources().getString(R.string.share_snake);
                break;
            case R.id.imageButton2:
                product = getResources().getString(R.string.share_pothos);
                break;
            case R.id.imageButton3:
                product = getResources().getString(R.string.share_dracaena);
                break;
            case R.id.imageButton4:
                product = getResources().getString(R.string.share_philo);
                break;
        }
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this product details with:")
                .setText(product)
                .startChooser();
    }
}
