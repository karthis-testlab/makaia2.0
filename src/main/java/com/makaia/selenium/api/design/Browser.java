package com.makaia.selenium.api.design;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface Browser {
	
	
	public void browserLaunch();
	
	public void browserLaunch(String browserName);
	
	public void loadUrl(String url);
	
	public WebElement locateElement(Locators locatorType);
	
	public List<WebElement> locateElements(Locators locatorType);
	
	public void close();
	
	public void quit();

}