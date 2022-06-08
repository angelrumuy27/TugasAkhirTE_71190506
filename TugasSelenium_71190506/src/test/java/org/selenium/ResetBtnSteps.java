package org.selenium;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ResetBtnSteps {

    WebDriver driver;
    @Given("^user membuka browser$")
    public void user_membuka_browser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @When("^user navigate ke halaman register$")
    public void user_navigate_ke_halaman_register() throws Throwable {
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/register.php");
    }

    @When("^user memasukan username dan password$")
    public void user_memasukan_username_dan_password() throws Throwable {
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("username12");
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("123");
    }

    @When("^user klik tombol reset$")
    public void user_klik_tombol_reset() throws Throwable {
        driver.findElement(By.id("resetform")).click();//blum bisa keklik kerna bentuknya input
    }

    @Then("^Reset credentialnya$")
    public void reset_credentialnya() throws Throwable {
        System.out.println("Validasi reset credential");
        WebElement webElementUsername = driver.findElement(By.id("user_user_detail_attributes_email"));
        WebElement webElementPass = driver.findElement(By.id("user_user_detail_attributes_email"));
        try{
            assertThat(webElementUsername.getText()).isEqualTo("");
            assertThat(webElementPass.getText()).isEqualTo("");
        }finally {
            driver.close();
            driver.quit();
        }
    }

}
