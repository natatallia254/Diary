import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

class DiaryTestCase {

    private WebDriver driver;
    private Diary diary;

    @BeforeClass
    public void beforeDiaryTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://diary.ru/user/registration");
        diary = new Diary(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //неявное ожидание
    }

    @Test
    public void DiaryTest(){
        diary.enterUserAndEmail("natallia7539724","natallia7539724@yandex.ru");
        diary.checkCheckBox();
        diary.clickButton();
        Assert.assertTrue(diary.avatarVisible());
    }

    @AfterClass
    public void afterDiaryTest(){
        driver.quit();
    }
}