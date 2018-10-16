package com.app.test;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Random;
	import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	import com.app.pages.BasePage;
	import com.app.pages.HomePageObject;

	public class HomePageTest {
		int value=new Random().nextInt(5000);
		String name=("abdhahir85@gmail.com"+value);
		HomePageObject homePage;
		BasePage bp;

		public HomePageTest() {
			homePage = new HomePageObject();
			bp = new BasePage();
		}
		

		/*@BeforeMethod
		public void BeforeMethod() {
			homePage.clicklogo();
		}*/
		
		@AfterTest
		public void afterMethod(){
			bp.quitDriver();
		}
		
		@Test
		public void VerifyHomePage(){
				List<String>expectedValues = new ArrayList<String>();
				expectedValues.addAll(Arrays.asList("WOMEN",  "DRESSES", "T-SHIRTS"));
				Assert.assertTrue(homePage.ClickTabb().containsAll(expectedValues));
			}
		@Test
		public void VerifyPageNavigation(){
			Assert.assertTrue(bp.elementFound(homePage.clickDress()));
			Assert.assertTrue(bp.elementFound(homePage.clickWomen()));
			Assert.assertTrue(bp.elementFound(homePage.clickTshirt()));
		}
		@Test
		public void VerifyMessageSubscriptionDisplay(){
			
			homePage.getmsg(name);
			homePage.ClickSubmitBtn();
			Assert.assertTrue(homePage.getMsgDisplay().contains("Newsletter"));
		}
		
		@Test
		public void VerifyProductsDiscount(){
			homePage.SearchProduct("printed");
			homePage.Listview();
			Assert.assertTrue(homePage.getDiscount().contains("Reduced price!"), "Discount Not Applicable for the Selected Product");
		}
		
	}
		
		
		
