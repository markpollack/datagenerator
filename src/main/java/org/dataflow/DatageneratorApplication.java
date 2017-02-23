package org.dataflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataGeneratorProperties.class)
public class DatageneratorApplication implements CommandLineRunner {


	@Autowired
	private DataGenerator dataGenerator;

	public static void main(String[] args) {
		SpringApplication.run(DatageneratorApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		dataGenerator.run();
	}
}
