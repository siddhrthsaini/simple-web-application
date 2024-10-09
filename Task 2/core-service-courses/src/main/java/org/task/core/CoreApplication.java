package org.task.core;

import org.task.core.common.TaskObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication(scanBasePackages = "org.task.core")
public class CoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CoreApplication.class, args);

		SpringApplication springApplication = new SpringApplication(CoreApplication.class);
		springApplication.run(args);
	}

	private static boolean checkCacheManager()
	{
		try {
			TaskObject whiteRoseObject = new TaskObject();
			whiteRoseObject.setId(UUID.randomUUID().toString());
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
