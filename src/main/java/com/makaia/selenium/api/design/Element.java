package com.makaia.selenium.api.design;

import org.openqa.selenium.WebElement;

public interface Element {
	
	public void click(WebElement ele);
	
	public void click(WebElement ele, String jsExpression);
	
	public void type(WebElement ele, String data);
	
	public String getElementText(WebElement ele);
	

}