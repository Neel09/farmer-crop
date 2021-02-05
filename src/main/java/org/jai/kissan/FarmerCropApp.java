package org.jai.kissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;

@SpringBootApplication
public class FarmerCropApp {

	public static void main(String[] args) {
		SpringApplication.run(FarmerCropApp.class, args);
	}

}
