package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */

public class SaleTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() throws InterruptedException {

        driver.findElement(By.xpath("//span[.='Sale']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        Thread.sleep(2000);
        String exceptedMessage = "Jackets";
        Thread.sleep(2000);
        String actual = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        Thread.sleep(2000);
        List<WebElement> itemsName = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        Thread.sleep(2000);
        System.out.println("Total Items : "+items.size());

        for(WebElement list : itemsName){
            System.out.println(list.getText());
        }

        int count = 12;
        int actualCount = items.size();
        Assert.assertEquals(count,actualCount);



    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}


