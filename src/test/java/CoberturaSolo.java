import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoberturaSolo {

    private WebDriver driver;

    public CoberturaSolo (WebDriver driver){
        this.driver = driver;
    }

    public void clickCoberturaSolo (){

        WebElement abaCobertura = driver.findElement (By.xpath ("//*[@id=\"page-wrap\"]/div/div/article/div[2]/div[7]/div[2]/ul/li[2]/a"));
        abaCobertura.click ();

        WebElement botaoClassificar = driver.findElement (By.xpath ("//*[@id=\"CLASSIFICACAO_TECNICO_9\"]/div/button[1]/span[2]"));

    }

    public void analiseTodosCoberturaSolo (){

        WebElement botaoAnalisarTodos = driver.findElement (By.xpath ("//*[@id=\"btn-analisar-todos-etapa\"]"));
        botaoAnalisarTodos.click ();

        WebElement checkTodosItens = driver.findElement (By.xpath ("//*[@id=\"modalAnalisarTodos\"]/div[2]/table/thead/tr/th/div/label/input"));
        checkTodosItens.click ();

        WebElement botaoConcluirAnalise = driver.findElement (By.xpath ("//*[@id=\"modalAnalisarTodos\"]/div[3]/button[1]"));
        botaoConcluirAnalise.click ();

    }
}
