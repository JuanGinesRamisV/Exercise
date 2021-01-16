package com.example.exercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDataPickers extends AppCompatActivity implements TimePickerFragment.Mensajero,
        DatePickerFragment.MensajeroDate {
    public int hola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_data_pickers);
    }

    public void alertMethod(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("hola");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"you have selected OK",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"you have selected CANCEL",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setMessage("Click OK to continue, or Cancel to stop:");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void timeButtonMethod(View button){
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(),"Time Picker");
    }

    public void dateButtonMethod(View button){
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"Date Picker");
    }

    @Override
    public void enviarHora(String hola) {
        Toast.makeText(getApplicationContext(),hola,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void enviarDate(String date) {
        Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();
    }
}