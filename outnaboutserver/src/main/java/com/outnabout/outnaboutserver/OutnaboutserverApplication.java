package com.outnabout.outnaboutserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class OutnaboutserverApplication {

	public static ArrayList<ActiveUser> activeUsers;

	public static void main(String[] args) {
		activeUsers = new ArrayList<ActiveUser>();
		SpringApplication.run(OutnaboutserverApplication.class, args);
	}
}
