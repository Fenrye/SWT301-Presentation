package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private String dashboardUrl = "http://localhost:8080/owner";

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Kiểm tra dashboard hiển thị bằng URL
    public boolean isDashboardVisible() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe(dashboardUrl));
            return driver.getCurrentUrl().equals(dashboardUrl);
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToVoucherPage() {
        driver.get("http://localhost:8080/owner/voucher"); // URL voucher
    }
}
