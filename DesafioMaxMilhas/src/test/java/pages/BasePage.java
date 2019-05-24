package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver navegador;

	public BasePage(WebDriver driver)
	{
		this.navegador = driver;
	}
	
	public void waitFindElement(By elemento){
		WebDriverWait aguardar = new WebDriverWait(navegador,8000);
		aguardar.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}
	
	public WebElement aguardaCarregarElemento(By elemento){
		waitFindElement(elemento);
		return this.navegador.findElement(elemento);
	}
}