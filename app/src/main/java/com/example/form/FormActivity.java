package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity {
    public static final int PICK_FILE  = 99;
    CheckBox Checkjava, Checkc, Checkcplus, checkkotlin;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Spinner spinnercountry = findViewById(R.id.spinner_country);
        Spinner spinercity = findViewById(R.id.spinner_city);
        EditText datepopup = findViewById(R.id.edit_date);
        Submit = findViewById(R.id.submitbutn);
        EditText Name = findViewById(R.id.name);

        Checkjava = findViewById(R.id.checkboxjava);
        Checkc = findViewById(R.id.checkboxc);
        Checkcplus = findViewById(R.id.checkboxcplus);
        checkkotlin = findViewById(R.id.checkboxkotlin);

        String[] countryitems = new String[]{"Bangladesh", "India", "Pakistan", "Myanmar"};

        ArrayAdapter<String> countryadapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countryitems);

        /*ArrayAdapter<CharSequence> adaptercountry = ArrayAdapter.createFromResource(this, R.array.country,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adaptercountry.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);*/
        spinnercountry.setAdapter(countryadapter);
        /*if (){

        }*/

        ArrayAdapter<CharSequence> adaptercity = ArrayAdapter.createFromResource(this, R.array.citybang,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        adaptercity.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spinercity.setAdapter(adaptercity);

        Button attachfile = findViewById(R.id.attachbutn);
        attachfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("application/pdf");
                startActivityForResult(intent, PICK_FILE);
            }
        });
        datepopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(FormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                datepopup.setText(dayOfMonth +"-"+ ( month+1 ) +"-"+ year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
        if (Checkjava.isChecked() || Checkc.isChecked() || Checkcplus.isChecked() || checkkotlin.isChecked() && (Name.getText() != null)){
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FormActivity.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(),"Successfully register", Toast.LENGTH_LONG).show();

                    String getName = Name.getText().toString();
                    Intent nameintent = new Intent(getApplicationContext(), MainActivity.class);
                    nameintent.putExtra("Name", getName);
                }
            });
        }

    }
}
