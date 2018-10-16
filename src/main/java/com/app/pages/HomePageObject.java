package com.app.pages;

	
	import java.util.ArrayList;
	import java.util.List;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;

	public class HomePageObject extends BasePage {

		@FindBy(xpath="//img [@class='logo img-responsive']")
		private WebElement logo;
		
		@FindBys(@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a"))
		private List<WebElement> ListItems;
		
		public List<String> ClickTabb() {
			List<String>list = new ArrayList<String>();
			for (WebElement element : ListItems) {
				list.add(element.getText());
			}
			return list;
		}
		
		@FindBy(xpath = "//a[@title='Women']")
		private WebElement HeaderWomen;

		@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
		private WebElement HeaderDresses;

		@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
		private WebElement HeaderTShirt;

		@FindBy(xpath = "//*[@id='newsletter-input']")
		private WebElement MsgSubscription; 
		
		
		@FindBy(xpath = "//*[@name='submitNewsletter']")
		private WebElement SubmitBtn;
		
		@FindBy(xpath ="//*[@id='columns']/p")
		private WebElement VerifySubscription;
		
		@FindBy(id="search_query_top")
		private WebElement Search;
		
		@FindBy(xpath = "//*[@name='submit_search']")
		private WebElement clkSearch;
		
		@FindBy(xpath = "//*[@class='icon-th-list']")
		private WebElement ListV;
		
		@FindBy(xpath="//*[@class='product-container']//*[@class='discount']")
		private WebElement Discount; 
		
		public String getMsgDisplay(){
			String output = VerifySubscription.getText();
			return output;
		}
		
		
		public WebElement clickDress(){
			HeaderDresses.click();
			return HeaderDresses;
		}
		public WebElement clickWomen(){
			HeaderWomen.click();
			return HeaderWomen;
		}
		
		public WebElement clickTshirt(){
			HeaderTShirt.click();
			return HeaderTShirt;
		}
		
		public void ClickSubmitBtn(){
			SubmitBtn.click();		
		}
		
		public HomePageObject() {
			PageFactory.initElements(driver, this);
		}

		public WebElement getHeaderwomen(){
			return HeaderWomen;
		}
		
		public WebElement getHeaderdresses() {
			return HeaderDresses;
		}
		
		public WebElement getHeaderTshirt(){
			return HeaderTShirt;
		}
		
		public void getmsg(String name){
			MsgSubscription.sendKeys(name);
		}
		
		public WebElement clicklogo(){
			logo.click();
			return clicklogo(); 
		}
		
		public void SearchProduct(String OptionsToBeTyped ){
			setText(Search, OptionsToBeTyped);
			clkSearch.click();
		}
		
		public void Listview(){
			ListV.click();
		}
		
		public String getDiscount(){
		return	Discount.getText();
		}
	
	}