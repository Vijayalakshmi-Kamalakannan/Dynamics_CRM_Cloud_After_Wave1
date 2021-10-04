package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{

//Enter Email Id to Login
	public LoginPage typeEmail(String email) throws InterruptedException {
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("//*[@name='loginfmt']")),email,"Email");
		return this;
	}
	
//Enter Password 
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.xpath("//*[@name='passwd']")),password,"Password");
		return this;
	}

//Click on Next
	public LoginPage clickNext() throws InterruptedException {
		click(getDriver().findElement(By.id("idSIButton9")),"Next");
		Thread.sleep(2000);
		return new LoginPage();
	}	
//Click on Signin
	public LoginPage clicSignin() throws InterruptedException {
		click(getDriver().findElement(By.id("idSIButton9")),"Signin");
		Thread.sleep(2000);
		return new LoginPage();
	}	

//Click on Yes in stay signed in window
	public DashboardPage clicYesInStaySignedin() throws InterruptedException {
		click(getDriver().findElement(By.id("idSIButton9")),"Yes in Stay Signed In");
		Thread.sleep(2000);
		return new DashboardPage();
	}	

		
	
}
