package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DataGenerator;

public class EvaluationTypePage extends BasePage {

    public EvaluationTypePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Phân loại đánh giá')]")
    private WebElement EvaluationType_Button;

    @FindBy(xpath = "//span[normalize-space()='Thêm']")
    private WebElement Add_Button;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[4]/div/input")
    private WebElement Name_Input;

    @FindBy(xpath = "//textarea[@rows='2']")
    private WebElement Description_Input;

    @FindBy(xpath = "//span[contains(normalize-space(),'Lưu')]")
    private WebElement Save_Button;

    @FindBy(xpath = "//span[contains(normalize-space(),'Hủy')]")
    private WebElement Cancel_Button;

    @FindBy(xpath = "//div[@class='v-field v-field--active v-field--appended v-field--center-affix v-field--dirty v-field--prepended v-field--variant-outlined v-theme--lightColor7 v-locale--is-ltr']//i[@class='mdi-menu-down mdi v-icon notranslate v-theme--lightColor7 v-icon--size-default v-select__menu-icon']")
    private WebElement DropDownStatus_Button;

    @FindBy(xpath = "//div[1]/div[1]/div[3]/div[2]/div[1]")
    private WebElement LockStatus;

    @FindBy(xpath = "//form/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div[3]/textarea")
    private WebElement Description_Label;

    @FindBy(xpath = "//div[contains(text(),'Cập nhật thành công')]")
    private WebElement toastUpdateSuccess;

    @FindBy(xpath = "//div[contains(text(),'Xóa thành công')]")
    private WebElement toastDeleteSuccess;

    @FindBy(xpath = "//div[contains(text(),'Thêm thành công')]")
    private WebElement toastAddSuccess;

    @FindBy(xpath = "//tr[@id='row-0']//span[contains(text(),'Sửa')]")
    private WebElement Edit_Button;

    @FindBy(xpath = "//tr[@id='row-0']//span[contains(text(),'Xóa')]")
    private WebElement Delete_Button;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    private WebElement ConfirmDelete_Button;



    public boolean isEvaluationTypeDisplayed(String name) {
        try {
            String xpath = String.format("//tr[td[contains(text(),'%s')]]", name);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    public void clickConfirmDelete() {
        clickElement(ConfirmDelete_Button);
    }

    public void clickEdit() {
        clickElement(Edit_Button);
    }
    public void clickDelete() {
        clickElement(Delete_Button);
    }

    private void waitForToastVisible(WebElement toast) {
        wait.until(ExpectedConditions.visibilityOf(toast));
    }



    public String getToastMessageAdd() {
        waitForToastVisible(toastAddSuccess);
        String text = toastAddSuccess.getText();
        logger.info("Toast add message: " + text);
        return text;
    }

    public String getToastMessageUpdate() {
        waitForToastVisible(toastUpdateSuccess);
        return toastUpdateSuccess.getText();
    }

    public String getToastMessageDelete() {
        waitForToastVisible(toastDeleteSuccess);
        return toastDeleteSuccess.getText();
    }

    public void clickEvaluationType() {
        clickElement(EvaluationType_Button);
    }

    public void clickAdd() {
        clickElement(Add_Button);
    }

    public String setEvaluationTypeName(String prefix) {
        return setRandomValue(Name_Input, prefix);
    }

    public void clickDropDownStatus() {
        clickElement(DropDownStatus_Button);
    }

    public void clickLockStatus() {
        clickElement(LockStatus);
    }

    public void setDescription(String description) {
        Description_Label.click();
        setText(Description_Input, description, false);
    }

    public void clickSave() {
        clickElement(Save_Button);
    }
}
