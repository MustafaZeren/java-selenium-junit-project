package com.testinium.project.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver driver;
    protected Select locationFirst;
    protected Select locationSecond;
    protected Select locationThird;

    @Before
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        this.driver.get("https://www.gittigidiyor.com/");
        //clickByText("Tamam");
    }

    @After
    public void endTest() throws InterruptedException {
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public void clickByText(String text){
        driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    }

    public void clickByLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void sendByXpath(String xpath,String value) { driver.findElement(By.xpath(xpath)).sendKeys(value);}

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void callHomePage() {
        driver.get("https://www.gittigidiyor.com/");
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }

}
