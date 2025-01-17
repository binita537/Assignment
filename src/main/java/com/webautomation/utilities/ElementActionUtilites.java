package com.webautomation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class ElementActionUtilites {

	@Autowired
	WebDriverWait wait;

	public void click(WebDriver driver, WebElement element) {
		element.click();
	}

	public void type(WebDriver driver, WebElement element, String text) {
		element.sendKeys(text);
	}

	public void hoverOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void clear(WebDriver driver, WebElement element) {
		element.clear();
	}

	public WebElement waitUntilElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitUntilElementClickable(WebDriver driver, By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitUntilElementPresent(WebDriver driver, By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitUntilElementNotVisible(WebDriver driver, By locator, int timeoutInSeconds) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitUntilElementSelected(WebDriver driver, By locator, int timeoutInSeconds) {
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public void waitUntilElementEnabled(WebDriver driver, By locator, int timeoutInSeconds) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	 public boolean isElementPresent(WebDriver driver) {
	        try {
	            WebElement element = driver.findElement(By.tagName("iframe"));
	            return element.isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }
	    }
}
