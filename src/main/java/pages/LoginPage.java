package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver=driver;
    }

    @FindBy(xpath="//input[@name='j_username']") WebElement uname;
    @FindBy(xpath="//input[@name='j_password']") WebElement pass;
    @FindBy(xpath="//a[@id='j_submit']") WebElement loginButton;

    public void loginToCRM(String username, String password){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        uname.sendKeys(username);
        pass.sendKeys(password);
        loginButton.click();
    }
}
