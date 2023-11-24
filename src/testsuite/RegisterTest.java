package testsuite;
/**
 * Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //Click on the 'Create an Account' link
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();

        String expectedMessage = "Create New Customer Account";
        String actualMessage = driver.findElement(By.xpath("//span[@id='page-title-wrapper'or@class='base']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(2000);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[1]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Stacey");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Clarke");
        driver.findElement(By.id("email_address")).sendKeys(+ randomInt + "@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("Password@1234");
        driver.findElement(By.id("password-confirmation")).sendKeys("Password@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
        Thread.sleep(2000);
        String expectedMessage = "Thank you for registering with Main Website Store.";
        String actualMessage = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(2000);
       driver.findElement(By.xpath("(//button[@tabindex='-1'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        Thread.sleep(2000);
//        String expectedText2 = "You are signed out";
//        driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
//       // String actualtest2 = actualText2.getText();
//        Assert.assertEquals("You are signed out", "You are signed out");

    }
        @After
        public void tearDown () {
            closeBrowser();
        }

}