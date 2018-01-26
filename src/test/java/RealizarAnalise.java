import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealizarAnalise {

    private WebDriver driver;

    public RealizarAnalise(WebDriver driver){
        this.driver = driver;
    }

    public void clickCaixaEntrada (){

        //ALTERAR PARA AGUARDAR ELEMENTO
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        WebElement botaoCaixaEntrada = driver.findElement (By.id ("menuCaixaEntradaTecnico"));
        botaoCaixaEntrada.click ();
    }

    public void clickAnaliseTecnica (){

        //ALTERAR PARA AGUARDAR ELEMENTO
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        WebElement botaoAnaliseTecnica = driver.findElement (By.id ("menuAnaliseTecnica"));
        botaoAnaliseTecnica.click ();
    }
}
