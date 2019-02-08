package seleniumadvanced.demos.seleniumday1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcel {
  
	
  public static Object[][] testExcel() throws IOException    
	{
		
		Object[][] obj = null;
		File file = new File("Resources\\Book1.xlsx");
		//try {
		InputStream is = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		obj= new Object[sheet1.getLastRowNum()][];
		for (int i=1; i<sheet1.getLastRowNum(); i++)
			{
			obj[i-1] =new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
				for (int j=0; j<sheet1.getRow(i).getPhysicalNumberOfCells(); j++)
				{
					obj[i-1][j] = sheet1.getRow(i).getCell(j).getStringCellValue();
					//System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t\t");
					/*sheet1.getRow(i).getCell(0).getStringCellValue();
					sheet1.getRow(i).getCell(1).getStringCellValue();*/
					workbook.close();
				}
				
				
			} 
		/*}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return obj;
		}

	}
