package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web {

	public static WebDriver createNavegador()
	{
		WebDriver navegador = new ChromeDriver();
		//Abrindo a pagina
		navegador.get("https://www.maxmilhas.com.br/vender-milhas");
		navegador.manage().window().maximize();			
	    return navegador;
	}
}
