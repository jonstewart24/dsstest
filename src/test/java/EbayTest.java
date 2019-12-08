import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.dss.pages.ebay.EbayHomePage;
import com.dss.pages.ebay.EbayProductPage;
import com.dss.pages.ebay.EbaySearchResultsPage;

public class EbayTest extends BaseTest {

	@Test
	public void testProductPrice() {
		EbayHomePage ebayHomePage = new EbayHomePage(driver);

		EbaySearchResultsPage resultsPage = ebayHomePage.searchForItem("Electric Guitar");
		EbayProductPage productPage = resultsPage.openResult(1);
		String price = productPage.getProductPrice();
		System.out.println("The product price is: " + price);
		assertNotNull(price);
	}
}