package com.example.pa_tp2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pa_tp2.Builders.UserBuilder;
import com.example.pa_tp2.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class contactForm extends AppCompatActivity {

    private Spinner spinnerEmail, spinnerPhone;
    private EditText firstName,lastName,phone,email,address,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        //toma de datos:
        firstName = findViewById(R.id.input_firstname);
        lastName = findViewById(R.id.input_lastname);
        phone = findViewById(R.id.input_phone);
        address = findViewById(R.id.input_address);
        email = findViewById(R.id.input_email);
        date = findViewById(R.id.input_date);
        spinnerEmail = findViewById(R.id.spinnerEmail);
        spinnerPhone = findViewById(R.id.spinnerPhone);

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

    public void saveForm(View view) {
        try {
            UserBuilder.buildBase(
                    ((EditText) findViewById(R.id.input_firstname)).getText().toString(),
                    ((EditText) findViewById(R.id.input_lastname)).getText().toString(),
                    ((EditText) findViewById(R.id.input_phone)).getText().toString(),
                    ((EditText) findViewById(R.id.input_address)).getText().toString(),
                    ((EditText) findViewById(R.id.input_email)).getText().toString(),
                    ((EditText) findViewById(R.id.input_date)).getText().toString(),
                    ((Spinner) findViewById(R.id.spinnerEmail)).getSelectedItemPosition(),
                    ((Spinner) findViewById(R.id.spinnerPhone)).getSelectedItemPosition());

            startActivity(new Intent(this, contactForm2.class));
            finish();
        } catch (Exception e) {
            Snackbar snackbar = Snackbar.make(view, Objects.requireNonNull(e.getMessage()), Snackbar.LENGTH_SHORT);
            snackbar.getView().setBackgroundColor(Color.RED);
            snackbar.setDuration(3500); // 3 segundos y medio
            snackbar.show();
        }
    }
}