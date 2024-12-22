package ebay;

import org.coindesk.model.Base;
import org.coindesk.model.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@Test(groups = {"ui"})
public class CartTest extends Base{

    public void Cart(){
        util.searchItem(1);
        util.switchTabs();
        util.addToCart();
    }

}

