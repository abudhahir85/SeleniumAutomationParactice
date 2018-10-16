package com.app.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {



	@FindBys(@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li"))
	private List<WebElement> SizeList;
	
	@FindBys(@FindBy(xpath="//*[@id='center_column']/ul/li"))
	private List<WebElement> listProducts;
	
	@FindBy(xpath ="//*[@class='heading-counter']" )
	private WebElement HeaderCount;
	
	@FindBy(xpath="//*[@id='add_to_cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//i[@class='icon-ok']")
	private WebElement SuccessfullyAdded;
	
	@FindBy(xpath= "//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	private WebElement clickFirstProduct;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	private WebElement DisplayIcon;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	private WebElement SelectDrop;
	
	@FindBys(@FindBy(xpath = "//*[@class='right-block']//* [@class='price product-price']"))
	private List<WebElement> ProductPrices;
	
	
	@FindBys(@FindBy(xpath= "//*[@class='left-block']//*[contains(@class,'replace-2x ')]"))
	private List<WebElement> ProductNameASC;
	
	@FindBy(xpath= "//*[@title='Close window']")
	private WebElement close;
	
	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public List<String> SizeListTabb() {
		List<String>list = new ArrayList<String>();
		for (WebElement element : SizeList) {
			list.add(element.getText().split(" ")[0]);
		}
		return list;
	}
	
	public int getTotalCount(){
		return listProducts.size();
	}
	
	public int getHeaderProductCount(){
		String number = HeaderCount.getText().split(" ")[2];
		return Integer.parseInt(number);
	}
	
	public WebElement displayIcon(){
		return DisplayIcon;
	}
	
	public void addcart(){
		AddToCart.click();
	}
	
	public WebElement getSuccessfullyAdded(){
		return SuccessfullyAdded;
	}
	
	public void ClickfirstPrct(){
		clickFirstProduct.click();
	}
		
	public List<WebElement> getProductList(){
		return listProducts;
	}
	
	
	@FindBy(xpath= "//*[@id='layered_ajax_loader']")
	private WebElement LoadingIcon;
	
	public void SelectDropDown(String OptionToBeSelected ){
		selectFromDropDown(SelectDrop,OptionToBeSelected);
		isElementVisible(LoadingIcon);
		isElementInVisisble(LoadingIcon);
	}
	
	public List<Double> getProductPrices(){
		List<Double> list=new ArrayList<Double>();
		for (WebElement element : ProductPrices) {
			list.add(Double.parseDouble(element.getText().replace("$", "")));
/*			String text=element.getText().replace("$", "");
			Double price = Double.parseDouble(text);
			list.add(price);*/
		//	System.out.println(list);
		}
			return list;
		}
	public List<String> getAllProductName(){
		List<String> namelist =new ArrayList<String>();
		for (WebElement element : ProductNameASC) {
			String text=element.getAttribute("title");
			namelist.add(text);
			//System.out.println(namelist);
		}
		return namelist;
	}
	
	
	public void closewindow(){
		close.click();
	}
}