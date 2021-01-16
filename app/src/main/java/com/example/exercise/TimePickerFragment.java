package com.example.exercise;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.text.format.DateFormat;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener {

    private Mensajero mensajero;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour =c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new android.app.TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {
        mensajero.enviarHora(Integer.toString(i) +":"+Integer.toString(i1));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mensajero= (Mensajero) context;
    }

    public interface Mensajero{
        public void enviarHora(String hola);
    }
}