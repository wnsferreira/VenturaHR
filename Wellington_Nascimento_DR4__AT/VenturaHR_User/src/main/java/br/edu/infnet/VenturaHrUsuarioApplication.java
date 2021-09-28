package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class VenturaHrUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenturaHrUsuarioApplication.class, args);
	}

}
