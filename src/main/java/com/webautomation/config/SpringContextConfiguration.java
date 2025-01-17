package com.webautomation.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//this class  scan for all classes that are annotated with @Component

import com.webautomation.webdrivers.DriverFactory;

@Configuration
@ComponentScan("com.webautomation")
public class SpringContextConfiguration {

	@Autowired
	DriverFactory driverFactory;

	@Autowired
	BrowserConfig browserConfig;
	
	@Bean
	public WebDriver webDriver() {
		return driverFactory.createDriver("chrome");
	}

	@Bean
	public WebDriverWait webDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}

}
