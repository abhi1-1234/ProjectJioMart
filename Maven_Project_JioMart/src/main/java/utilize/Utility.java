package utilize;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Date1904Support;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.DateFormatConverter;
import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static void getDataFromExcelSheet(String file_Path, String Sheet_name, int Row, int Cell ) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(file_Path);
		Cell s = WorkbookFactory.create(f).getSheet(Sheet_name).getRow(Row).getCell(Cell);
		try {
			String d = s.getStringCellValue();
			System.out.println(d);
		} 
		catch (Exception e) {
				try {
					long b = (long)s.getNumericCellValue();
					System.out.println(b);
				} catch (Exception x) {
						try {
						    Date l = s.getDateCellValue();
						   
						    System.out.println(l);
						}
						catch (Exception y) {
							  System.out.println("Cell is blank");
						}
				}
		}
		
		f.close();
		
	}
	
	public static void TakeScreenShotOf(WebDriver driver, String TestID) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy hh_mm_ss");
		
		LocalDateTime d = LocalDateTime.now();
	
		File dest = new File("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\" + TestID + " " + dtf.format(d) + ".jpeg");
		
		FileHandler.copy(src, dest);
		
	}
	
	
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		getDataFromExcelSheet("C:\\Users\\lenovo\\Desktop\\Testdata.xlsx", "Sheet1",2,4);	
		
		
		
		
	}
	
}
	
	