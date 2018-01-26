import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    private WebDriver driver;

    public Login (WebDriver driver){
        this.driver = driver;
    }


    public void realizarLogin (String usuario, String senha, String perfil){

        WebElement txtUsuario = driver.findElement (By.name ("usuario"));
        WebElement txtSenha = driver.findElement (By.xpath ("//*[@id=\"modalIntranet\"]/div/div/div[2]/form/div[2]/div/input[1]"));

        txtUsuario.sendKeys (usuario);
        txtSenha.sendKeys (senha);

        WebElement botaoAcessar = driver.findElement (By.xpath ("//*[@id=\"modalIntranet\"]/div/div/div[2]/form/div[3]/div[2]/button"));
        botaoAcessar.click ();


        WebElement modalPerfil = driver.findElement (By.xpath ("//*[@id=\"myModalLabel\"]"));
        Utilidade.aguardarElemento (modalPerfil, driver);


        if (perfil.equals ("Administrador")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[1]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Representante OC")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[2]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Proprietario")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[3]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Representante PF")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[4]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Tecnico OC")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[5]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Analista de Campo")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[6]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Administrador de Analise")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[7]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Tecnico")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[8]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("GO")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[9]/div"));
            clickPerfil.click ();
        }
        else if (perfil.equals ("Tecnico Parceiro")){
            WebElement clickPerfil = driver.findElement (By.xpath ("//*[@id=\"acessoRestiro-selecionarPerfil\"]/div[10]/div"));
            clickPerfil.click ();
        }
    }
}
