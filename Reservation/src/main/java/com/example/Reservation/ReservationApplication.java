package com.example.Reservation;

import com.example.Reservation.model.UsersModel;
import com.example.Reservation.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	@Autowired
	private UsersRepository usersRepo;

	@Override
	public void run(String... args) throws Exception {
		UsersModel users = new UsersModel();
		users.setLoginId("RRR");
		users.setFname("Ravi");
		users.setLname("Eluri");
		users.setEmail("test@gmail.com");
		users.setMobile("4012356789");
		users.setPassword("test");
		usersRepo.save(users);

		UsersModel users1 = new UsersModel();
		users1.setLoginId("RRR2");
		users1.setFname("Teja");
		users1.setLname("Eluri");
		users1.setEmail("test@yahoo.com");
		users1.setMobile("4021356789");
		users1.setPassword("test1");
		usersRepo.save(users1);
	}

}
