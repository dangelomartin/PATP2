package com.example.pa_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class contactForm2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form2);
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
            Intent intent = new Intent (this, contactForm2.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}