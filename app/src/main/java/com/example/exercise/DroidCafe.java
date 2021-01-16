package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DroidCafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_cafe);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    /**
     * Display a toast message for the food order
     * and starts the OrderActivity
     * @param message Message to display
     */
    public void showFoodOrder(String message){
        displayToast(message);
        Intent intent = new Intent(this,DroidCafeOrder.class);
        startActivity(intent);
    }

    public void showDonutOrder(View view){
        showFoodOrder(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view){
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view){
        showFoodOrder(getString(R.string.froyo_order_message));
    }
}