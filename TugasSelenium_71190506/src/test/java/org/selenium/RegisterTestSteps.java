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
import org.testng.asserts.Assertion;

import java.util.List;

public class RegisterTestSteps {
//    WebDriver driver;
    ChromeDriver driver;
    String usernameuser;
    String passwordUser;
    String confPassUser;

    @Given("pengguna membuka browser")
    public void pengguna_membuka_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("pengguna ada di halaman register")
    public void pengguna_ada_di_halaman_register() {
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/register.php");

    }

    @When("pengguna memasukan {string} password {string} confirmpassword dan {string} username")
    public void pengguna_memasukan_password_confirmpassword_dan_username(String password, String confirmpassword, String username) {
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(username);
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(password);
        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(confirmpassword);
        passwordUser = password;
        confPassUser = confirmpassword;
        usernameuser = username;
    }

    @When("pengguna klik tombol create")
    public void pengguna_klik_tombol_create() {
        WebElement createbtn = driver.findElement(By.name("submit"));
        createbtn.click();
    }

    @Then("pengguna berada dihalaman login")
    public void pengguna_berada_dihalaman_login(){
        if(usernameuser.length() != 0 && passwordUser.length() !=0 && passwordUser.length() >= 8 && passwordUser.length()<=13){
            String expectedUrl = "https://demo.guru99.com/insurance/v1/index.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }else{
            String expectedUrl = "https://demo.guru99.com/insurance/v1/register.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }
        driver.close();
        driver.quit();

    }
}
