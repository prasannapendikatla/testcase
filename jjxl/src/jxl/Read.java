package jxl;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Read
{


	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
		WebDriver Brow=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(Brow,20);
		Brow.get("http://apps.qaplanet.in/qahrm/login.php");
		File f1=new File("d:\\123.xls");
		Workbook WB=Workbook.getWorkbook(f1);
		Sheet InputSheet=WB.getSheet(1);
		WritableWorkbook wwb=Workbook.createWorkbook(new File("d:\\res.xls"));
		WritableSheet OutputSheet=wwb.createSheet("HRM", 0);
		Label l=new Label(0,0,"Username");
		Label l1=new Label(1,0,"Password");
		Label l2=new Label(2,0,"Result");
		OutputSheet.addCell(l);
		OutputSheet.addCell(l1);
		OutputSheet.addCell(l2);
		Label  r1;
		Label  r2;
		Label  r3;
		int RCount=InputSheet.getRows();
		System.out.println(RCount);
		for(int i=1;i<RCount;i++)
		{
			System.out.println("Iteration no:"+i);
		
		WebElement objun=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		objun.clear();
		objun.sendKeys(InputSheet.getCell(0,i).getContents());
		WebElement objpwd=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		objpwd.clear();
		objpwd.sendKeys(InputSheet.getCell(1,i).getContents());
		WebElement objlogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		objlogin.click();
		String res="Passed";
		String res1="failed";
		if(Brow.getTitle().equals("OrangeHRM"))
		{
			System.out.println("login successfully");
		r1=new Label(0,i,InputSheet.getCell(0,i).getContents());
		r2=new Label(1,i,InputSheet.getCell(1,i).getContents());
		r3=new Label(2,i,res);
		OutputSheet.addCell(r1);
		OutputSheet.addCell(r2);
		OutputSheet.addCell(r3);
		Brow.findElement(By.linkText("Logout")).click();
		}
		else
		{
			System.out.println("login failed");
			r1=new Label(0,i,InputSheet.getCell(0,i).getContents());
			r2=new Label(1,i,InputSheet.getCell(1,i).getContents());
			r3=new Label(2,i,res);
			OutputSheet.addCell(r1);
			OutputSheet.addCell(r2);
			OutputSheet.addCell(r3);
			Brow.findElement(By.name("clear")).click();
			wwb.write();
			wwb.close();
			
		}
		}
		Brow.close();
		Brow.quit();
	}
}
	
	
		
		

