package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {
    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            SEARCH_SKIP_BUTTON = "//*[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Поиск по Википедии')]",
            SEARCH_INPUT = "//*[contains(@text, 'Поиск')]",
            SEARCH_RESULT = "//*[@class='android.view.ViewGroup']//*[@text='{SUBSTRING}']",
            SEARCH_DESC = "//*[@resource-id='pcs-edit-section-title-description']",
            SEARCH_SAVING = "//*[@resource-id='org.wikipedia:id/page_save']",
            SEARCH_SNACKBAR = "//*[@resource-id='org.wikipedia:id/snackbar_action']",
            SEARCH_LISTNAME = "//*[@resource-id='org.wikipedia:id/text_input']",
            SEARCH_OK = "//*[@resource-id='android:id/button1']",
            SEARCH_BUTTONVIEW = "//*[@resource-id='org.wikipedia:id/buttonView']",
            SEARCH_OVERFLOW_MENU = "//*[@resource-id='org.wikipedia:id/item_overflow_menu']",
            SEARCH_MORE_ELEMENT = "//*[@resource-id='org.wikipedia:id/content']//*[@text='{SUBSTRING}']";

    public void initSkipButton() {
        this.waitForElementAndClick(By.xpath(SEARCH_SKIP_BUTTON),
                "Невозможно нажать на пропустить", 15);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
                "Невозможно нажать на поле ввода", 15);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),
                "Невозможно нажать на поле ввода", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,
                "Невозможно нажать на поле ввода", 15);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),
                "Невозможно найти: " + substring, 15);
        this.waitForElementAndClick(By.xpath(search_result_xpath),
                "Невозможно найти: " + substring, 15);
    }

    public void checkDescription(String expectation) {
        WebElement description_element = this.waitForElementPresent(By.xpath(SEARCH_DESC),
                "Невозможно найти описание", 15);
        String result = description_element.getText();
        Assert.assertEquals("Найдено несовпадение в описании статьи",
                expectation,
                result);
    }

    public void initSaving() {
        this.waitForElementAndClick(By.xpath(SEARCH_SAVING),
                "Невозможно нажать на сохранить", 15);
    }

    public void initSnackbarAction() {
        this.waitForElementAndClick(By.xpath(SEARCH_SNACKBAR),
                "Невозможно нажать на реакцию", 5);
    }

    public void typeListNameLine(String name_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_LISTNAME), name_line,
                "Невозможно нажать на поле ввода", 15);
    }

    public void initOKBtn() {
        this.waitForElementAndClick(By.xpath(SEARCH_OK),
                "Невозможно нажать на OK", 15);
    }

    public void initBtnView() {
        this.waitForElementAndClick(By.xpath(SEARCH_BUTTONVIEW),
                "Невозможно нажать на кнопку", 15);
    }

    public void initOverflowMenu() {
        this.waitForElementAndClick(By.xpath(SEARCH_OVERFLOW_MENU),
                "Невозможно нажать на больше", 15);
    }

    public void initMoreAction(String substring) {
        this.waitForElementAndClick(By.xpath(SEARCH_MORE_ELEMENT.replace("{SUBSTRING}", substring)),
                "Невозможно нажать на " + substring, 15);
    }

}
