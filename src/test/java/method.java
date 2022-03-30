import io.cucumber.messages.internal.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class method {
    WebDriver driver;

    public void calculator(int x,int y){
        try {

            int a = 12, b = 5, c = 50, result, addition;
            addition = x + y;
            result = a * b;
            System.out.println("multi.result is " + result);
            System.out.println("addition result is " + addition);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    public void string(){
        String c="raj",d="raj";
        String name= new String("india");
        String country= new String("india");
        System.out.println("the length of variable c is "+c.length());
        System.out.println("the length of variable d is "+d.length());
        System.out.println(name==country);
        System.out.println(name.hashCode());
        System.out.println(country.hashCode());

        if(name.equalsIgnoreCase(country))
            System.out.println("the sting are equal");
        else
            System.out.println("string are not equal");

    }
    public void reverse_string(){
        String first="i know java program";
        String[] words= first.split(" ");
        String reverse2= "";
       /* System.out.println(first.length());
        System.out.println(words.length);*/
        for(int i=0;i<=words.length-1;i++) {

            if (words[i].equalsIgnoreCase("know")) {
                char[] word = words[i].toCharArray();
                for (int j = word.length - 1; j >= 0; j--) {
                    reverse2 = reverse2 + word[j];

                }
                System.out.print(reverse2+" ");

            }
            else
            System.out.print(words[i]+" ");


        }

/*

        StringBuffer sb= new StringBuffer("i know java program");

        String reverse="";
        for(int i=first.length()-1;i>=0;i--){
            reverse=reverse+first.charAt(i);

        }
        System.out.println(reverse);

        System.out.println(sb.reverse());
*/


    }
    public void reverse_each_string(){
        String originalstring= "my name is rahul";
        String[] name_array=originalstring.split(" ");
        String reverse="";
        for(int i=0;i<name_array.length;i++){
            String word=name_array[i];
            char[] wordarray=word.toCharArray();
            for(int j= wordarray.length-1;j>=0;j--){
                reverse+=word.charAt(j);
            }
           reverse=reverse+" ";
        }
        System.out.print(reverse);
    }

    public void student_result(String std,int a,int b, int c,int d,int e){
        System.out.println("the std of student is "+std);
        System.out.println("the result of student is "+percentage(a,b,c,d,e));

    }
    public float percentage(int x, int y, int z,int l,int m){
        float addition=x+y+z+l+m;
        float result=(addition/500)*100;
        return result;

    }

    public void launchapplication(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JOHN\\Desktop\\jars\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opentab")));
    }
    public void radiobutton(){
        driver.findElement(By.id("bmwradio")).click();
        driver.findElement(By.name("enter-name")).sendKeys("rahul");
        driver.findElement(By.xpath("//a[normalize-space()='ALL COURSES']")).click();
        driver.findElement(By.linkText("ALL COURSES")).click();
        driver.findElement(By.xpath("//a[@id='opentab']")).click();

    }
    public void web_table(){
        //System.out.println("the table value is "+driver.findElement(By.xpath("//table[@id='product']/tbody/tr[4]/td[2]")).getText());
       try{
        for(int i=2;i<=4;i++){
            for(int j=1;j<=3;j++){
                System.out.print(driver.findElement(By.xpath("//table[@id='product']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
            }
            System.out.println();
        }
    }catch(Exception e){
           e.printStackTrace();
           closebrowser();
       }
    }
    public void dropdown() throws InterruptedException {
        Select car=new Select(driver.findElement(By.id("carselect")));
        car.selectByIndex(2);
        Thread.sleep(5000);
        car.selectByVisibleText("BMW");
        Thread.sleep(5000);
    }
    public void windowhandle() throws InterruptedException {
        System.out.println("the parent url is "+driver.getCurrentUrl());
        String parentwindow=driver.getWindowHandle();
        System.out.println("the id of parent window is "+parentwindow);
        driver.findElement(By.id("openwindow")).click();
        Thread.sleep(5000);
        Set<String> windowsid= driver.getWindowHandles();
        System.out.println("the id are "+windowsid);
        for(String win:windowsid){
            if(!parentwindow.equalsIgnoreCase(win))
                driver.switchTo().window(win);

        }
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.linkText("SUPPORT")).click();
        Thread.sleep(5000);

        driver.switchTo().window(parentwindow);
        Thread.sleep(5000);
    }
    public void frame() throws InterruptedException {
        driver.switchTo().frame("courses-iframe");
        Select category= new Select(driver.findElement(By.name("categories")));
        category.selectByValue("1604");
        Thread.sleep(5000);

    }
    public void alert() throws InterruptedException {
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
    }
    public void mousehover() throws InterruptedException {
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='mousehover']")));
        driver.findElement(By.linkText("Reload")).click();
        Thread.sleep(5000);

    }
    public void list(){
        List a1=new ArrayList();
        a1.add("Ram");
        a1.add("sham");
        a1.add(12);
        a1.add(13);
        a1.add("g11");
        a1.add("Ram");
        System.out.println("check for g11"+a1.contains("g11"));
        System.out.println("check for asdf"+a1.contains("asdf"));
        System.out.println("the original arraylist is "+a1);
        a1.remove("sham");
        a1.remove(3);
        System.out.println("the remove elements"+a1);
    }
    public void set(){
        Set s1=new HashSet();
        s1.add("ram");
        s1.add("sham");
        s1.add("sham");
        s1.add(112);
        s1.add("as12");
        System.out.println("the original set is "+s1);

    }
    public void map(){
        //Map z1= new HashMap();
        Map<Integer,String> z1=new HashMap<>();
        z1.put(101,"1");
        z1.put(105,"rahul");
        z1.put(102,"amit");
        z1.put(106,"1000");
        z1.put(107,"amol");
        z1.put(108,"5000");
        z1.put(109,"amol");
        System.out.println("the original map is "+ z1);
        z1.remove(106);
        System.out.println("check map is empty or not "+z1.isEmpty());
        System.out.println("the size of map is "+z1.size());
    }

    public void closebrowser(){

        driver.quit();
    }




}
