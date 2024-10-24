package com.example.demo.user.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class MapService {
    private static int counter = 0;

    public String getGreeting(String name) {
        return "Hello, " + name + "!";
    }

    private Map<String, Integer> studentGrades;

    public MapService() {
        studentGrades = new HashMap<>();
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 90);
        studentGrades.put("Charlie", 78);
        counter++;
    }

    public static int getCounter() {
        counter++;
        return counter;
    }

    public Integer getGrade(String name) {
        return studentGrades.get(name);
    }

    public void addOrUpdateGrade(String name, int grade) {
        studentGrades.put(name, grade);
    }

    public boolean studentExists(String name) {
        return studentGrades.containsKey(name);
    }

    public boolean gradeExists(int grade) {
        return studentGrades.containsValue(grade);
    }

    public Map<String, Integer> getAllGrades() {
        return studentGrades;
    }

    public void removeStudent(String name) {
        studentGrades.remove(name);
    }

    public int getNumberOfStudents() {
        return studentGrades.size();
    }

    public Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = Arrays.stream(text.toLowerCase().split(" "))
                // .map(word -> word.replaceAll("[^a-záéíóúüñ]", "")) // Limpiamos las palabras
                .filter(word -> !word.isEmpty()) // Filtramos palabras vacías
                .collect(Collectors.toMap(
                        Function.identity(), // Usamos la palabra como clave
                        word -> 1, // Iniciamos el contador en 1
                        Integer::sum)); // Sumamos si ya existe la palabra

        // Ordenamos el mapa usando un Collator para el orden alfabético en español
        return wordCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    // Método para verificar si una cadena es palíndromo par-impar
    public boolean isEvenOddPalindrome(String text) {
        // Obtener los caracteres en posiciones pares
        String evenChars = IntStream.range(0, text.length())
                .filter(i -> i % 2 == 0) // Índices pares
                .mapToObj(text::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Obtener los caracteres en posiciones impares
        String oddChars = IntStream.range(0, text.length())
                .filter(i -> i % 2 != 0) // Índices impares
                .mapToObj(text::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Verificar si los caracteres en posiciones pares e impares son palíndromos
        return isPalindrome(evenChars) && isPalindrome(oddChars);
    }

    // Método auxiliar para verificar si una cadena es palíndromo
    private boolean isPalindrome(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }
}