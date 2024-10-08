package pages;

import manager.dto.StudentDTO;
import manager.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AutomationPracticeForm extends BasePage{

    public AutomationPracticeForm (WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(id = "firstName")
    WebElement nameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement emailField;



    public AutomationPracticeForm fillStudentsForm(StudentDTO student){

        nameField.sendKeys(student.getName());
        lastNameField.sendKeys(student.getLastName());
        emailField.sendKeys(student.getEmail());
        clickGender(student.getGender());

        return this;
    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }
}
