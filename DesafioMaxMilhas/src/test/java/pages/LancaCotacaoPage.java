package pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LancaCotacaoPage extends BasePage{

	public LancaCotacaoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	public LancaCotacaoPage clicarBotao(){
		String botao = "#balloon1 button[data-action=\"ballons-make-your-sale\"]";
		
		aguardaCarregarElemento(By.cssSelector(botao)).click();
		return this;
	}
	public LancaCotacaoPage clicarBotao1(String botao){
		aguardaCarregarElemento(By.cssSelector(botao)).click();
		return this;
	}
	
	public LancaCotacaoPage defineCompanhiaViagem(){
		String companhia = "a[href$=\"vender-milhas/latam-multiplus\"]";
		
		aguardaCarregarElemento(By.cssSelector(companhia)).click();
		return this;
	}
	
	public LancaCotacaoPage informaQdteMilhas(String qtdeMilhas){
		String campo = "input[data-action=simulator-miles-quant-miles]";
		
		aguardaCarregarElemento(By.cssSelector(campo)).sendKeys(qtdeMilhas);
		return this;
	}
	public ValidaCotacao informaValorMilhas(String valorMilhas){
		String campo = "input[data-action=simulator-miles-price]";
		aguardaCarregarElemento(By.cssSelector(campo)).sendKeys(valorMilhas);
		return new ValidaCotacao(navegador);
	}

	public ValidaCotacao cotacaoCompleta(String qtdeMilhas,String valorMilhas){
		clicarBotao();
		defineCompanhiaViagem();
		informaQdteMilhas(qtdeMilhas);
		informaValorMilhas(valorMilhas);
		
		return new ValidaCotacao(navegador);
	}
	
	public ValidaCotacao informaQdteInsuficienteMilhas(String qtdeMilhas){
		String campo = "input[data-action=simulator-miles-quant-miles]";		
		aguardaCarregarElemento(By.cssSelector(campo)).sendKeys(qtdeMilhas);
		
		return new ValidaCotacao(navegador);	
	}
	
	public  String calculaVlrReceber(String qtdeMilhas,String valorMilhas){
		BigDecimal qtde, vlr, Resultado;
		
		qtde = new BigDecimal(qtdeMilhas).divide(new BigDecimal("1000"));
		vlr  = new BigDecimal(valorMilhas.replace(",", "."));
		Resultado = qtde.multiply(vlr);
		Resultado = Resultado.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		String resultadoConvertido = "R$ "+Resultado.toPlainString().replace(".", ",");
		return resultadoConvertido;
	}
	
	public ValidaCotacao cotacaoMilhasInsuficiente(String qtdeMilhas){
		clicarBotao();
		defineCompanhiaViagem();
		informaQdteMilhas(qtdeMilhas);		
		return new ValidaCotacao(navegador);
	}	
}
