package com.lmlasmo.gioscito;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GioscitoApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(GioscitoApplication.class, args);
	}

}
