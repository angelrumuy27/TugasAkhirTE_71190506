package org.selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import java.util.List;

public class LoginTestSteps {
    WebDriver driver;
    String usernameUser;
    String passUser;

    @Given("pengguna buka browser")
    public void pengguna_buka_browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("pengguna berada pada halaman login")
    public void pengguna_berada_pada_halaman_login() {
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
    }
    @When("pengguna menginput {string} password dan {string} username")
    public void pengguna_menginput_password_dan_username(String password, String username) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        usernameUser = username;
        passUser = password;
    }
    @When("pengguna menekan tombol login")
    public void pengguna_menekan_tombol_login() {
        driver.findElement(By.name("submit")).click();
    }

    @Then("pengguna berada dihalaman home")
    public void pengguna_berada_dihalaman_home() {
//        harusnya Kalo username pass null berarti tdk bisa login
        if(usernameUser.length() == 0 && passUser.length() ==0){
            String expectedUrl = "https://demo.guru99.com/insurance/v1/index.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            //        harusnya Kalo username atau pass null berarti tdk bisa login
        }else if(usernameUser.length() == 0 || passUser.length() ==0){
            String expectedUrl = "https://demo.guru99.com/insurance/v1/index.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }else{
            String expectedUrl = "https://demo.guru99.com/insurance/v1/header.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        }

        driver.close();
        driver.quit();


    }
}
