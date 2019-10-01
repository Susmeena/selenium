package SeleniumFirst.Selenium19;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadri {
		public static XSSFWorkbook workBook;
		public static XSSFSheet workSheet;
		public static DataFormatter formatter= new DataFormatter();
		public static Object[][] readData() throws IOException
		{
			FileInputStream file= new FileInputStream("C:\\Users\\A08019DIRP_C2C.05.02\\Desktop\\Susmeena_testing\\datadriv.xlsx");
			workBook= new XSSFWorkbook(file);
			workSheet= workBook.getSheet("Sheet1");
			XSSFRow Row= workSheet.getRow(0);
			int rowCount=workSheet.getPhysicalNumberOfRows();
			int colCount=Row.getLastCellNum();
//			System.out.println("No of rows: "+rowCount+"\n"+ "No of cols: "+colCount);
			Object data[][]= new Object[rowCount-1][colCount];
			for(int i=0;i<rowCount-1;i++)
			{
				XSSFRow row=workSheet.getRow(i+1);
				for(int j=0;j<colCount;j++)
				{
					XSSFCell cell= row.getCell(j);
					if(cell==null)
					{
						data[i][j]="";
					}
					else
					{
						String value=formatter.formatCellValue(cell);
						data[i][j]=value;
//						System.out.println(data[i][j]);
					}
				}
			}
			return data;
		}

	}



