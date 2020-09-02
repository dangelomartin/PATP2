package com.example.pa_tp2.Models;

import android.content.ContentValues;

import com.example.pa_tp2.Database.ContactsTable;
import com.example.pa_tp2.Exceptions.UserException;
import com.example.pa_tp2.Interfaces.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class User implements Entity {
    private String firstName;
    private String lastName;
    private Integer phone;
    private Integer phoneType;
    private String email;
    private Integer emailType;
    private String address;
    private String bornDate;
    private Integer study;
    private Boolean receiveInformation;
    private List<Integer> interests;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) throws UserException {
        if (firstName.length() < 3 || firstName.length() > 20) {
            throw new UserException("La longitud del nombre debe ser mayor a 3 y menor que 20 caracteres.");
        }

        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) throws UserException {
        if (lastName.length() < 3 || lastName.length() > 20) {
            throw new UserException("La longitud del apellido debe ser mayor a 3 y menor que 20 caracteres.");
        }

        this.lastName = lastName;

        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public User setPhone(String phone) throws UserException {
        try {
            this.phone = Integer.parseInt(phone);
        } catch (NumberFormatException ignored) {
            throw new UserException("El telefono celular solo puede contener numeros");
        }

        return this;
    }



    public Integer getPhoneType() {
        return phoneType;
    }

    public User setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) throws UserException {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        // Si no matchea, no es un email válido
        if (!pattern.matcher(email).find()) {
            throw new UserException("El E-Mail ingresado no es válido");
        }

        this.email = email;

        return this;
    }

    public Integer getEmailType() {
        return emailType;
    }

    public User setEmailType(Integer emailType) {
        this.emailType = emailType;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) throws UserException {
        if (address.length() < 5 || lastName.length() > 40) {
            throw new UserException("La longitud de la dirección debe ser mayor a 5 y menor que 40 caracteres.");
        }

        this.address = address;

        return this;
    }

    public String getBornDate() {
        return bornDate;
    }

    public User setBornDate(String bornDate) throws UserException {
        if (bornDate == null) {
            throw new UserException("No se ha ingresado fecha de nacimiento");
        }

        try {
            if (Objects.requireNonNull(
                    new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"))
                            .parse(bornDate)).compareTo(new Date()) > 0) {
                throw new UserException("La fecha ingresada debe ser menor a la fecha actual");
            }
        } catch (ParseException e) {
            throw new UserException("La fecha ingresada es incorrecta. Recuerde que el formato debe ser dd/mm/aaaa, ej: 25/05/1981");
        }


        this.bornDate = bornDate;

        return this;
    }

    public Integer getStudy() {
        return study;
    }

    public User setStudy(Integer study) throws UserException {
        if (study == null || study == 0 || study > 4) {
            throw new UserException("Debe seleccionar un tipo de estudio");
        }

        this.study = study;

        return this;
    }

    public List<Integer> getInterests() {
        return interests;
    }

    public User setInterests(List<Integer> interests) {
        this.interests = interests;

        return this;
    }

    public Boolean getReceiveInformation() {
        return receiveInformation;
    }

    public User setReceiveInformation(Boolean receiveInformation) {
        this.receiveInformation = receiveInformation;

        return this;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(ContactsTable.Entry.NAME, this.firstName);
        values.put(ContactsTable.Entry.LAST_NAME, this.lastName);
        values.put(ContactsTable.Entry.ADDRESS, this.address);
        values.put(ContactsTable.Entry.BORN_DATE, this.bornDate);
        values.put(ContactsTable.Entry.EMAIL, this.email);
        values.put(ContactsTable.Entry.PHONE, this.phone);
        values.put(ContactsTable.Entry.STUDY, this.study);
        values.put(ContactsTable.Entry.RECEIVE_INFORMATION, this.receiveInformation);

        return values;
    }
}
