package jxl;



import java.io.File;
import java.io.IOException;



import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Write
{
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException
	{
		
		WritableWorkbook wwb=Workbook.createWorkbook(new File("d:\\Login22.xls"));
		WritableSheet ws=wwb.createSheet("HRM", 0);
		WritableSheet ws1=wwb.createSheet("RES", 1);
		Label l=new Label(0,0,"Username");
		Label l1=new Label(1,0,"Password");
		Label r1=new Label(0,1,"qaplanet1");
		Label r2=new Label(1,1,"admin");
		ws.addCell(l);
		ws.addCell(l1);
		ws.addCell(r1);
		ws.addCell(r2);
		wwb.write();
		wwb.close();
		
		
		
	}
}
