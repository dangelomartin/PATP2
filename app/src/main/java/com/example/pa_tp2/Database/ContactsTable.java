package com.example.pa_tp2.Database;

import android.provider.BaseColumns;

import java.util.Date;

public class ContactsTable {
    public static abstract class Entry implements BaseColumns {
        public static final String TABLE_NAME = "contacts";

        public static final String NAME = "name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String BORN_DATE = "bornDate";
        public static final String STUDY = "study";
        public static final String RECEIVE_INFORMATION = "receive_information";
    }
}
