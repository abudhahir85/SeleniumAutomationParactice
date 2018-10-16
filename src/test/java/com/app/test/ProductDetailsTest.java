package com.app.test;
	

	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import com.app.pages.BasePage;
	import com.app.pages.HomePageObject;
	import com.app.pages.ProductDetailsPageObject;

	public class ProductDetailsTest {
		ProductDetailsPageObject ProductPage;
		BasePage bp;
		HomePageObject hp;

		public ProductDetailsTest() {
			ProductPage = new ProductDetailsPageObject();
			bp = new BasePage();
			hp = new HomePageObject();
		}
		
		@BeforeMethod
		public void beforeMethod() {
			hp.clickDress();
		}

		@AfterClass
		public void afterClass() {
			bp.quitDriver();
		}
				
		
		@Test
		public void VerifySocialIconDisplay(){
			ProductPage.ClickfirstPrct();
			Assert.assertTrue(ProductPage.TweetDisplay().contains("twitter"));
			Assert.assertTrue(ProductPage.FacebookDisplay().contains("facebook"));
		}
		@Test
		public void VerifyProductDescription(){
		//	hp.clickDress();
			ProductPage.ClickfirstPrct();
			Assert.assertTrue(ProductPage.ProductDescription().contains("100% cotton double printed dress"));
		}
		
		@Test
		public void verifyAddToCartinAllProducts(){
			hp.clickDress();
			for (WebElement prod : ProductPage.getProductList()) {
			bp.HouseHowering(prod);
			Assert.assertTrue(bp.elementFound(ProductPage.verifyAddToCart(prod)),"Failed : Add To cart is not displayed");		
			}
		}
		
		@Test 
		public void DisplayAllProductName(){
			hp.clickDress();
			for (WebElement ProductName : ProductPage.getProductList()) {
			bp.getTxtAttribute(ProductPage.getAllProductDisplay(ProductName));
			}
		}
		
		
	}
	
		
		
