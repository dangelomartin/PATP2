package com.example.pa_tp2.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pa_tp2.Builders.UserBuilder;
import com.example.pa_tp2.Interfaces.Interests;
import com.example.pa_tp2.Models.User;
import com.example.pa_tp2.R;
import com.example.pa_tp2.Services.UserService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class contactForm2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserService.getUsers(this);

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

    public void save(View view) {
        List<Integer> interests = new ArrayList<>();

        if (((CheckBox) findViewById(R.id.cb_arte)).isChecked()) {
            interests.add(Interests.arts);
        }

        if (((CheckBox) findViewById(R.id.cb_musica)).isChecked()) {
            interests.add(Interests.music);
        }

        if (((CheckBox) findViewById(R.id.cb_deporte)).isChecked()) {
            interests.add(Interests.sports);
        }

        if (((CheckBox) findViewById(R.id.cb_techno)).isChecked()) {
            interests.add(Interests.technology);
        }

        try {
            User user = UserBuilder.buildComplete(
                    ((RadioGroup) findViewById(R.id.study)).getCheckedRadioButtonId(), // Todo: ver esto
                    ((Switch) findViewById(R.id.receiveInformation)).isChecked(),
                    interests);

            UserService.saveUser(this, user);
        } catch (Exception e) {
            Snackbar snackbar = Snackbar.make(view, Objects.requireNonNull(e.getMessage()), Snackbar.LENGTH_SHORT);
            snackbar.getView().setBackgroundColor(Color.RED);
            snackbar.setDuration(3500); // 3 segundos y medio
            snackbar.show();
        }
    }
}