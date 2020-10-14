package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int jumlah = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        jumlah = jumlah + 1;
        display(jumlah);
    }

    public void decrement(View view) {
        if (jumlah > 0 == false) {
        } else {
            jumlah = jumlah - 1;
            display(jumlah);
        }
    }
    public void submitOrder(View view) {
        int price = jumlah * 1000;
        String priceMessage = "Segini niih";
        priceMessage = priceMessage + "\nRp "+ price;
        priceMessage = priceMessage + "\nNuhuuuunn";
        displayMessage(priceMessage);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.harga_text_view);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView jumlahTextView = (TextView) findViewById(R.id.jumlah_text_view);
        jumlahTextView.setText("" + number + " Biji");
    }

    private void displayHarga(int number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
            TextView hargaTextView = (TextView) findViewById(R.id.harga_text_view);
            hargaTextView.setText(formatRupiah.format(number));
    }
}