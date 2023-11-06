
package OTPveirificaion;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class OPT_verificaion {
	

		public static void main(String[] args) {



		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver wd = new ChromeDriver(options);
		wd.manage().window().maximize();
		wd.get("https://pbm-coin.com/");
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//
		wd.findElement(By.cssSelector("[class=\"nav-link sign_in\"]")).click();//
		wd.findElement(By.cssSelector("[href=\"/sign-up\"]")).click();//
		wd.findElement(By.cssSelector("[placeholder=\"First Name\"]")).sendKeys("Ajay Pal");
		wd.findElement(By.cssSelector(("[name=\"last_name\"]"))).sendKeys("Singh Gour");
		wd.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("ajay111@mailinator.com");
		wd.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("123456");
		wd.findElement(By.cssSelector("[placeholder=\"Confirm Password\"]")).sendKeys("123456");
		wd.findElement(By.cssSelector("[placeholder=\"Phone Number\"]")).sendKeys("9977454001");
		wd.findElement(By.cssSelector("[value=\"buyer\"]")).click();


		try {
		Thread.sleep(2000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		wd.findElement(By.cssSelector("[type=\"checkbox\"]")).click();
		wd.findElement(By.xpath("//div/button[@class=\"primary_btn\"]")).click();
		try {
		Thread.sleep(2000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		wd.switchTo().newWindow(WindowType.TAB);


		wd.get("ajay111@mailinator.com");


		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		wd.findElement(By.xpath("//table[@class=\"table-striped jambo_table\"]/tbody/tr[1]")).click();
		WebElement frame = wd.findElement(By.cssSelector("[id=\"html_msg_body\"]"));
		wd.switchTo().frame(frame);
		String otp = wd.findElement(By.tagName("h2")).getText();
		Set<String> handles = wd.getWindowHandles();
		Iterator<String> handleiterator = handles.iterator();
		String parentwindow=handleiterator.next();
		wd.switchTo().window(parentwindow);
		wd.findElement(By.cssSelector("[placeholder=\"Enter OTP\"]")).sendKeys(otp);

		wd.findElement(By.cssSelector("[class=\"primary_btn\"]")).click();

		}	
}
