package com.example.pa_tp2.Models;

import android.content.ContentValues;

import com.example.pa_tp2.Database.ContactsTable;
import com.example.pa_tp2.Database.InterestsContactTable;
import com.example.pa_tp2.Interfaces.Entity;

public class UserInterest implements Entity {
    private Long userId;
    private Integer interestId;

    public UserInterest(Long userId, Integer interestId) {
        this.userId = userId;
        this.interestId = interestId;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(InterestsContactTable.Entry.CONTACT_ID, this.userId);
        values.put(InterestsContactTable.Entry.INTEREST_ID, this.interestId);

        return values;
    }
}
