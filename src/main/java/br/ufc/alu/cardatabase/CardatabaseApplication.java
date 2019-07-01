package br.ufc.alu.cardatabase;

import br.ufc.alu.cardatabase.domain.Car;
import br.ufc.alu.cardatabase.domain.Owner;
import br.ufc.alu.cardatabase.domain.CarRepository;
import br.ufc.alu.cardatabase.domain.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class CardatabaseApplication {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Testing data
			Owner owner1 = new Owner(null, "Marcos", "S Lima", new ArrayList<>());
			ownerRepository.save(owner1);
			carRepository.save(new Car(null, "Ford", "Mustang", "Red", "ADF-1121", 2017, 59000,  owner1));
			carRepository.save(new Car(null, "Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000,  owner1));
			carRepository.save(new Car(null, "Toyota", "Prius", "Silver", "KKO-0212", 2018,39000,  owner1));
		};
	}

}
