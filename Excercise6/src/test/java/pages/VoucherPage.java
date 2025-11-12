package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;


public class VoucherPage {
    private WebDriver driver;
    private String url = "http://localhost:8080/owner/vouchers"; // URL trang voucher

    // Nút + Thêm voucher mới
    private By addNewVoucherBtn = By.cssSelector("a.inline-flex.items-center");


    // Form input
    private By voucherCodeInput = By.id("code");
    private By voucherDiscountInput = By.id("discount");
    private By createVoucherBtn = By.cssSelector("button.px-6.py-3.bg-gradient-to-r");

    public VoucherPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }

    public void openAddVoucherForm() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(addNewVoucherBtn));
        driver.findElement(addNewVoucherBtn).click();
    }

    public void addVoucher(String code, int discount, String startDate, String endDate) {
        openAddVoucherForm();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(voucherCodeInput));

        driver.findElement(voucherCodeInput).clear();
        driver.findElement(voucherCodeInput).sendKeys(code);

        driver.findElement(voucherDiscountInput).clear();
        driver.findElement(voucherDiscountInput).sendKeys(String.valueOf(discount));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('startDate').value = arguments[0];", startDate);
        js.executeScript("document.getElementById('endDate').value = arguments[0];", endDate);

        driver.findElement(createVoucherBtn).click();
    }




    public boolean isVoucherPresent(String code) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[text()='" + code + "']")));
        return driver.findElements(By.xpath("//td[text()='" + code + "']")).size() > 0;
    }
}
