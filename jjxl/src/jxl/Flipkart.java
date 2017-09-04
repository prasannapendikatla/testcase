package jxl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class Flipkart 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
		WebDriver Brow=new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		//WebDriver Brow=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(Brow,20);
		Brow.get("https://www.flipkart.com/");
		Actions A=new Actions(Brow);
		A.moveToElement(Brow.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a"))).perform(); 
		A.moveToElement(Brow.findElement(By.linkText("Mobiles"))).perform();
		A.moveToElement(Brow.findElement(By.linkText("Samsung"))).click().perform();
		Thread.sleep(2000);
	
	WebElement LtoH=Brow.findElement(By.xpath("//html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/section/ul/li[2]"));
	LtoH.click();
	Thread.sleep(4000);
	List<WebElement> name=Brow.findElements(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[1]/div[1]"));
	List<WebElement> price=Brow.findElements(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[2]/div/div/div"));
	System.out.println(name.size());
	for(WebElement m:name)
	{
		System.out.println(m.getText());
	}
	System.out.println("names printed");
	for(int i=0;i<price.size();i++)
	{
		System.out.println(price.get(i).getText());
	}
	
	/* int rc=Brow.findElements(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[1]/div[1]")).size();
	for (int i = 1; i <=rc; i++) {
		String name=Brow.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/div/a/div[2]/div[1]/div[1]")).getText();
		System.out.println(name);
	
	int rc1=Brow.findElements(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[2]/div/div/div")).size();
	for (int j = 1; j <=rc1; j++) {
		String price=Brow.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+j+"]/div/a/div[2]/div[2]/div/div/div")).getText();
		System.out.println(price);*/
	Thread.sleep(2000);
	WritableWorkbook wwb=Workbook.createWorkbook(new File("d:\\Login5.xls"));
	WritableSheet ws=wwb.createSheet("Flipkart", 0);
WritableSheet ws1=wwb.createSheet("RES", 1);
	Label l=new Label(0,0,"name");
	Label l1=new Label(1,0,"price");
	for(int j=0;j<name.size();j++)
		
	{
		String mmn1= name.get(j).getText();
		//String mmp1= price.get(j).getText();
		
		Label r1=new Label(0, j, mmn1);
       // Label r2=new Label(1, j, mmp1);
      
		ws.addCell(r1);
		//ws.addCell(r2);			
	}
	for(int i=0;i<price.size();i++)
	{
	
		String mmp1= price.get(i).getText();
		 Label r2=new Label(1, i, mmp1);
		 ws.addCell(r2);	
		
	}

	ws.addCell(l);
	ws.addCell(l1);
	wwb.write();
	wwb.close();

	
	
	}
}
