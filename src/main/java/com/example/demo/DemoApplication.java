package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// public class SearchElasticTimer {

// private SearchElastic searchElasticK;

// public SearchElasticTimer(SearchElastic searchElastic) {
// this.searchElastic = searchElastic;
// }

// public void executeWithTiming() {
// long startTime = System.currentTimeMillis();
// searchElastic.execute();

// // Obtener el tiempo final en milisegundos
// long endTime = System.currentTimeMillis();
// long duration = endTime - startTime;
// System.out.println("El tiempo de ejecución fue de: " + duration + "
// milisegundos.");
// }
// }