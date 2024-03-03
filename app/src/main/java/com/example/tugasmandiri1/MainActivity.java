package com.example.tugasmandiri1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup itmRadioGroup, membershipRadioGroup;    private RadioButton selectedRadioButtonItem, selectedRadioButtonMembership;
    private TextView resultTextView;    private Button btnProcess;
    private double itemPrice = 0;
    private double adminFee = 0;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);
        itmRadioGroup = findViewById(R.id.itmRadioGroup);
        membershipRadioGroup = findViewById(R.id.membershipRadioGroup);        resultTextView = findViewById(R.id.result_text_view);
        btnProcess = findViewById(R.id.btnProcess);
        btnProcess.setOnClickListener(new View.OnClickListener() {            @Override
        public void onClick(View v) {                calculateTotal();
        }        });
    }
    private void calculateTotal() {        int selectedItemId = itmRadioGroup.getCheckedRadioButtonId();
        int selectedMembershipId = membershipRadioGroup.getCheckedRadioButtonId();
        if (selectedItemId == -1 || selectedMembershipId == -1) {            Toast.makeText(getApplicationContext(), "Pilih barang dan keanggotaan terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;        }
        selectedRadioButtonItem = findViewById(selectedItemId);
        selectedRadioButtonMembership = findViewById(selectedMembershipId);
        String itemName = selectedRadioButtonItem.getText().toString();        String membershipType = selectedRadioButtonMembership.getText().toString();
        switch (itemName) {
            case "Pulsa":                itemPrice = 20000;
                adminFee = 2000;                break;
            case "Token":                itemPrice = 50000;
                adminFee = 2500;                break;
            case "Emoney":                itemPrice = 100000;
                adminFee = 3000;                break;
        }
        double totalBeforeDiscount = itemPrice + adminFee;        double discount = 0;
        if (membershipType.equals("Membership")) {
            discount = totalBeforeDiscount * 0.05;        }
        double totalAfterDiscount = totalBeforeDiscount - discount;
        String result = "Nama Barang: " + itemName +
                "\nBanyak Barang: 1" +                "\nTotal Harga Barang: " + itemPrice +
                "\nBiaya Admin: " + adminFee +                "\nDiskon: " + discount +
                "\nTotal Bayar: " + totalAfterDiscount;
        resultTextView.setText(result);    }
}