package com.example.pa_tp2.Mocks;

import com.example.pa_tp2.Models.User;

import java.util.Arrays;

public abstract class UserMock {
    public static User mock() {
        User user = null;

        try {
            user = new User()
                    .setFirstName("Jhonny")
                    .setLastName("Petersen")
                    .setAddress("asdasd asdas")
                    .setBornDate("12/08/1995")
                    .setEmail("asdas@asdas.com")
                    .setEmailType(1)
                    .setPhone("1231231")
                    .setPhoneType(1)
                    .setReceiveInformation(false)
                    .setStudy(3)
                    .setInterests(Arrays.asList(1, 2, 3))
            ;
        } catch (Exception ignored) {}

        return user;
    }
}
