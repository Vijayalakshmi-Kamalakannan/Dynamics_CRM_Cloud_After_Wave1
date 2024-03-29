package pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PreAndPost;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{
	PreAndPost obj=new PreAndPost();

	//Verify Notification page
	public LoginPage verifyNotificationpage() throws InterruptedException {

		Thread.sleep(3000);
		if(getDriver().findElements(By.xpath("//h1[contains(text(),'Notifications')]")).size()>0)
		{
			getDriver().findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
			refreshPage();

		}
		
		Thread.sleep(3000);
		return this;
	}
	
	public LoginPage refreshPage() {
		
		obj.getUrl();
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[contains(text(),'Use another account')]"))));
		getDriver().findElement(By.xpath("//div[contains(text(),'Use another account')]")).click();
		
		return this;
	}
	

	//Enter Email Id to Login
	public LoginPage typeEmail(String email) throws InterruptedException, AWTException {
		List<WebElement> useanother=getDriver().findElements(By.xpath("//div[@id='otherTileText']"));
		if(useanother.size()>0) {
			click(getDriver().findElement(By.xpath("//div[@id='otherTileText']")),"User another Account");
		}
		System.out.println("Entering the User Id");
		verifyNotificationpage();
		Thread.sleep(2000);
		type(getDriver().findElement(By.xpath("//*[@name='loginfmt']")),email,"Email");
		Thread.sleep(3000);
		return this;
	}

	//Enter Password 
	public LoginPage typePassword(String password) throws InterruptedException {
		
		type(getDriver().findElement(By.xpath("//*[@name='passwd']")),password,"Password");
		Thread.sleep(2000);
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

		if(getDriver().findElements(By.id("idSIButton9")).size()>0){
			click(getDriver().findElement(By.id("idSIButton9")),"Yes in Stay Signed In");
		}
		Thread.sleep(2000);

		return new DashboardPage();
	}	

	//Click on Yes in stay signed in window
	public void selectPremierAccount() throws InterruptedException {
		switchToFrame(1);
		if(verifyIsDisplayed(getDriver().findElement(By.xpath("//div[@id='AppDetailsSec_1_Item_3']/div[2]")))) {
			click(getDriver().findElement(By.xpath("")),"Premier");
		}
		switchToDefaultContent();
	}	

	

}
