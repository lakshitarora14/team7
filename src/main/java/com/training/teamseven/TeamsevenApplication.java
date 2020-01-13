package com.training.teamseven;

import com.training.teamseven.controller.CsvController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamsevenApplication {

	public static void main(String[] args) {SpringApplication.run(TeamsevenApplication.class, args);

		CsvController csvController = new CsvController();
		csvController.read();
	}
}
