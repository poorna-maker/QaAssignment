package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String;
import java.util.List;
public class SnapShotPage {
    WebDriver driver;
    public SnapShotPage(WebDriver webDriver) {
        driver=webDriver;
    }
    public void misMatch(String string) throws IOException {
        String filepath= ("/Users/poornabharathi/Downloads/Snap.csv");
        File file= new File(filepath);
        //create the blank workbook
        Workbook wb= new XSSFWorkbook();
        //create the blank excel sheet
        Sheet sh= wb.createSheet("Sheet1");
        //define the position in the excel sheet where write operation needs to perform
        Row approw= sh.createRow(0);
        approw.createCell(0).setCellValue("AppName");
        sh.setColumnWidth(0,10000);
        approw.createCell(1).setCellValue("QA1");
        sh.setColumnWidth(1,10000);
        approw.createCell(2).setCellValue("QA2");
        sh.setColumnWidth(2,10000);
        approw.createCell(3).setCellValue("Preprod");
        sh.setColumnWidth(3,10000);


//        Cell appcell=approw.createCell(0);
//        appcell.setCellValue("AppName");
//       Row qa1row= sh.createRow(0);
//        Cell qa1cell=qa1row.createCell(1);
//        qa1cell.setCellValue("QA1");
//        Row qa2row= sh.createRow(0);
//        Cell qa2cell=qa2row.createCell(2);
//        qa2cell.setCellValue("QA1");
//        Row preprodrow= sh.createRow(0);
//        Cell preprodcell=preprodrow.createCell(3);
//        preprodcell.setCellValue("Preprod");
        //define input type
        //cl.setCellType(CellType.STRING);
        //define the data value

        //


        //wb.write(fos);
//        Date objDate = new Date();
//        String strDateFormat = "dd MMM yyyy  hh:mm";
//        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
//        String obj = objSDF.format(objDate);
//        String filename =environment  + obj;
//        FileWriter writer = new FileWriter("/Users/poornabharathi/Documents/"+filename+".txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        int j=1;
        List<String> appName=new ArrayList<>();
        List<String> qa1=new ArrayList<>();
        List<String> qa2=new ArrayList<>();
        List<String> preprod=new ArrayList<>();



        // bufferedWriter.close();
        HashMap<String, Integer> environmentValue = new HashMap<String, Integer>();
        environmentValue.put("Qa1", 2);
        environmentValue.put("QA2", 3);
        environmentValue.put("Stg", 4);
        environmentValue.put("Preprod", 5);
        environmentValue.put("Prod", 6);

         System.out.println("Appname                         | "+"Qa1               | "+"QA2                | "+"Preprod    ");

        int value1 = environmentValue.get(string);
        System.out.println(value1);
        for (int i = 1; i < 335; i++) {
            if (driver.findElement(By.xpath("//tr[" + i + "]//td[" + value1 + "]")).getText().contains("SNAPSHOT")){
                WebElement appname=driver.findElement(By.xpath("//tbody[@id='tableBody']//tr[" + i + "]//td[1]"));
                WebElement Qa1=driver.findElement(By.xpath("//tbody[@id='tableBody']//tr[" + i + "]//td[2]"));
                WebElement QA2=driver.findElement(By.xpath("//tbody[@id='tableBody']//tr[" + i + "]//td[3]"));
                WebElement Preprod=driver.findElement(By.xpath("//tbody[@id='tableBody']//tr[" + i + "]//td[5]"));
                appName.add(appname.getText());
                qa1.add(Qa1.getText());
                qa2.add(QA2.getText());
                preprod.add(Preprod.getText());

                System.out.println(appname.getText()+"             | "+Qa1.getText()+"      | "+QA2.getText()+"      | "+Preprod.getText());
            }
        }
        for(int i=0;i<appName.size();i++)
        {
            approw= sh.createRow(j);
            approw.createCell(0).setCellValue(appName.get(i));
            approw.createCell(1).setCellValue(qa1.get(i));
            approw.createCell(2).setCellValue(qa2.get(i));
            approw.createCell(3).setCellValue(preprod.get(i));

//            qa1cell=approw.createCell(1);
//            qa1cell.setCellValue(qa1.get(i));
//            qa2row= sh.createRow(j);
//            qa2cell=qa2row.createCell(2);
//            qa2cell.setCellValue(appName.get(i));
//            preprodrow= sh.createRow(j);
//            preprodcell=preprodrow.createCell(3);
//            preprodcell.setCellValue(appName.get(i));
            j+=1;
        }
        FileOutputStream fos=new FileOutputStream(file);
        wb.write(fos);
    }
}