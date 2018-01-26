import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.rmi.CORBA.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Ordenação dos métodos @Test por NOME
public class TesteAnalisePA {

    private FirefoxDriver driver = new FirefoxDriver ();
    private RegistroLogin registroLogin = new RegistroLogin (driver);
    private RealizarAnalise realizarAnalise = new RealizarAnalise (driver);
    static HashMap <String, Boolean> inconsistenciasSobreposicaoIR = new HashMap <String, Boolean> ();


    @BeforeClass
    public static void inicializa(){

//        FirefoxDriver driver = new FirefoxDriver ();
//        RegistroLogin registroLogin = new RegistroLogin (driver);

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barba\\Documents\\Selenium\\geckodriver.exe");
//        this.driver = new FirefoxDriver();
//        this.registroLogin = new RegistroLogin (driver);
//        this.realizarAnalise = new RealizarAnalise (driver);
//        this.inconsistenciasSobreposicaoIR = new HashMap <String, Boolean> ();
//        login(driver, registroLogin);
    }

    public static void login (FirefoxDriver driver, RegistroLogin registroLogin){

        String usuario = "06926933600";
        String senha = "230503";
        String perfil = "Tecnico";

        //--------------------------LOGIN--------------------------//
        registroLogin.visita();
        registroLogin.clickLogin();
        Login login = new Login (driver);
        login.realizarLogin(usuario, senha, perfil);
        //---------------------------------------------------------//
    }

    @Test
    public void teste1Sobreposicao() throws InterruptedException {

        String usuario = "06926933600";
        String senha = "230503";
        String perfil = "Tecnico";
//
        String processo = "PA-1500602-263F8C74F2B04A18A02A5C0A96E87BBF";


        //--------------------------LOGIN--------------------------//
        registroLogin.visita();
        registroLogin.clickLogin();
        Login login = new Login (driver);
        login.realizarLogin(usuario, senha, perfil);
        //---------------------------------------------------------//


        //-------------------------ANALISE-------------------------//
//        realizarAnalise.clickCaixaEntrada();
        realizarAnalise.clickAnaliseTecnica();
        Analise analise = new Analise (driver);
//        analise.iniciarAnaliseTecnica(processo);
        analise.continuarAnaliseTecnica (processo);
        analise.realizarAnaliseGeoSobreposicaoIR (inconsistenciasSobreposicaoIR);
        //---------------------------------------------------------//

        //----------------------ASSERT ANALISE---------------------//
        Assert.assertTrue (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "UC"));//TESTE
        //---------------------------------------------------------//

    }

    //---------------------SOBREPOSIÇÃO DE IR-----------------------//
    @Test
    public void teste2SobreposicaoIR(){
        Assert.assertFalse (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "SobreposicaoIR"));
    }

    @Test
    public void teste3SobreposicaoTI(){
        Assert.assertFalse (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "TI"));
    }

    @Test
    public void teste4SobreposicaoUC(){
        Assert.assertTrue (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "UC"));
    }

    @Test
    public void teste5SobreposicaoAE(){
        Assert.assertFalse (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "AE"));
    }

    @Test
    public void teste6SobreposicaoASS(){
        Assert.assertFalse (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "ASS"));
    }

    @Test
    public void teste7SobreposicaoOS(){
        Assert.assertFalse (Utilidade.verificaHashmapInconsistencia (inconsistenciasSobreposicaoIR, "OS"));
    }
    //---------------------------------------------------------//

    @After
    public void finaliza(){
        driver.close();
        //driver.quit();
    }

}
