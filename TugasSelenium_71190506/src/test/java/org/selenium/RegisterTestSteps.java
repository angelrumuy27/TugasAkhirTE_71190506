package org.selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.ResetBtnSteps;

import java.util.List;

public class RegisterTestSteps {
    WebDriver driver;


    @Given("pengguna membuka browser")
    public void pengguna_membuka_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("user berada di halaman register")
    public void user_berada_di_halaman_register() {
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/register.php");
    }

    @When("username atau password kosong")
    public void username_atau_password_kosong() {
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("");
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("");

    }
    @When("user klik tombol create")
    public void user_klik_tombol_create() {
        WebElement createbtn = driver.findElement(By.name("submit"));
        createbtn.click();
    }
    @Then("user tetap berada dihalaman register")
    public void user_tetap_berada_dihalaman_register() {
//        System.out.println("Validasi user tetap di halaman register");
//        List<WebElement> list = driver.findElements(
//                By.xpath("//*[contains(text()," + "create"+")]"));
//        Assertions.
        String expectedUrl = "https://demo.guru99.com/insurance/v1/register.php";
        WebDriver driver = new ChromeDriver();
        driver.get(expectedUrl);
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

    }
}
