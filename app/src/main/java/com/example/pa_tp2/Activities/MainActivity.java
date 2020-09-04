package com.example.pa_tp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pa_tp2.Mocks.UserMock;
import com.example.pa_tp2.Models.User;
import com.example.pa_tp2.R;
import com.example.pa_tp2.Services.UserService;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    private static Boolean buttonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AtomicReference<Integer> countMocks = new AtomicReference<>(0);
        List<User> users = UserMock.mockList();

        // Busca cuantos usuarios mockeados hay insertados
        UserService.getUsers(this).forEach(user ->
                users.forEach(mockUser ->
                        countMocks.updateAndGet(v ->
                                v + (mockUser.getEmail().equals(user.getEmail()) ? 1 : 0))));

        if (countMocks.get() >= 3) {
            Button button = (Button) findViewById(R.id.button);
            button.setEnabled(false);
            button.setText("Ya tienes contactos de prueba creados 🥳️");
            buttonClicked = true;
        }
    }

    //Metodo para mostrar u ocultar el menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    // toma el item seleccionado en el menu
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.addContact: {
                startActivity(new Intent (this, ContactForm.class));
                break;
            }
            case R.id.listContact: {
                startActivity(new Intent (this, ListContacts.class));
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void fillDatabase(View view) {
        if (buttonClicked) return;

        Button button = (Button) findViewById(R.id.button);

        UserMock.mockList().forEach(user -> UserService.saveUser(this, user));

        button.setEnabled(false);
        button.setText("Contactos agregados exitosamente ⚡️");
        buttonClicked = true;
    }
}