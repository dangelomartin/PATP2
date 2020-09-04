package com.example.pa_tp2.Protocols;

import com.example.pa_tp2.Interfaces.Interests;

import java.util.List;

public class UserProtocol {
    public static String getSpinnerName(Integer id) {
        if (id == null) {
            return "Dato no encontrado";
        }

        if (id == 0) {
            return "Casa";
        } else if (id == 1) {
            return "Trabajo";
        }

        return "Movil";
    }

    public static String getStudyName(Integer id) {
        if (id == null) {
            return "Dato no encontrado";
        }

        if (id == 0) {
            return "Primario Incompleto";
        } else if (id == 1) {
            return "Primario Completo";
        } else if (id == 2) {
            return "Secundario Incompleto";
        } else if (id == 3) {
            return "Secundario Completo";
        }

        return "Otros";
    }

    public static String getInterests(List<Integer> interests) {
        StringBuilder stringBuilder = new StringBuilder();

        interests.forEach(interest -> {
            if (interest.equals(Interests.arts)) {
                stringBuilder.append("Arte");
            } else if (interest.equals(Interests.music)) {
                stringBuilder.append("Musica");
            } else if (interest.equals(Interests.sports)) {
                stringBuilder.append("Deportes");
            } else if (interest.equals(Interests.technology)) {
                stringBuilder.append("Tecnología");
            }
        });

        return stringBuilder.toString();
    }
}
