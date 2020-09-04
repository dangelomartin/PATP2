package com.example.pa_tp2.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pa_tp2.Models.User;
import com.example.pa_tp2.R;
import com.example.pa_tp2.Services.UserService;

import java.util.List;

public class ListContacts extends AppCompatActivity {
    private List<User> users = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_contacts);

        this.users = UserService.getUsers(this);
        this.init();
    }

    // Metodo para mostrar u ocultar el menu
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);

        // Deshabilito "Listado de contactos" en la vista de listado de contactos.
        menu.getItem(1).setEnabled(false);

        return true;
    }

    // Toma el item seleccionado en el menu
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.addContact) {
            startActivity(new Intent(this, ContactForm.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow firstRow = new TableRow(this);

        if (this.users.size() == 0) {
            TextView noContactsColumn = new TextView(this);

            noContactsColumn.setGravity(Gravity.CENTER);
            noContactsColumn.setText("No hay contactos aún");
            firstRow.addView(noContactsColumn);
            stk.addView(firstRow);
            return;
        }

        TextView nameColumn = new TextView(this);
        TextView lastNameColumn = new TextView(this);
        TextView actionColumn = new TextView(this);

        nameColumn.setGravity(Gravity.START);
        lastNameColumn.setGravity(Gravity.END);
        nameColumn.setText("Nombre");
        lastNameColumn.setText("Apellido");
        actionColumn.setText("        ");

        firstRow.addView(nameColumn);
        firstRow.addView(lastNameColumn);
        firstRow.addView(actionColumn);
        stk.addView(firstRow);

        this.users.forEach(user -> {
            TableRow userRow = new TableRow(this);
            TextView nameColumnRow = new TextView(this);
            TextView lastNameColumnRow = new TextView(this);
            Button button = new Button(this);

            nameColumnRow.setText(user.getFirstName());
            nameColumnRow.setGravity(Gravity.START);

            lastNameColumnRow.setText(user.getLastName());
            lastNameColumnRow.setGravity(Gravity.END);

            button.setText("Ver mas");
            button.setGravity(Gravity.CENTER);
            button.setWidth(100);
            button.setHeight(50);
            button.setOnClickListener(this.showMoreInfo(user));

            userRow.addView(nameColumnRow);
            userRow.addView(lastNameColumnRow);
            userRow.addView(button);
            stk.addView(userRow);
        });
    }

    private View.OnClickListener showMoreInfo(User user) {
        Context context = this;

        return v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle(user.getLastName() + ", " + user.getFirstName());
            alert.setMessage(user.toString());
            alert.setPositiveButton("Cerrar", null);
            alert.show();
        };
    }
}