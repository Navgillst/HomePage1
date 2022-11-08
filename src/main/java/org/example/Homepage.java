package org.example;
//Importing org.openqa.selenium.support.ui.Select package to use select method
import org.openqa.selenium.support.ui.Select;
//importing org.openqa.selenium package to use method By
import org.openqa.selenium.By;
//Importing org.openqa.selenium.WebDriver package for WebDriver
import org.openqa.selenium.WebDriver;
//importing org.openqa.selenium.chrome.ChromeDriver package for ChromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
//importing org.testng.annotations.AfterMethod package for AfterMethod
import org.testng.annotations.AfterMethod;
//importing org.testng.annotations.BeforeMethod package for BeforeMethod
import org.testng.annotations.BeforeMethod;
//importing org.testng.annotations.Test package for Test
import org.testng.annotations.Test;
//importing java.text.SimpleDateFormat package for current time
import java.text.SimpleDateFormat;

public class


Homepage
{
  //imported selenium WebDriver interface using Maven dependency to perform automation task
  protected static WebDriver driver;

  // To execute openBrowser method before the execution of any other method
  @BeforeMethod
  public void openBrowser()
  {
    //set driver path for Chrome browser
    System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
    //opening Chrome browser
    driver = new ChromeDriver();
    //Keeping the browser in full screen mode
    driver.manage().window().maximize();
    //Navigating to demo.nopcommerce.com website with get() method through the object driver
    driver.get("https://demo.nopcommerce.com/");
  }

  public String addTime()
  {
    //storing current year month  date hour minute and seconds in variable timeStamp
    return  new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

  }
  public void clickOnElement(By by)

  {
    //To 'findElement' with object(driver) of its class and to perform click action
    driver.findElement(by).click();
  }

  public void enterText(By by,String text)
  {
    //To 'findElement' with object(driver) of its class and to perform senKeys action to enter text
    driver.findElement(by).sendKeys(text);
  }

  public String getTextFromElement(By by)
  {

    //To 'findElement' with object(driver) of its class and to perform getText action to get the string value
    return driver.findElement(by).getText();

  }

@Test
  public void basePage()
{

  //clicking on the button register with the user defined method clickOnElement
  clickOnElement(By.className("ico-register"));

  //Clicking on the female radio button by id with the user defined method clickOnElement
  clickOnElement(By.id("gender-female"));

  //Navigates to 'First name' field with its locator by id with the user defined method 'enterText' and adding first name
  enterText(By.id("FirstName"),"Navpreet");

  //Navigates to 'Last name' field with its locator by id with the user defined method 'enterText' and adding Last name
  enterText(By.id("LastName"),"Gill");

 //Using select class with its object to select the day with its locator using findElement function
  Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
  // To select day 5 use selectByIndex function
  selectDay.selectByIndex(5);

  //Using select class with its object to select the month with its locator using findElement function
  Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
  // To select Month 3 use selectByValue function
  selectMonth.selectByValue("3");

  //Using select class with its object to select the year with its locator using findElement function
  Select selectYear = new Select(driver.findElement(By.name("DateOfBirthMonth")));
  // To select year 9 use selectByIndex function
  selectYear.selectByIndex(9);

  //Entering the name of company with the user defined method 'enterText'
  enterText(By.id("Company"),"ABC Enterprise");

  //Navigates to 'Email' field with its locator by id using user defined method 'enterText'  and adding 'addTime' method to make  email address unique everytime
  enterText(By.id("Email"),"navgillst"+addTime()+"@gmail.com");

  //Navigates to 'Password' field with its locator by id using user defined method 'enterText' and adding Password
  enterText(By.id("Password"),"Test12345");

  //Navigates to 'Confirm password' field with its locator by id using user defined method 'enterText' and adding same password again
  enterText(By.id("ConfirmPassword"),"Test12345");

  //Clicking on check box to un-tick newsletter
  clickOnElement(By.xpath("//input[@type=\"checkbox\"]"));

  //Navigates to 'register' button with its locator by id using user defined method 'clickOnElement' and clicking on it
  clickOnElement(By.id("register-button"));

  //putting the text value of the string in variable regMsg with its locator by using method getTextFromElement();
  String regMsg = getTextFromElement(By.className("result"));

  //printing the string value
  System.out.println(regMsg);

}
@Test
public void emailAFriend()
{
  //Navigates to the 'picture of Apple Macbook' page with its locator by xpath using user defined method 'clickOnElement' and performing click action
  clickOnElement(By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]"));

  //Navigates to the 'email a friend' page with its locator by class name using user defined method 'clickOnElement' and performing click action
  clickOnElement(By.className("email-a-friend"));

  //Navigates to 'friend email' field with its locator by id using user defined method 'enterText' and adding friends email id
  enterText(By.id("FriendEmail"),"abc@gmail.com");

  //Navigates to 'your email address' field with its locator by id using user defined method 'enterText' and adding my email id
  enterText(By.id("YourEmailAddress"),"navgillst@gmail.com");

  //Navigates to 'personal message' field with its locator by id using user defined method 'enterText' and adding message
  enterText(By.id("PersonalMessage"),"Hi, Check this out . It is really a good product");

  //Navigates to the send mail with its locator by classname clicking on the button 'send mail'
  clickOnElement(By.className("buttons"));

  //putting the text value of the string in variable text with its locator by using user defined method getTextFromElement();
  String text = getTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]//li"));
  //printing the value of variable text (Error Message)
  System.out.println(text);
}
@Test
public void homePageCategories()
{
  //putting the text value of the string in variable category1 with its locator by using user defined method getTextFromElement();
  String category1 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]\n"));
  //putting the text value of the string in variable category2 with its locator by using user defined method getTextFromElement();
  String category2 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/electronics\"]\n"));
  //putting the text value of the string in variable category3 with its locator by using user defined method getTextFromElement();
  String category3 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/apparel\"]\n"));
  //putting the text value of the string in variable category4 with its locator by using user defined method getTextFromElement();
  String category4 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/digital-downloads\"]\n"));
  //putting the text value of the string in variable category5 with its locator by using user defined method getTextFromElement();
  String category5 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/books\"]\n"));
  //putting the text value of the string in variable category6 with its locator by using user defined method getTextFromElement();
  String category6 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/jewelry\"]\n"));
  //putting the text value of the string in variable category7 with its locator by using user defined method getTextFromElement();
  String category7 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/gift-cards\"]\n"));

  //printing the value of variable category1
  System.out.println(category1);
  //printing the value of variable category2
  System.out.println(category2);
  //printing the value of variable category3
  System.out.println(category3);
  //printing the value of variable category4
  System.out.println(category4);
  //printing the value of variable category5
  System.out.println(category5);
  //printing the value of variable category6
  System.out.println(category6);
  //printing the value of variable category7
  System.out.println(category7);

}

@Test
public void newsComment()
{
  //Navigates to the 'DETAILS' button with its locator by xpath using user defined method 'clickOnElement' and performing click action
  clickOnElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a"));

  //Navigates to 'Title' field with its locator by id using user defined method 'enterText' and adding Title
  enterText(By.id("AddNewComment_CommentTitle"),"Computer Review");

  //Navigates to 'Comment' field with its locator by id using user defined method 'enterText' and adding Comment
  enterText(By.id("AddNewComment_CommentText"),"It is working really well");

  //Navigates to the 'NEW COMMENT' button with its locator by xpath using user defined method 'clickOnElement'  and performing click action
  clickOnElement(By.xpath("//button[@name=\"add-comment\"]"));

  //putting the text value of the string in variable commentMsg with its locator by using user defined method getTextFromElement();
  String commentMsg = getTextFromElement(By.className("result"));

  //printing the value of the variable commentMsg
  System.out.println(commentMsg);

}
@Test
public void products()
{
  //Navigates to the 'computers' category with its locator by xpath and performing click(); action
  clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]\n"));

  //Navigates to the 'Desktops' category with its locator by xpath and performing click(); action
  clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"));

  //putting the text value of the string in variable text1 with its locator by using method getText();
  String text1 = getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/build-your-own-computer\"]"));

  //putting the text value of the string in variable text2 with its locator by using method getText();
  String text2 =getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));

  //putting the text value of the string in variable text3 with its locator by using method getText();
  String text3 =getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));

  //printing the value of variable text1
  System.out.println(text1);

  //printing the value of variable text2
  System.out.println(text2);

  //printing the value of variable text3
  System.out.println(text3);
}
  // To execute closeBrowser method after the execution of any other method
  @AfterMethod
  public void closeBrowser()
  {
    //driver.quit();

  }

}
