package com.example.pa_tp2.Database;

import android.provider.BaseColumns;

public class InterestsContactTable {
    public static abstract class Entry implements BaseColumns {
        public static final String TABLE_NAME = "interests_contact";

        public static final String CONTACT_ID = "contact_id";
        public static final String INTEREST_ID = "interest_id";
    }
}
