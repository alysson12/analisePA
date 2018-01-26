import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Analise {

    private WebDriver driver;
    public AnaliseGeo analiseGeo;

    public Analise (WebDriver driver){
        this.driver = driver;
        this.analiseGeo = new AnaliseGeo(driver);
    }


    public void iniciarAnaliseTecnica(String processoCar){


        //Busca do número de processos na página
        WebElement txtProcessos = driver.findElement (By.xpath ("//*[@id=\"paginacao_caixa_entrada_tecnico\"]/div/span/strong[2]"));
        Utilidade.aguardarElemento (txtProcessos, driver);
        int numProcessos = Integer.valueOf ((txtProcessos.getText ()).substring (0,1));
        int numeroDoProcesso = 0;

        WebElement dropVinculacao = driver.findElement (By.id ("subtiposOrdenacao"));
        dropVinculacao.click ();

        WebElement vinculacaoMaisRecente = driver.findElement (By.xpath ("//*[@id=\"caixaDeEntrada\"]/form/div[2]/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
        vinculacaoMaisRecente.click ();
        Utilidade.aguardarElemento (txtProcessos, driver);

        ArrayList <String> processos = new ArrayList ();
        processos.add (0,"0");

        //Buscando o processo em questão em meio aos processos listados
        for (int i=1;i<=numProcessos;i++){
            String busca = "//*[@id=\"caixaDeEntrada\"]/form/div[2]/table/tbody/tr[" + i + "]/td[2]";
            WebElement txtBusca = driver.findElement (By.xpath (busca));
            processos.add (i, txtBusca.getAttribute ("title"));

            if (processos.get(i).equals(processoCar)){
                numeroDoProcesso = i;
                i=i+numProcessos;
            }
        }



        //Botão Ações de processos
        WebElement botaoAcoes = driver.findElement (By.cssSelector ("#caixaDeEntrada > form > div:nth-child(2) > table > tbody > tr:nth-child(" + numeroDoProcesso + ") > td:last-child > div > #acoesProcesso"));
        botaoAcoes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        //Iniciar Análise
        WebElement botaoIniciarAnalise = driver.findElement (By.xpath ("//*[@id=\"caixaDeEntrada\"]/form/div[2]/table/tbody/tr[" + numeroDoProcesso + "]/td[8]/div/ul/li[4]/a"));
        botaoIniciarAnalise.click();

        //Confirmar Início Análise
        WebElement botaoConfirmarInicioAnalise = driver.findElement (By.xpath ("//*[@id=\"modalIniciarAnalise\"]/div/div/div[3]/div[2]/button"));
        botaoConfirmarInicioAnalise.click();
    }


    public void continuarAnaliseTecnica (String processoCar){

        //Busca do número de processos na página
        WebElement txtProcessos = driver.findElement (By.xpath ("//*[@id=\"paginacao_analise_tecnico_tecnico\"]/div/span/strong[2]"));
        Utilidade.aguardarElemento (txtProcessos, driver);
        int numProcessos = Integer.valueOf ((txtProcessos.getText ()).substring (0,1));
        int numeroDoProcesso = 0;

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        WebElement dropVinculacao = driver.findElement (By.id ("subtiposOrdenacao"));
        dropVinculacao.click ();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        WebElement vinculacaoMaisRecente = driver.findElement (By.xpath ("//*[@id=\"analiseTecnica\"]/form/div[2]/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
        vinculacaoMaisRecente.click ();
//        Utilidade.aguardarElemento (vinculacaoMaisRecente, driver);
        WebElement mfElemento = driver.findElement (By.xpath ("//*[@id=\"analiseTecnica\"]/form/div[2]/table/tbody/tr[1]/td[4]")); //MF do primeiro elemento
        Utilidade.aguardarElemento (mfElemento, driver);

        ArrayList <String> processos = new ArrayList ();
        processos.add (0,"0");

        //Buscando o processo em questão em meio aos processos listados
        for (int i=1;i<=numProcessos;i++){
            String busca = "//*[@id=\"analiseTecnica\"]/form/div[2]/table/tbody/tr[" + i + "]/td[2]";
            WebElement txtBusca = driver.findElement (By.xpath (busca));
            processos.add (i, txtBusca.getAttribute ("title"));

            if (processos.get(i).equals(processoCar)){
                numeroDoProcesso = i;
                i=i+numProcessos;
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        //Botão Ações de processos
        WebElement botaoAcoes = driver.findElement (By.cssSelector ("#analiseTecnica > form > div:nth-child(2) > table > tbody > tr:nth-child(" + numeroDoProcesso + ") > td:last-child > div > #acoesProcesso"));
        botaoAcoes.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        //Iniciar Análise
        WebElement botaoContinuarAnalise = driver.findElement (By.xpath ("//*[@id=\"analiseTecnica\"]/form/div[2]/table/tbody/tr[" + numeroDoProcesso + "]/td[8]/div/ul/li[4]/a"));
        botaoContinuarAnalise.click();

    }

    public boolean verificarExisteProcesso (){

        WebElement txtProcessos = driver.findElement (By.xpath ("//*[@id=\"paginacao_caixa_entrada_tecnico\"]/div/span/strong[2]"));
        Utilidade.aguardarElemento (txtProcessos, driver);

        int numProcessos = Integer.valueOf ((txtProcessos.getText ()).substring (0,1));

        if (numProcessos > 0) return true;

        return false;
    }

    public void realizarAnaliseGeoSobreposicaoIR (HashMap <String, Boolean> hmap){

        AnaliseGeo analise = new AnaliseGeo (driver);

        analise.clickSobreposicaoIR ();
        analise.realizarAnaliseSobreposicaoIR (hmap);
        analise.validarTodosItensSobreposicaoIR ();

    }

    public void finalizarAnaliseTecnica (){


    }
}
