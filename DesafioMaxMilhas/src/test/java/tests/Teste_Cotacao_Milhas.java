package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import pages.LancaCotacaoPage;
import support.Generator;
import support.Screenshot;
import support.Web;

/*
 * CENÁRIO PROPOSTO:
 * - Acessar a pagina de vendas de milhas (https://www.maxmilhas.com.br/vender-milhas)
 * - Fazer uma cotação completa validando o valor a receber pela venda de milhas
 * - Fazer uma cotação, validando a quantidade invalida de milhas para se efetuar a cotação.
 * - Gerar evidências através de Screenshot
 * Fazer utilizando PageObjects.
 * */

public class Teste_Cotacao_Milhas {

	private WebDriver navegador;
	@Rule
	public TestName telaDoTeste = new TestName();

	@Before
	public void setUp() {
		navegador = Web.createNavegador();
	}

	
	@Test
	public void executaCotacao() {

		String resultado, resultadoEsperado;
		
		resultadoEsperado = new LancaCotacaoPage(navegador).calculaVlrReceber("3900", "32,00");
		
		resultado = new LancaCotacaoPage(navegador).cotacaoCompleta("3900", "3200").valorAReceber();
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void executaCotacaoComMilhasInsuficiente() {
		String msg, msgEsperada;
		msgEsperada = "A oferta precisa ter no mínimo 3.500 milhas";

		msg = new LancaCotacaoPage(navegador).cotacaoMilhasInsuficiente("2111").msgQtdeInsuficienteMilhas();
		assertEquals(msgEsperada, msg);
	}

	@After 
	public void capturaTela() {
		String EvidenciaDeTeste = System.getProperty("user.dir") + "\\target\\relatorios\\evidencias\\"
				+ Generator.dataHoraParaArquivo() + telaDoTeste.getMethodName() + ".png";
		Screenshot.tirar(navegador, EvidenciaDeTeste);
	}

	@After
	public void fechaBrowser() {
	 navegador.quit();
	}
}
