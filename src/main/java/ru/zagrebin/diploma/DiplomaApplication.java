package ru.zagrebin.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zagrebin.diploma.bot.BotStart;

import javax.security.auth.login.LoginException;


@SpringBootApplication
public class DiplomaApplication {

	public static void main( String[] args) throws LoginException, InterruptedException {
		SpringApplication.run(DiplomaApplication.class, args);
		BotStart.botStart();
	}

}
