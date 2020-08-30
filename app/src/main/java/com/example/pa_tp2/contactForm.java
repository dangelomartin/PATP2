package com.example.pa_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class contactForm extends AppCompatActivity {

    private Spinner spinnerEmail, spinnerPhone;
    private EditText firstName,lastName,phone,email,adress,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        //toma de datos:
        firstName = (EditText)findViewById(R.id.input_firstname);
        lastName = (EditText)findViewById(R.id.input_lastname);
        phone = (EditText)findViewById(R.id.input_phone);
        adress = (EditText)findViewById(R.id.input_adress);
        email = (EditText)findViewById(R.id.input_email);
        date = (EditText)findViewById(R.id.input_date);
        spinnerEmail = (Spinner)findViewById(R.id.spinnerEmail);
        spinnerPhone = (Spinner)findViewById(R.id.spinnerPhone);

        String [] options = {"Casa","Trabajo", "Movil"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, options);

        spinnerEmail.setAdapter(adapter);
        spinnerPhone.setAdapter(adapter);

    }

    //Metodo para mostrar u ocultar el menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    // toma el item seleccionado en el menu
    public boolean onOptionsItemSelected(MenuItem item){
        int selected = item.getItemId();

        if(selected == R.id.addContact){
            Intent intent = new Intent (this, contactForm.class);
            startActivity(intent);
        } else if(selected == R.id.listContact){
            Intent intent = new Intent (this, contactForm.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}