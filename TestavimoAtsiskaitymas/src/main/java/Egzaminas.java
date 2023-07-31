import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Egzaminas {
    private static WebDriver browser;

    public static void main(String[] arg) {
        setupas();
        clickKurtiPaskyra();
        String vartotojoVardas = "gytisgib";
        String slaptazodis = "gytisgib";
        String prisijungimoVardas = "gytisgib";
        String slaptikas = "gytisgib";
        fillVartotojoVardas(vartotojoVardas);
        fillSlaptazodis(slaptazodis);
        clickSukurti();
        clickSukurtiPositive();
        clickSukurtiNegative();
        fillPrisijungimoVardas(prisijungimoVardas);
        fillSlaptikas(slaptikas);
        clickPrisijungti();
        clickPrisijungtiPositive();
        clickPrisijungtiNegative();
        clickAtsijungti();
        clickAtsijungtiPositive();

    }

    public static void setupas() {
        //Nurodoma, kur yra padetas projekte driver'is reikalingas sujungti koda su narsykle
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver114.exe");
        //Kad galetume pasinaudoti Selenium biblioteka turime susikurti draiverio objekta,
        // per kuri saveikausime su narsykle
        browser = new ChromeDriver();
        //Nurodome narsyklei kuri puslapi uzkrauti
        browser.get("http://localhost:8080/prisijungti");
    }

    public static void clickKurtiPaskyra() {
        //Randame Button "Sukurti nauja paskyra " pagal Xpath
        WebElement kurtiButton = browser.findElement(By.xpath("/html/body/div/form/div/h4/a"));
        JavascriptExecutor kurtiButton2 = (JavascriptExecutor) browser;
        kurtiButton2.executeScript("arguments[0].click()", kurtiButton);

        //Pauspaudziame Mygtuka "Sukurti Nauja Paskyra" naudojame .click
        //kurtiButton.click();

        //Paspaudziame Button "create an account" naudojeme .sendKeys(Keys.ENTER) VEIKIA
        //createAnAccount.sendKeys(Keys.ENTER);
    }

    public static void fillVartotojoVardas(String vartotojoVardas) {
        WebElement nameField = browser.findElement(By.xpath("//*[@id=\"username\"]"));
        nameField.sendKeys(vartotojoVardas);
    }

    public static void fillSlaptazodis(String slaptazodis) {
        WebElement passwordField = browser.findElement(By.xpath("//*[@id=\"password\"]"));
        //jeigu slaptazozdio laukelis turi viduje teksta kuri reikia istrinti kad pakeisti nauju
        passwordField.clear();
        passwordField.sendKeys(slaptazodis);
        WebElement repeatPasswordField = browser.findElement(By.xpath("//*[@id=\"passwordConfirm\"]"));
        repeatPasswordField.sendKeys(slaptazodis);
    }
    public static void fillPrisijungimoVardas(String prisijungimoVardas){
        WebElement nameField = browser.findElement(By.xpath("/html/body/div/form/div/input[1]"));
        nameField.sendKeys(prisijungimoVardas);
    }
    public static void fillSlaptikas(String slaptikas){
        WebElement passwordField = browser.findElement(By.xpath("/html/body/div/form/div/input[2]"));
        passwordField.sendKeys(slaptikas);
    }

    public static void clickSukurti() {
        WebElement sukurtiButton = browser.findElement(By.xpath("//*[@id=\"userForm\"]/button"));
        JavascriptExecutor sukurtiButtonExecutor = (JavascriptExecutor) browser;
        sukurtiButtonExecutor.executeScript("arguments[0].click()", sukurtiButton);

    }

    public static String clickSukurtiPositive() {
        WebElement sukurtiButton = browser.findElement(By.xpath("/html/body/h2"));
        String positivePranesimas = sukurtiButton.getText();
        System.out.println("Pranesimas :" + positivePranesimas);
        return positivePranesimas;
    }

    public static String clickSukurtiNegative() {
        WebElement sukurtiButton = browser.findElement(By.xpath("//*[@id=\"username.errors\"]"));
        String negativePranesimas = sukurtiButton.getText();
        System.out.println("Pranesimas :" + negativePranesimas);
        return negativePranesimas;
    }

    public static void clickPrisijungti() {
        WebElement prisijungtiButton = browser.findElement(By.xpath("/html/body/div/form/div/button"));
        JavascriptExecutor prisijungtiButtonExecutor = (JavascriptExecutor) browser;
        prisijungtiButtonExecutor.executeScript("arguments[0].click()", prisijungtiButton);
    }

    public static String clickPrisijungtiPositive() {
        WebElement prisijungtiButton = browser.findElement(By.xpath("/html/body/nav/div/div/a"));
        String positivePranesimas = prisijungtiButton.getText();
        System.out.println("Pranesimas :" + positivePranesimas);
        return positivePranesimas;
    }

    public static String clickPrisijungtiNegative() {
        WebElement prisijungtiButton = browser.findElement(By.xpath("/html/body/div/form/div/span[2]"));
        String negativePranesimas = prisijungtiButton.getText();
        System.out.println("Pranesimas :" + negativePranesimas);
        return negativePranesimas;
    }
    public static void  clickAtsijungti(){
        WebElement atsijungtiButton = browser.findElement(By.xpath("/html/body/nav/div/ul[2]/a"));
        JavascriptExecutor atsijungtiButtonExecutor = (JavascriptExecutor) browser;
        atsijungtiButtonExecutor.executeScript("arguments[0].click()", atsijungtiButton);
    }
    public static String clickAtsijungtiPositive(){
        WebElement atsijungtiButton = browser.findElement(By.xpath("/html/body/div/form/div/span[1]"));
        String positivePranesimas = atsijungtiButton.getText();
        System.out.println("Pranesimas :" + positivePranesimas);
        return positivePranesimas;
    }

}
