package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaPages {
    WebDriver driver;
    public JavascriptExecutor js;
    static int n = 0;
    static int environment1=0;
    static int environment2=0;
    String environment="";

    public QaPages(WebDriver webDriver) {
        driver= webDriver;
        js=(JavascriptExecutor) driver;



    }
    public void gettingEnvironment(String arg0) {
         environment =arg0;
        if(arg0.equals("Qa1"))
        {
            n=2;
        }
        else if(arg0.equals("QA2"))
        {
            n=3;
        }
        else if(arg0.equals("Stg"))
        {
            n=4;
        }
        else if(arg0.equals("Preprod"))
        {
            n=5;
        }
        else if (arg0.equals("Prod"))
        {
            n=6;
        }
    }


    public void gettingAppName() throws IOException {

        int limit=334;
        String filepath= ("/Users/poornabharathi/Downloads/QA2.csv");
        File file= new File(filepath);
        Workbook wb= new XSSFWorkbook();
        Sheet sh= wb.createSheet("Sheet1");
        Row rw= sh.createRow(0);
        Cell cl=rw.createCell(0);
        cl.setCellValue("AppName");

//        Date objDate = new Date();
//        String strDateFormat = "dd MMM yyyy  hh:mm";
//        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
//        String obj = objSDF.format(objDate);
//        String filename =environment  + obj;
//        FileWriter writer = new FileWriter("/Users/poornabharathi/Documents/"+filename+".txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        int j=1;

        List<String> list=new ArrayList<>();
        for(int i=1;i<=limit;i++)
        {

            WebElement reference = driver.findElement(By.xpath("//div//div//tr["+i+"]//td["+n+"]"));

            if(reference.getText().equals(""))
            {
                WebElement Appname = driver.findElement(By.xpath("//div//div//tr["+i+"]//td[1]"));
                System.out.println(Appname.getText());
                String name=Appname.getText();
                list.add(name);

            }



        }

        for(String x:list)
        {
            rw= sh.createRow(j);
            cl=rw.createCell(0);
            cl.setCellValue(x);
            j+=1;
        }
        FileOutputStream fos=new FileOutputStream(file);
        wb.write(fos);

    }


    public void gettingEnvironment1(String arg0, String arg1) {
        int k=2;
        while(k<7)
        {
            WebElement env1=driver.findElement(By.xpath("//tr//th["+k+"]"));
            if(env1.getText().equals(arg0))
            {
                environment1=k;
            }
            WebElement env2 = driver.findElement(By.xpath("//tr//th["+k+"]"));
            if(env2.getText().equals(arg1))
            {
                environment2=k;
            }
            k++;

        }

    }

    public void gettingMismatch() {
        int limit=334;

        for(int i=1;i<=limit;i++)
        {
            WebElement env1Reference = driver.findElement(By.xpath("//div//div//tr["+i+"]//td["+environment1+"]"));
            WebElement env2Reference = driver.findElement(By.xpath("//div//div//tr["+i+"]//td["+environment2+"]"));

            js.executeScript("arguments[0].scrollIntoView()",env1Reference);
            if(env1Reference.getText().equals(env2Reference.getText()))
            {
                continue;
            }
            else
            {
                WebElement Appname = driver.findElement(By.xpath("//div//div//tr["+i+"]//td[1]"));
                System.out.println(Appname.getText());
            }
        }
    }
}
