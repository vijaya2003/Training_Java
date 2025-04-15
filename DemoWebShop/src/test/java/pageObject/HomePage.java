package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[@class='search-box']//input[@type='text']")
	private WebElement searchBoxEle;

	@FindBy(xpath = "//div[@class='search-box']//input[@type='submit']")
	private WebElement searchButtonEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Books')]")
	private WebElement booksEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Computers')]")
	private WebElement computerEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Electronics')]")
	private WebElement electronicsEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Apparel & Shoes')]")
	private WebElement apparelshoesEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Digital downloads')]")
	private WebElement digitalDownloadEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Jewelry')]")
	private WebElement jeweleryEle;

	@FindBy(xpath = "//div[@class='listbox']//a[contains(text(),'Gift Cards')]")
	private WebElement giftcardsEle;

	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-logout']")
	private WebElement logOutEle;

	@FindBy(xpath = "//div[@class='header-links']//li[3]//span[@class='cart-label']")
	private WebElement shoppingCartEle;

	@FindBy(xpath = "//div[@class='header-links']//li[4]//span[@class='cart-label']")
	private WebElement wishListEle;
	

	public void setSearchBoxEle(String searchBox) {
		if(searchBox.isEmpty()) {
			System.out.println("searching text is empty");
			return;
		}
		else {
				SeleniumHelpers.sendData(searchBoxEle, searchBox);
		}
	}

	public void setSearchButtonEle() {
		SeleniumHelpers.clickOn(searchButtonEle);
	}

	public void setBooksEle() {
		SeleniumHelpers.clickOn(booksEle);
	}

	public void setComputerEle() throws InterruptedException {
		SeleniumHelpers.clickOn(computerEle);
		Thread.sleep(2000);
		if(driver.getCurrentUrl()=="https://demowebshop.tricentis.com/computers") {
			System.out.println("Computers page is opened");
		}
		else {
			System.out.println("Computers page is not opend");
		}
	}

	public void setElectronicsEle() {
		SeleniumHelpers.clickOn(electronicsEle);
	}

	public void setApparelshoesEle() {
		SeleniumHelpers.clickOn(apparelshoesEle);
	}

	public void setDigitalDownloadEle() {
		SeleniumHelpers.clickOn(digitalDownloadEle);
	}

	public void setJeweleryEle() {
		SeleniumHelpers.clickOn(jeweleryEle);
	}

	public void setGiftcardsEle() {
		SeleniumHelpers.clickOn(giftcardsEle);
	}

	public void setLogOutEle() {
		SeleniumHelpers.clickOn(logOutEle);
	}

	public void setShoppingCartEle() {
		SeleniumHelpers.clickOn(shoppingCartEle);
	}

	public void setWishListEle() {
		SeleniumHelpers.clickOn(wishListEle);
	}

}
