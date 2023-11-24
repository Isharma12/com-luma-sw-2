package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

public class LoginTest extends BaseTest {

     static String baseUrl = "https://magento.softwaretestingboard.com/";

     @Before
    public void setUp(){
         openBrowser(baseUrl);
     }
     @Test
     public void userShouldLoginSuccessfullyWithValidCredentials(){

         //Click on sign in link
        driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
        driver.findElement(By.id("email")).sendKeys("Stacey123@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Password@1234");
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
        String expectedMessage = "Welcome, Stacey Clarke!";
        String actualMessage = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        Assert.assertEquals("Welcome, Stacey Clarke!", "Welcome, Stacey Clarke!");
     }
     @Test
     public void verifyTheErrorMessageWithInvalidCredentials(){
         driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
         driver.findElement(By.id("email")).sendKeys("Stace123@gmail.com");
         driver.findElement(By.id("pass")).sendKeys("Password@1234");
         driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
         String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
         String actualMessage = driver.findElement(By.xpath("//div[@class='message-error error message']")).getText();
         Assert.assertEquals(expectedMessage, actualMessage);
     }
     @Test
     public void userShouldLogOutSuccessfully() throws InterruptedException {
         driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
         driver.findElement(By.id("email")).sendKeys("Stacey123@gmail.com");
         driver.findElement(By.id("pass")).sendKeys("Password@1234");
         driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();
         String expectedMessage = "Welcome, Stacey Clarke!";
         String actualMessage = driver.findElement(By.xpath("(//span[text()='Welcome, Stacey Clarke!'])[1]")).getText();
         Assert.assertEquals("Welcome, Stacey Clarke!", "Welcome, Stacey Clarke!");
         Thread.sleep(5000);
         driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
//         String expectedText2 = "You are signed out";
//         String actualText2 = driver.findElement(By.xpath("//span[text()='You are signed out")).getText();
//
//         Assert.assertEquals("You are signed out", "You are signed out");


     }
     @After
    public void tearDown(){
         closeBrowser();
     }
}
