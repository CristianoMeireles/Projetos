package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidaCotacao extends BasePage{

	public ValidaCotacao(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String valorAReceber(){
		return aguardaCarregarElemento(By.cssSelector("strong[class=simulator-miles--total-price")).getText();
	}
	
	public String msgQtdeInsuficienteMilhas(){
		return aguardaCarregarElemento(By.cssSelector("div > p[class=\"text-right text-invalid\"]")).getText();
	}

}
