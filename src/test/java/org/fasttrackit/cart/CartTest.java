package org.fasttrackit.cart;

import org.fasttrackit.App;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest {
    @Test
    public void checkSizeAndColor()
    {
        System.setProperty("webdriver.chrome.driver",
                App.getChromeDriverPath());

        WebDriver driver = new ChromeDriver();
        driver.get(App.getSiteUrl());

        WebElement element = driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Women']"));

        Actions action = new Actions(driver) {

            public void perform() {

            }
        };


        action.moveToElement(element).build().perform();

        driver.findElement(By.linkText("New Arrivals")).click();

        driver.findElement(By.xpath("//div[@class='product-info']//a[text()='View Details']")).click();

        driver.findElement(By.xpath("//div[@class='input-box']//*[contains(text(),'Pink')]")).click();

    }


    @Test
    public void addProductToCart() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/ioana/Desktop/WebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        // xpath concatenated here just to be displayed on two rows and be visible all at once
        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()" +
                "='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();

        WebElement successMessageContainer = driver.findElement(By.cssSelector(".success-msg"));

        assertThat("Product not added to cart.",
                successMessageContainer.getText(),
                containsString("Herald Glass Vase"));

        // todo: assert that product is present in cart


    }
}




