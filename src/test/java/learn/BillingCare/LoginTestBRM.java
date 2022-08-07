package learn.BillingCare;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;

public class LoginTestBRM extends BaseClass {

    @Test
    public void loginApp(){


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
        System.out.println("Title is: "+driver.getTitle());
    }
}
