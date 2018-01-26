import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistroLogin {

    private WebDriver driver;

    public RegistroLogin(WebDriver driver){
        this.driver = driver;
    }

    public void visita(){
        driver.get("http://car.pa.java2.ti.lemaf.ufla.br/site/#/");
    }


    public void clickLogin(){
        WebElement modalLogin = driver.findElement (By.xpath ("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a"));
        modalLogin.click ();
    }


}
