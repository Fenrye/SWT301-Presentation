package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("vitidsarn", "123456");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard should be visible after login");
    }

    @Test
    public void loginFail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("vitidsarn", "Wrongpassword");
        loginPage.login("hung", "123456623");

        // Chờ error message hiển thị (giữ nguyên check element)
        Assert.assertTrue(loginPage.isErrorMessageVisible(), "Error message should be displayed for wrong password");
    }
}
