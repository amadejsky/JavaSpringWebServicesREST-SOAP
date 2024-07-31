package com.amadejsky.web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebServicesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(WebServicesApplication.class, args);
//		MarioGame gameM = new MarioGame();
//		SuperContraGame gameSP = new SuperContraGame();
		//PacManGame
//		GamingConsole gameM = new MarioGame();
//
//		GameRunner runner1 = new GameRunner(gameM);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
//		GameRunner runner2 = new GameRunner(gameSP);
//		runner2.run();
//
//		GameRunner runner3 = new GameRunner(gamePC);
//		runner3.run();

	}

}
