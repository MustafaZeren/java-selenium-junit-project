package com.testinium.project.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class BaseTestKeyword extends BaseTest{

    public void SignUp(String name,String lastName,String email,String password,String phoneNumber) throws InterruptedException {

        driver.get("https://www.gittigidiyor.com/kayit-ol");

        assertEquals("Ücretsiz Kayıt Olun - Online Alışveriş - GittiGidiyor",getTitle());

        sendByXpath("//*[@id=\"RegisterPost\"]/div[2]/div/div/div[2]/input",name);
        sendByXpath("//*[@id=\"RegisterPost\"]/div[3]/div/div/div[2]/input",lastName);
        sendById("suggestion_email_input_verifier",email);
        sendById("pwdField",password);
        sendById("gsmData",phoneNumber);

        Thread.sleep(5000);

        //sendByXpath("//*[@id=\"suggestion_email_input_verifier\"]",email);
        //sendByXpath("//*[@id=\"pwdField\"]",password);
        //sendByXpath("//*[@id=\"gsmData\"]",phoneNumber);

        callHomePage();
    }

    public void SearchProductAddToCart(String productName) throws InterruptedException {
        sendByXpath("//*[@data-cy='header-search-input']",productName);

        findElementByXpath("//*[@data-cy='header-search-input']").sendKeys(Keys.ENTER);

        Thread.sleep(5000);


        clickByXpath("//*[@id=\"best-match-right\"]/div[4]/div[3]/ul/li[1]/a/div/p/img");
        Thread.sleep(5000);


        /////////SEPETE EKLEME YAPILACAK/////////
        //clickByXpath("//*[@class=\"action-text\"]");
        //Thread.sleep(2000);
        //driver.get("https://www.gittigidiyor.com/sepetim");
        //assertEquals("Sepetim - GittiGidiyor",getTitle());
    }

    public void Login(String userName,String password) throws InterruptedException {
        driver.get("https://www.gittigidiyor.com/uye-girisi");

        assertEquals("Üye Girişi - GittiGidiyor",getTitle());

        sendById("L-UserNameField",userName);
        sendById("L-PasswordField",password);
        findElementById("L-PasswordField").sendKeys(Keys.ENTER);
    }

    public void AddLocation(String password) throws InterruptedException {

        driver.get("https://www.gittigidiyor.com/bana-ozel/adreslerim/ekle");
        sendById("L-PasswordField",password);
        findElementById("L-PasswordField").sendKeys(Keys.ENTER);
        assertEquals("GittiGidiyor - Adres bilgilerim",getTitle());
        driver.get("https://www.gittigidiyor.com/bana-ozel/adreslerim/ekle");
        assertEquals("GittiGidiyor - Adres Ekleme Formu",getTitle());

        locationFirst=new Select(findElementById("cities"));
        locationSecond=new Select(findElementById("counties"));
        locationThird=new Select(findElementById("neighborhoods"));


        /*  Adres Açıklaması  */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[1]/div[1]/div/div[2]/input","Work");
        /*        İsim        */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[1]/div[2]/div/div[2]/input","Testinium");
        /*       Soyisim      */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[1]/div[3]/div/div[2]/input","Saha BT");
        /*        Şehir       */    locationFirst.selectByVisibleText("İstanbul");
                                    Thread.sleep(1000);
        /*        İlçe        */    locationSecond.selectByVisibleText("Üsküdar");
                                    Thread.sleep(1000);
        /*       Mahalle      */    locationThird.selectByVisibleText("Acıbadem mah.");
        /*     Posta Kodu     */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[2]/div[4]/div/div[2]/input","34123");
        /*     Açık  Adres    */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[3]/div/div/div[2]/textarea","Mahalle bilgisi sokak bilgisi apartman bilgisi");
        /*  Telefon Numarası  */    sendByXpath("//*[@id=\"MyAddressContainer\"]/div/form/div[4]/div[1]/div/div[2]/input","555-5555555");

        Thread.sleep(5000);

        driver.get("https://www.gittigidiyor.com/");

    }
}