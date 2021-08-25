package ru.zagrebin.diploma;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.security.auth.login.LoginException;


@SpringBootApplication
public class DiplomaApplication {
	public static void main( String[] args) throws LoginException, InterruptedException {
		SpringApplication.run(DiplomaApplication.class, args);
	}
}
