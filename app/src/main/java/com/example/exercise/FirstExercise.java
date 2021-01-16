package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FirstExercise extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exercise);

        initializeRadioGroup();
    }

    public void buttonMethodRandomBackground(View theButton){
        Random rnd = new Random();
        int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
        theButton.setBackgroundColor(color);
    }

    public void imageButtonMethod(View imageButton){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        editText2.setText(editText1.getText());
    }

    public void checkboxMethod(View checkbox){
        CheckBox checkBox = findViewById(R.id.checkbox1);
        if (checkBox.isChecked()){
            Toast.makeText(this,"el checkbox esta seleccionado",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"el checkbox no esta seleccionado",Toast.LENGTH_SHORT).show();
        }
    }

    public void initializeRadioGroup(){
        this.radioGroup= findViewById(R.id.radioGroup);
        this.radioButton1= findViewById(R.id.radioBtn1);
        this.radioButton2= findViewById(R.id.radioBtn2);
        this.radioButton3= findViewById(R.id.radioBtn3);

        this.radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        TextView textView = findViewById(R.id.beautifulColor);
        if (radioGroup.getCheckedRadioButtonId()==R.id.radioBtn1){
            textView.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if (radioGroup.getCheckedRadioButtonId()==R.id.radioBtn2){
            textView.setBackgroundColor(getResources().getColor(R.color.red));
        }else if (radioGroup.getCheckedRadioButtonId()==R.id.radioBtn3){
            textView.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }
}