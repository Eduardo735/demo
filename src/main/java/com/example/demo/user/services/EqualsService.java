package com.example.demo.user.services;

import org.springframework.stereotype.Service;

@Service
public class EqualsService {

    public String compareStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return "Los strings son iguales en contenido.";
        } else {
            return "Los strings NO son iguales en contenido.";
        }
    }

    public String compareStringsIdentico() {
        String str1 = new String("Hola");
        String str2 = new String("Hola");
        if (str1 == str2) {
            return "Los strings son iguales en contenido.";
        } else {
            return "Los strings NO son iguales en contenido.";
        }
    }
}