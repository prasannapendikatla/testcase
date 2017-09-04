package jxl;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

public class EX1
{
	public static void main(String[] args) throws BiffException, IOException 
	{
		File f1=new File("d:\\123.xls");
		Workbook WB=Workbook.getWorkbook(f1);
		Sheet s1=WB.getSheet(1);
		int rows=s1.getRows();
		for(int i=1;i<rows;i++)
		{
			String gUN=s1.getCell(0, i).getContents();
			String gPWD=s1.getCell(1, i).getContents();
			System.out.println(gUN);
			System.out.println(gPWD);
			System.out.println(gUN+""+gPWD);
		}
	}
}
