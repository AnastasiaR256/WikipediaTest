import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTest extends CoreTestCase {
    public MainPageObject MainPageObject;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }
    @Test
    public void testAdding() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Хоббит, или Туда и обратно");
        SearchPageObject.waitForSearchResult("повесть английского писателя Джона Р. Р. Толкина");
        SearchPageObject.initSaving();
        SearchPageObject.initSnackbarAction();
        SearchPageObject.typeListNameLine("Хоббит");
        SearchPageObject.initOKBtn();
        SearchPageObject.initSnackbarAction();
        SearchPageObject.initBtnView();
        SearchPageObject.initOverflowMenu();
        SearchPageObject.initMoreAction("Удалить список");
        SearchPageObject.initOKBtn();
    }
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
