package com.projectsd.services;


import com.projectsd.services.model.Customer;
import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.repository.WorkerRepository;
import com.projectsd.services.service.impl.CustomerService;
import com.projectsd.services.service.impl.WorkerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(WorkerRepository workerRepository,
						   WorkerService workerService,
						   CustomerRepository customerRepository,
						   CustomerService customerService) {
		return args -> {
			Worker worker01 = new Worker("Alex", "Mintas", "alexmintas@yahoo.ro", "0740933344", 21);
			Worker worker02 = new Worker("Oana", "Morar", "oanamorar@yahoo.ro", "0740344521", 22);
			Worker worker03 = new Worker("Mihai", "Mic", "mihaimic@yahoo.com", "0726977211", 26);

			Customer customer01 = new Customer("Cristina", "Titu", "cristinatitu@yahoo.ro", "0730946454", 21);
			Customer customer02 = new Customer("Tomas", "Nicoara", "tomasnicoara@yahoo.ro", "0787903241", 22);

			workerService.createWorker(worker01);
			workerService.createWorker(worker02);
			workerService.createWorker(worker03);

			worker02.setAge(23);
			workerService.updateWorker(worker02);

			customerService.createCustomer(customer01);
			customerService.createCustomer(customer02);


			worker01.setCustomer(customer02);
			workerService.updateWorker(worker01);

			System.out.println(customer01.getWorkers());

			//workerService.deleteWorker(worker03.getId());
		};
	}

}
