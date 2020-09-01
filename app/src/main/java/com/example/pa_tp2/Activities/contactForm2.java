package com.example.pa_tp2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pa_tp2.R;

public class contactForm2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form2);
    }

    // Metodo para mostrar u ocultar el menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        // Deshabilito "Listado de contactos" en la vista de listado de contactos.
        menu.getItem(1).setEnabled(false);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.addContact) {
            startActivity(new Intent(this, contactForm.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}