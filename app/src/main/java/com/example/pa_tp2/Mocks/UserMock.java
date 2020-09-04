package com.example.pa_tp2.Mocks;

import com.example.pa_tp2.Models.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

    public static List<User> mockList() {
        List<User> users = new LinkedList<>();

        try {
            users.add(new User()
                    .setFirstName("Sebastian")
                    .setLastName("Sanchez")
                    .setAddress("Juan de garay 4567")
                    .setBornDate("17/11/1987")
                    .setEmail("s.sanchez@gmail.com")
                    .setEmailType(2)
                    .setPhone("1132345643")
                    .setPhoneType(1)
                    .setReceiveInformation(false)
                    .setStudy(3)
                    .setInterests(Arrays.asList(1, 2, 3)));

            users.add(new User()
                    .setFirstName("Jose")
                    .setLastName("Perez")
                    .setAddress("Av. Libertado 245")
                    .setBornDate("05/08/1975")
                    .setEmail("j.perez@outlook.com")
                    .setEmailType(2)
                    .setPhone("1154378654")
                    .setPhoneType(0)
                    .setReceiveInformation(true)
                    .setStudy(2)
                    .setInterests(Collections.singletonList(3)));

            users.add(new User()
                    .setFirstName("Lisandro")
                    .setLastName("Lopez")
                    .setAddress("Caseros 3221")
                    .setBornDate("12/03/1997")
                    .setEmail("licha-lopez@gmail.com")
                    .setEmailType(0)
                    .setPhone("1164326589")
                    .setPhoneType(1)
                    .setReceiveInformation(false)
                    .setStudy(4)
                    .setInterests(Collections.emptyList()));
        } catch (Exception ignored) {}

        return users;
    }
}
