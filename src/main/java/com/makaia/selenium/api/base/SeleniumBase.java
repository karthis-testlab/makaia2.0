package com.makaia.selenium.api.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.makaia.general.utils.PropertiesHandler.config;
import com.makaia.general.utils.Reporter;
import com.makaia.selenium.api.design.Browser;
import com.makaia.selenium.api.design.Element;
import com.makaia.selenium.api.design.Locators;

public class SeleniumBase extends Reporter implements Browser, Element {

	@Override
	public void click(WebElement ele) {
		ele.click();
	}

	@Override
	public void click(WebElement ele, String jsExpression) {
		getDriver().executeScript(jsExpression, ele);
	}

	@Override
	public void type(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	@Override
	public String getElementText(WebElement ele) {
		return ele.getText();
	}

	@Override
	public void browserLaunch() {
		setDriver(config("makaia.browser.name"), Boolean.parseBoolean(config("makaia.browser.isheadless")));
	}

	@Override
	public void browserLaunch(String browserName) {
		setDriver(browserName, false);
	}

	@Override
	public void loadUrl(String url) {
		getDriver().get(url);
	}

	@Override
	public WebElement locateElement(Locators locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return getDriver().findElement(By.className(value));
			case CSS_SELECTOR:
				return getDriver().findElement(By.cssSelector(value));
			case ID:
				return getDriver().findElement(By.id(value));
			case LINK_TEXT:
				return getDriver().findElement(By.linkText(value));
			case NAME:
				return getDriver().findElement(By.name(value));
			case PARTIAL_LINK_TEXT:
				return getDriver().findElement(By.partialLinkText(value));
			case TAG_NAME:
				return getDriver().findElement(By.tagName(value));
			case XPATH:
				return getDriver().findElement(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch (NoSuchElementException e) {
			//reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
			//		+ e.getMessage(), "fail");
		} catch (Exception e) {
			//reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
			//		+ e.getMessage(), "fail");
		}
		return null;
	}

	@Override
	public List<WebElement> locateElements(Locators locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return getDriver().findElements(By.className(value));
			case CSS_SELECTOR:
				return getDriver().findElements(By.cssSelector(value));
			case ID:
				return getDriver().findElements(By.id(value));
			case LINK_TEXT:
				return getDriver().findElements(By.linkText(value));
			case NAME:
				return getDriver().findElements(By.name(value));
			case PARTIAL_LINK_TEXT:
				return getDriver().findElements(By.partialLinkText(value));
			case TAG_NAME:
				return getDriver().findElements(By.tagName(value));
			case XPATH:
				return getDriver().findElements(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch (NoSuchElementException e) {
			//reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
			//		+ e.getMessage(), "fail");
		} catch (Exception e) {
			//reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
			//		+ e.getMessage(), "fail");
		}
		return null;
	}

	@Override
	public void close() {
		getDriver().close();
	}

	@Override
	public void quit() {
		getDriver().quit();
	}

}