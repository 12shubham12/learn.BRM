package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    //screenshots, windows, alerts, frames, sync issue, javascript executor

    public static void captureScreenshot(WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //copy screenshot to some location
        try {
            FileHandler.copy(src, new File("./Screenshots/BRM_"+getCurrentDateTime()+".png"));
            System.out.println("Screenshot captured");
        }
        catch(Exception e){
            System.out.println("Unable to capture screenshot "+e.getMessage());
        }
    }

    public static String getCurrentDateTime(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }
}