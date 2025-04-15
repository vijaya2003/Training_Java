package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class ComputerPage {
	WebDriver driver;

	public ComputerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='item-box'])[1]//div[@class='sub-category-item']//h2")
	private WebElement desktopEle;

	@FindBy(xpath = "(//div[@class='sub-category-item'])[2]//h2")
	private WebElement noteBookEle;

	@FindBy(xpath = "(//div[@class='sub-category-item'])[3]//h2")
	private WebElement accessoriesEle;
	
	public void setDesktopEle() {
		SeleniumHelpers.clickOn(desktopEle);
	}

	public void setNoteBookEle() {
		SeleniumHelpers.clickOn(noteBookEle);
	}

	public void setAccessoriesEle() {
		SeleniumHelpers.clickOn(accessoriesEle);
	}
}
