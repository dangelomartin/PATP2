package com.example.pa_tp2.Builders;

import com.example.pa_tp2.Exceptions.UserException;
import com.example.pa_tp2.Models.User;

import java.util.List;

public abstract class UserBuilder {
    private static User user = null;

    public static void buildBase(String firstName, String lastName, String phone,
                                 String email, String address, String bornDate,
                                 Integer phoneType, Integer emailType) throws UserException {
        UserBuilder.user = null;

        UserBuilder.user = new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setBornDate(bornDate)
                .setPhoneType(phoneType)
                .setEmailType(emailType);
    }

    public static User buildComplete(Integer study, Boolean receiveInformation, List<Integer> interests) throws UserException {
        return UserBuilder.user
                .setStudy(study)
                .setReceiveInformation(receiveInformation)
                .setInterests(interests);
    }
}
