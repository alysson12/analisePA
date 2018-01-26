import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class SobreposicaoIR {

    private WebDriver driver;

    public SobreposicaoIR(WebDriver driver) {
        this.driver = driver;
    }

    public void analiseTodosSobreposicaoIR (){ //analisar todos

        WebElement botaoAnalisarTodos = driver.findElement (By.xpath ("//*[@id=\"btn-analisar-todos-etapa\"]"));
        botaoAnalisarTodos.click ();

        WebElement checkTodosItens = driver.findElement (By.cssSelector ("#modalAnalisarTodasSubEtapas > div.modal-body > table > thead > tr > th > div > label > input"));
        checkTodosItens.click ();

        WebElement botaoConcluirAnalise = driver.findElement (By.xpath ("//*[@id=\"modalAnalisarTodasSubEtapas\"]/div[3]/button[1]"));
        botaoConcluirAnalise.click ();


    }

    //----------------VERIFICA SE OS ITENS DE SOBREPOSIÇÃO POSSUEM INCONSISTÊNCIA----------------//

    public void analiseItemSobreposicao (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaSobreposicaoIR = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[1]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaSobreposicaoIR.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("SobreposicaoIR", true);
        }
        else hmap.put ("SobreposicaoIR", false);

    }

    public void analiseItemTI (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaTI = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[2]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaTI.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("TI", true);
        }
        else hmap.put ("TI", false);

    }

    public void analiseItemUC (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaUC = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[3]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaUC.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("UC", true);
        }
        else hmap.put ("UC", false);
    }

    public void analiseItemAE (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaAE = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[4]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaAE.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("AE", true);
        }
        else hmap.put ("AE", false);
    }

    public void analiseItemASS (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaASS = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[5]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaASS.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("ASS", true);
        }
        else hmap.put ("ASS", false);
    }

    public void analiseItemOutrasSobreposicoes (HashMap<String, Boolean> hmap){

        WebElement botaoInconsistenciaOS = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[3]/div[2]/table/tbody/tr[6]/td[5]/div/button[2]"));

        //Se houver inconsistência
        if (botaoInconsistenciaOS.getAttribute ("class").equals ("pull-right btn btn-xs btn-default no-label btn-danger")){
            hmap.put ("OS", true);
        }
        else hmap.put ("OS", false);
    }

    public void removerInconsistencias (){
        //usar o hashmap primeiro

    }


}
