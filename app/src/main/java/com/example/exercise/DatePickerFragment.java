package com.example.exercise;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    MensajeroDate mensajeroDate;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        mensajeroDate.enviarDate(day+"-"+month+"-"+year);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mensajeroDate = (MensajeroDate) context;
    }

    public interface MensajeroDate{
        void enviarDate(String date);
    }
}
