import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class AnaliseGeo {

    private WebDriver driver;
    public SobreposicaoIR sobreposicaoIR;

    public AnaliseGeo(WebDriver driver){
        this.driver = driver;
        this.sobreposicaoIR = new SobreposicaoIR(driver);
    }

    public void clickSobreposicaoIR (){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        WebElement botaoAbaAnaliseGeo = driver.findElement (By.xpath ("//*[@id=\"menuAnaliseGeo\"]"));
        botaoAbaAnaliseGeo.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void realizarAnaliseSobreposicaoIR (HashMap<String, Boolean> hmap){

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        WebElement botaoAbaAnaliseGeo = driver.findElement (By.xpath ("//*[@id=\"menuAnaliseGeo\"]"));
//        botaoAbaAnaliseGeo.click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }

        sobreposicaoIR.analiseItemSobreposicao (hmap);
        sobreposicaoIR.analiseItemTI (hmap);
        sobreposicaoIR.analiseItemUC (hmap);
        sobreposicaoIR.analiseItemAE (hmap);
        sobreposicaoIR.analiseItemASS (hmap);
        sobreposicaoIR.analiseItemOutrasSobreposicoes (hmap);
    }

    public void validarTodosItensSobreposicaoIR (){

        sobreposicaoIR.analiseTodosSobreposicaoIR ();
    }

    public void validarTodosItensCoberturaSolo (){


    }
}
