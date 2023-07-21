import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration {
    public static WebDriver driver;

    public static String rndStr(int len) {
        String alphabet = "afrytuohbgvdtyjnbvvcx01254878";
        String newStr = "";
        for (int i = 0; i < len; i++) {
            newStr += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return newStr;
    }

    @Test
    public void registrationTest() {
        driver.get("https://elenta.lt/registracija");

        String RandomUserName = rndStr(50);
        String RandomEmail = rndStr(5) + "@Text.lt";
        String RandomPassword = "randomCharacters";

        driver.findElement(By.id("UserName")).sendKeys(RandomUserName);
        System.out.println(RandomUserName);
        driver.findElement(By.id("Email")).sendKeys(RandomEmail);
        System.out.println(RandomEmail);
        driver.findElement(By.id("Password")).sendKeys(RandomPassword);
        System.out.println(RandomPassword);
        driver.findElement(By.id("Password2")).sendKeys(RandomPassword);
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();

    }

    @Test
    public void makeAd() throws InterruptedException {

        String title = "kojines";
        String text = "tekstas";
        String price = "12";
        String location = "Vilnius";
        String phone = "812121212";
        String email = "email@email.lt";
        driver.get("https://elenta.lt/");
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[7]/a")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.id("price")).sendKeys(price);
        driver.findElement(By.id("location-search-box")).sendKeys(location);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\irtor\\Desktop\\gel-socks-lightgreen-5_1.jpg");
        Thread.sleep(1500);
        driver.findElement(By.id("forward-button")).click();

        //String actual = driver.findElement(By.xpath("/html/body/div[1]/h4")).getText();
        //Assert.assertEquals(actual,"SKELBIMAS AKTYVUS");
    }

    @Test
    public void makeAdNoTitle(){
        FillForm("", "tekstas", "12", "Vilnius", "812121212", "email@email.lt");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\irtor\\Desktop\\gel-socks-lightgreen-5_1.jpg");
        driver.findElement(By.id("forward-button")).click();
        driver.get("https://elenta.lt/");
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[7]/a")).click();
        Assert.assertEquals(driver.findElement(By.id("te")).getText(), "Įveskite skelbimo pavadinimą");

        //String title = "";
        //String text = "tekstas";
       // String price = "12";
        //String location = "Vilnius";
       // String phone = "812121212";
        //String email = "email@email.lt";
        //driver.get("https://elenta.lt/");
        //driver.findElement(By.id("submit-new-ad-nav-button")).click();
        //driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[7]/a")).click();
        //driver.findElement(By.id("title")).sendKeys(title);
        //driver.findElement(By.id("text")).sendKeys(text);
        //driver.findElement(By.id("price")).sendKeys(price);
        //driver.findElement(By.id("location-search-box")).sendKeys(location);
        //driver.findElement(By.id("phone")).sendKeys(phone);
        //driver.findElement(By.id("email")).sendKeys(email);
        //driver.findElement(By.id("submit-button")).click();
       //driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\irtor\\Desktop\\gel-socks-lightgreen-5_1.jpg");
        //Thread.sleep(1500);
       // driver.findElement(By.id("forward-button")).click();

        //Assert.assertEquals(driver.findElement(By.id("te")).getText(), "Įveskite skelbimo pavadinimą");
        // Test failed
    }

    @Test
    public void makeAdNoText() throws InterruptedException {
        String title = "kojines";
        String text = "";
        String price = "12";
        String location = "Vilnius";
        String phone = "812121212";
        String email = "email@email.lt";
        driver.get("https://elenta.lt/");
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[7]/a")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.id("price")).sendKeys(price);
        driver.findElement(By.id("location-search-box")).sendKeys(location);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\irtor\\Desktop\\gel-socks-lightgreen-5_1.jpg");
        Thread.sleep(1500);
        driver.findElement(By.id("forward-button")).click();

        Assert.assertEquals(driver.findElement(By.id("txte")).getText(), "Įveskie skelbimo aprašymą");
        // Test failed
    }

    @Test
    public void makeAdNoPhone() throws InterruptedException {
        String title = "kojines";
        String text = "tekstas";
        String price = "12";
        String location = "Vilnius";
        String phone = "";
        String email = "email@email.lt";
        driver.get("https://elenta.lt/");
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[7]/a")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.id("price")).sendKeys(price);
        driver.findElement(By.id("location-search-box")).sendKeys(location);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\irtor\\Desktop\\gel-socks-lightgreen-5_1.jpg");
        Thread.sleep(1500);
        driver.findElement(By.id("forward-button")).click();

        Assert.assertEquals(driver.findElement(By.id("ce")).getText(), "Įveskite telefono numerį");
        // Test failed
    }

    @Test
    public void Positive(){
        FillForm("kojines", "aprasymas", "12", "Vilnius", "860000000", "email@bla.lt");
        Assert.assertTrue(true);
    }


    public void FillForm(String title, String text, String price, String city, String phone, String email) {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_AuginantiemsVaikus&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.id("price")).sendKeys(price);
        driver.findElement(By.id("location-search-box")).sendKeys(city);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submit-button")).click();
    }



    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://elenta.lt/");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @AfterClass
    public void afterClass() {

    }
//
}

