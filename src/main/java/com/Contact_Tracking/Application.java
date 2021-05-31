package com.Contact_Tracking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application {private final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		System.exit(0);
	}

	@Bean
	CommandLineRunner demo(PersonRepository personRepository, LocationRepository locationRepository) {
		return args -> {

			personRepository.deleteAll();
			locationRepository.deleteAll();

			Person elon = new Person("Elon", "Musk");
			Person bill = new Person("Bill", "Gates");
			Person jeff = new Person("Jeff", "Bezos");
			Person mark = new Person("Mark", "Zuckerberg");
			Person larry = new Person("Larry", "Page");
			Person sergey = new Person("Sergey", "Brin");
			Person wladimir = new Person("Wladimir Wladimirowitsch", "Putin");

			personRepository.save(elon);
			personRepository.save(bill);
			personRepository.save(jeff);
			personRepository.save(mark);
			personRepository.save(larry);
			personRepository.save(sergey);
			personRepository.save(wladimir);

			Location berlin = new Location("Berlin");
			Location hamburg = new Location("Hamburg");
			Location munich = new Location("Munich");
			Location cologne = new Location("Cologne");
			Location frankfurt = new Location("Frankfurt");
			Location stuttgart = new Location("Stuttgart");

			locationRepository.save(berlin);
			locationRepository.save(hamburg);
			locationRepository.save(munich);
			locationRepository.save(cologne);
			locationRepository.save(frankfurt);
			locationRepository.save(stuttgart);

			elon = personRepository.findByFirstNameAndLastName(elon.getFirstName(), elon.getLastName());
			elon.hadContactWith(new HadContactWith(bill, 1, 20210515, 1300));
			elon.hadContactWith(new HadContactWith(mark, 1, 20210515, 1100));
			elon.hadContactWith(new HadContactWith(wladimir, 0.25, 20210514, 1000));
			elon.hadVisited(new HadVisited(berlin, 4, 20210515, 1100));
			personRepository.save(elon);

			bill = personRepository.findByFirstNameAndLastName(bill.getFirstName(), bill.getLastName());
			bill.hadContactWith(new HadContactWith(jeff, 1, 20210516, 1100));
			bill.hadVisited(new HadVisited(hamburg, 3, 20210516, 1000));
			bill.hadVisited(new HadVisited(berlin, 1, 20210515, 1300));
			personRepository.save(bill);

			jeff = personRepository.findByFirstNameAndLastName(jeff.getFirstName(), jeff.getLastName());
			jeff.hadContactWith(new HadContactWith(sergey, 1, 20210515, 1100));
			jeff.hadVisited(new HadVisited(munich, 6, 20210515, 1200));
			jeff.hadVisited(new HadVisited(hamburg, 1, 20210516, 1100));
			personRepository.save(jeff);

			mark = personRepository.findByFirstNameAndLastName(mark.getFirstName(), mark.getLastName());
			mark.hadContactWith(new HadContactWith(larry, 1, 20210515, 1100));
			mark.hadVisited(new HadVisited(cologne, 8, 20210513, 1100));
			mark.hadVisited(new HadVisited(frankfurt, 1, 20210515, 1100));
			mark.hadVisited(new HadVisited(berlin, 4, 20210515, 1000));
			personRepository.save(mark);

			larry = personRepository.findByFirstNameAndLastName(larry.getFirstName(), larry.getLastName());
			larry.hadContactWith(new HadContactWith(sergey, 0.2, 20210514, 1200));
			larry.hadVisited(new HadVisited(stuttgart, 1, 20210514, 1700));
			larry.hadVisited(new HadVisited(frankfurt, 4, 20210515, 1100));
			personRepository.save(larry);

			sergey = personRepository.findByFirstNameAndLastName(sergey.getFirstName(), sergey.getLastName());
			sergey.hadContactWith(new HadContactWith(wladimir, 0.2, 20210514, 1200));
			sergey.hadVisited(new HadVisited(stuttgart, 8, 20210514, 1600));
			sergey.hadVisited(new HadVisited(munich, 2, 20210515, 1100));
			personRepository.save(sergey);

		};
	}
}
