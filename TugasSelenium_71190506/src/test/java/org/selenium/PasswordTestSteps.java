package org.selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordTestSteps {
    WebDriver driver;

    @Given("Pengguna membuka mesin pencarian\\(browser)")
    public void pengguna_membuka_mesin_pencarian_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("pengguna berada dihalaman register")
    public void pengguna_berada_dihalaman_register() {
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/register.php");
    }

    @When("pengguna membuat password dengan panjang kurang dari delapan atau lebih dari tiga belas")
    public void pengguna_membuat_password_dengan_panjang_kurang_dari_delapan_atau_lebih_dari_tiga_belas() {
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("angel@gmail.com");
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("pass1");
    }

    @When("pengguna menekan tombol create")
    public void pengguna_menekan_tombol_create() {
        WebElement createbtn = driver.findElement(By.name("submit"));
        createbtn.click();
    }

    @Then("gagal membuat akun")
    public void gagal_membuat_akun() {

    }

}
