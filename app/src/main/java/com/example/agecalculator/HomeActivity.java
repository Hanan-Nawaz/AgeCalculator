package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    int current_date = 0;
    int current_month = 0;
    int current_year = 0;
    int date = 0;
    int month = 0;
    int year = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        ImageButton button = findViewById(R.id.website_link);
        EditText age_text = findViewById(R.id.age);
        TextView textView = findViewById(R.id.btn_calculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("https://hanannawaz.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        });

        age_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calender = Calendar.getInstance();
                date = calender.get(Calendar.DATE);
                month = calender.get(Calendar.MONTH);
                year = calender.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selected_year, int selected_month, int selected_day) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selected_year);
                        myCalendar.set(Calendar.MONTH, selected_month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selected_day);
                        String myFormat = "dd/MM/yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                        age_text.setText(sdf.format(myCalendar.getTime()));

                        date = selected_day;
                        month = selected_month;
                        year = selected_year;
                    }
                }, date, month, year);

                datePickerDialog.show();


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calender = Calendar.getInstance();
                current_date = calender.get(Calendar.DATE);
                current_month = calender.get(Calendar.MONTH);
                current_year = calender.get(Calendar.YEAR);

                int month_age = current_month - month;
                int day_age = current_date - date;
                int year_age = current_year - year;
                int day_after_change;
                int month_after_change;

//                if(month_age < 0){
//                    month_after_change = 12 - month_age;
//                }
//                else{
//                    month_after_change = month_age;
//                }
//
//                if(month_after_change == 1 || month_after_change == 3 || month_after_change == 5 || month_after_change == 7
//                        || month_after_change == 8 || month_after_change == 10 || month_after_change == 12){
//                    if(day_age < 0){
//                        day_after_change = 31 +  day_age;
//                    }
//                    else{
//                        day_after_change = day_age;
//                    }
//                }
//                else{
//                    if(day_age < 0){
//                        day_after_change = 30 +  day_age;
//                    }
//                    else{
//                        day_after_change = day_age;
//                    }
//                }


                Toast.makeText(getApplicationContext(), month_age + "/" + day_age + "/" + year_age , Toast.LENGTH_LONG).show();
            }
        });



    }



}