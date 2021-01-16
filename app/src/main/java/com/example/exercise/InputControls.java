package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InputControls extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner phonePlaceSpinner;
    private boolean firstRun=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);

        initializeSpinner();
    }

    public void showTextCapSentence(View btn){
        TextView aux = findViewById(R.id.textCapEditText);
        Toast.makeText(getApplicationContext(),aux.getText(),Toast.LENGTH_SHORT).show();
    }

    public void showEmail(View btn){
        TextView aux = findViewById(R.id.emailEditText);
        Toast.makeText(getApplicationContext(),aux.getText(),Toast.LENGTH_SHORT).show();
    }

    public void initializeSpinner(){
        this.phonePlaceSpinner = findViewById(R.id.spinnerPhone);
        this.phonePlaceSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (this.firstRun){
            this.firstRun=false;
        }else{
            TextView textView = findViewById(R.id.phoneNumberText);
            EditText phoneNumber = findViewById(R.id.phoneEditText);
            textView.setText("Phone number: "+phoneNumber.getText()+ " - "+adapterView.getItemAtPosition(i).toString());
            Toast.makeText(getApplicationContext(),phoneNumber.getText()+" - "+
                    adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}