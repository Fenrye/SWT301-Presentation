package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String url = "http://localhost:8080/login"; // chỉnh URL dự án

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginBtn = By.cssSelector("button.btn.btn-primary");
    private By errorMsg = By.id("loginError");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorMessageVisible() {
        return driver.findElements(errorMsg).size() > 0;
    }
}
