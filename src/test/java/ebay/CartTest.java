package ebay;

import org.coindesk.model.Base;
import org.coindesk.model.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


@Test(groups = {"ui"})
public class CartTest extends Base {

    public void addToCart(){
        Util util=new Util(driver);
        util.searchItem(1);
        util.switchTabs();
        util.addToCart();
    }

}

