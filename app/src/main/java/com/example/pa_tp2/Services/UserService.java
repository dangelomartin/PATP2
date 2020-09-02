package com.example.pa_tp2.Services;

import android.content.Context;
import android.database.Cursor;

import com.example.pa_tp2.Database.ContactsTable;
import com.example.pa_tp2.Database.DatabaseManager;
import com.example.pa_tp2.Database.InterestsContactTable;
import com.example.pa_tp2.Models.User;
import com.example.pa_tp2.Models.UserInterest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UserService {
    public static void saveUser(Context context, User user) {
        try {
            final DatabaseManager databaseManager = new DatabaseManager(context);

            final Long insertedId = databaseManager.save(ContactsTable.Entry.TABLE_NAME, user);

            user.getInterests().forEach(interest -> databaseManager.save(
                    InterestsContactTable.Entry.TABLE_NAME,
                    new UserInterest(insertedId, interest)
            ));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<User> getUsers(Context context) {
        List<User> users = new LinkedList<>(); // Linked list es más rapido para agregar y eliminar

        Cursor cursor = new DatabaseManager(context).find("SELECT  * FROM contacts");

        if (cursor.moveToFirst()) {
            do {
                try {
                    User user = new User()
                            .setFirstName(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.NAME)))
                            .setLastName(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.LAST_NAME)))
                            .setAddress(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.ADDRESS)))
                            .setBornDate(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.BORN_DATE)))
                            .setEmail(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.EMAIL)))
                            .setEmailType(cursor.getInt(cursor.getColumnIndex(ContactsTable.Entry.EMAIL_TYPE)))
                            .setPhone(cursor.getString(cursor.getColumnIndex(ContactsTable.Entry.PHONE)))
                            .setEmailType(cursor.getInt(cursor.getColumnIndex(ContactsTable.Entry.PHONE_TYPE)))
                            .setReceiveInformation(cursor.getInt(cursor.getColumnIndex(ContactsTable.Entry.RECEIVE_INFORMATION)) == 1)
                            .setStudy(cursor.getInt(cursor.getColumnIndex(ContactsTable.Entry.STUDY)))
                            ;
                    List<Integer> interests = new LinkedList<>();

                    Cursor cursor2 = new DatabaseManager(context)
                            .find(String.format("SELECT  * FROM interests_contact WHERE contact_id = %d", cursor.getInt(0)));

                    if (cursor2.moveToFirst()) {
                        do {
                            interests.add(cursor2.getInt(1));
                        } while (cursor2.moveToNext());
                    }

                    user.setInterests(interests);

                    users.add(user);
                } catch (Exception ignored) {}
            } while (cursor.moveToNext());
        }

        return users;
    }
}
