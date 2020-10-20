package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int jumlah = 0;
EditText namaEditText;
String nama;
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
        CheckBox sausCheckbox = (CheckBox) findViewById(R.id.saus_checkbox);
        CheckBox gulaCheckbox = (CheckBox) findViewById(R.id.gula_checkbox);
        namaEditText = (EditText) findViewById(R.id.edit_nama);

        boolean hassaus = sausCheckbox.isChecked();
        boolean hasgula = gulaCheckbox.isChecked();
        nama = namaEditText.getText().toString();

        int price = calculatePrice(hassaus, hasgula);

        String priceMessage = "Segini niih...\n";
        priceMessage = priceMessage + "\nJumlah Pembelian: "+ jumlah + " Biji" +
                        "\nSaus: " + hassaus +
                        "\nGula: " + hasgula +
                        "\nTotal Pembelian Rp: "+ price +
                        "\n\nNuhuuuun, " + nama;

        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean addhassaus, boolean addhasgula) {
        int hargaawal = 2000;
        int harga = 0;

        if(addhassaus){
            hargaawal = hargaawal + 1000;
        }
        if(addhasgula){
            hargaawal = hargaawal + 500;
        }
        return harga = jumlah * hargaawal;
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