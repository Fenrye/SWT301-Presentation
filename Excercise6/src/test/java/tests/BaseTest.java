package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Cấu hình ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // mở full màn hình
        // options.addArguments("--headless"); // nếu muốn chạy ẩn (không hiển thị browser)

        driver = new ChromeDriver(options);

        // Timeout mặc định
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() {
        // Đóng browser sau khi test xong
        if (driver != null) {
            driver.quit();
        }
    }
}
