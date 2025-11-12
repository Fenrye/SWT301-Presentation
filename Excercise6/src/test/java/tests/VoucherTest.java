package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.VoucherPage;
import utils.DriverManager;

public class VoucherTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private VoucherPage voucherPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.createDriver();
        loginPage = new LoginPage(driver);
        voucherPage = new VoucherPage(driver);

        // Login trước để test voucher
        loginPage.navigate();
        loginPage.login("vitidsarn", "123456");
    }

    @Test
    public void addVoucherTest() {
        voucherPage.navigate();
        voucherPage.addVoucher("VOUCHER90", 50, "2025-11-12", "2025-12-12");
        Assert.assertTrue(voucherPage.isVoucherPresent("VOUCHER90"), "Voucher should be added successfully");
    }


    @AfterClass
    public void tearDown() {
        if(driver != null) driver.quit();
    }
}
