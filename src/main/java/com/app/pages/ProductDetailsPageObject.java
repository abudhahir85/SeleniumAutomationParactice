package com.app.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageObject extends BasePage {


	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> listProducts;

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement HeaderCount;

	public int getTotalCount() {
		return listProducts.size();
	}

	public int getHeaderProductCount() {
		String number = HeaderCount.getText().split(" ")[2];
		return Integer.parseInt(number);
	}

	@FindBy(xpath = "//*[@id='add_to_cart']")
	private WebElement AddToCart;

	@FindBy(xpath = "//i[@class='icon-ok']")
	private WebElement SuccessfullyAdded;

	@FindBy(xpath = "//ul/li[1]//a[contains(text(),'Printed Dress')]")
	private WebElement clickFirstProduct;

	@FindBy(xpath = "//*[@class='btn btn-default btn-twitter']")
	private WebElement SocialIconTW;
	
	@FindBy(xpath = "//*[contains(@class,'btn btn-default btn-facebook')]")
	private WebElement SocialIconFB;

	@FindBy(xpath = "//*[@id='short_description_content']/p")
	private WebElement ProductDes;
	


	public String TweetDisplay() {
		String tweet= SocialIconTW.getAttribute("onclick");
		return tweet;
	}
	
	public String FacebookDisplay() {
		String share= SocialIconFB.getAttribute("onclick");
		return share;
	}
		

	public ProductDetailsPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void addcart() {
		AddToCart.click();
	}

	public WebElement getSuccessfullyAdded() {
		return SuccessfullyAdded;
	}

	public void ClickfirstPrct() {
		clickFirstProduct.click();
	}

	public String ProductDescription() {
		String output = ProductDes.getText();
		return output;
	}

	public List<WebElement> getProductList() {
		return listProducts;

	}
	public WebElement getAllProductDisplay(WebElement parent){
		return parent.findElement(By.xpath(".//*[@class='product_img_link']"));
	}
	
	public WebElement verifyAddToCart(WebElement parent) {
		return parent.findElement(By.xpath(".//img[contains(@class,'replace')]"));
	}


	}