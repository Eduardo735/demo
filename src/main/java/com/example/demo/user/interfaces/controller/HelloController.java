package com.example.demo.user.interfaces.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.services.EqualsService;
import com.example.demo.user.services.MapService;
import com.example.demo.user.utils.MathUtils;

@RestController
public class HelloController {

    @Autowired
    private MapService mapService;

    @Autowired
    private EqualsService equalsService;

    @GetMapping("/hello")
    public String sayHello() {
        return "¡Hola, mundo!";
    }

    @GetMapping("/map")
    public String sayMap() {
        return "¡Hola, mundo!";
    }

    @GetMapping("/grades")
    public Map<String, Integer> getAllGrades() {
        Map<String, Integer> grades = mapService.getAllGrades();
        System.out.println("Número de instancias creadas: " + MapService.getCounter() + grades);
        Map<String, Integer> gradesTwo = mapService.getAllGrades();
        System.out.println("Número de instancias creadas: " + MapService.getCounter() + gradesTwo);

        return mapService.getAllGrades();
    }

    @GetMapping("/identico")
    public String getIdentico() {
        return equalsService.compareStringsIdentico();

    }

    @GetMapping("/igualdad")
    public String getIgualdad() {
        return equalsService.compareStrings("lol", "loll");

    }

    @GetMapping("/maxOfThree")
    public ResponseEntity<String> getMaxOfThree() {
        Integer num1 = 1;
        Integer num2 = 2;
        Integer num3 = 3;

        if (num1 == null || num2 == null || num3 == null) {
            return ResponseEntity.badRequest().body("Todos los parámetros deben ser proporcionados.");
        }

        try {
            int max = MathUtils.maxOfThree(num1, num2, num3);
            MathUtils.maxOfThree(num1, num2, 12);
            return ResponseEntity.ok("El máximo de " + num1 + ", " + num2 + " y " + num3 + " es: " + max);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/countWords")
    public Map<String, Integer> countWordsGet() {
        String text = "El estribillo de una chirigota de Cádiz es Como como como como estoy como estoy";
        return mapService.countWordFrequency(text);
    }

    @GetMapping("/checkPalindrome")
    public boolean checkEvenOddPalindrome() {
        long startTime = System.currentTimeMillis();
        String text = "lol";
        String textTwo = "lollo";
        Boolean isPalindrome = mapService.isEvenOddPalindrome(textTwo);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("El tiempo de ejecución fue de: " + duration + " milisegundos.");

        return isPalindrome;
    }
}
