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

        ArrayAdapter <String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, options);

        spinnerEmail.setAdapter(adapter);
        spinnerPhone.setAdapter(adapter);

    }

    // Metodo para mostrar u ocultar el menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        // Deshabilito "Agregar contactos" en la vista de agregar contactos.
        menu.getItem(0).setEnabled(false);

        return true;
    }

    // Toma el item seleccionado en el menu
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.listContact) {
            startActivity(new Intent(this, contactForm2.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}