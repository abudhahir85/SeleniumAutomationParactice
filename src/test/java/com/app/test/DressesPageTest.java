package com.app.test;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.pages.BasePage;
import com.app.pages.DressesPageObject;
import com.app.pages.HomePageObject;

	public class DressesPageTest {
		DressesPageObject DressesPage;
		BasePage bp;
		HomePageObject hp;
		public DressesPageTest() {
			DressesPage = new DressesPageObject();
			bp = new BasePage();
			hp = new HomePageObject();

		}
		
		@BeforeMethod
		public void beforeMethod() {
			hp.clickDress();
		}

	/*	@AfterClass
		public void afterClass() {
			hp.clicklogo();
		}*/
		
		@AfterTest
		public void afterMethod(){
			bp.quitDriver();
		}
		
		@Test
		public void VerifyDisplaySize(){
		//	hp.clickDress();
			List<String>expectedValues = new ArrayList<String>();
			expectedValues.addAll(Arrays.asList("S",  "M", "L"));
			Assert.assertEquals(DressesPage.SizeListTabb(), expectedValues);
		}
		@Test
		public void VerifyCount(){
		//	hp.clickDress();
			Assert.assertEquals(DressesPage.getHeaderProductCount(), DressesPage.getTotalCount(), "Failed: Counting MisMatch");
		}
		@Test 
		public void VerifyFirstProductAdded(){
		//	hp.clickDress();
			DressesPage.ClickfirstPrct();
			DressesPage.addcart();
			bp.isElementVisible(DressesPage.displayIcon());
			Assert.assertTrue(bp.elementFound(DressesPage.getSuccessfullyAdded()));
			DressesPage.closewindow();
		}
	
		@Test(enabled =false)
		public void VerifyShortByLowestFirst(){
		//	hp.clickDress();
			DressesPage.SelectDropDown("price:asc");
			List<Double> productprice = DressesPage.getProductPrices();
			System.out.println(productprice);
			for(int i=0; i<DressesPage.getProductPrices().size()-1; i++){
			Assert.assertTrue(productprice.get(i) < productprice.get(i+1), "Failed : Its Not Ascending Order");
			}
		}
		
		@Test (enabled = false)
		public void VerifyShortbyAtoZ(){
		//	hp.clickDress();
			DressesPage.SelectDropDown("name:asc");
			List<String> productnamelist=DressesPage.getAllProductName();
			System.out.println(productnamelist);
			for(int i=0; i<DressesPage.getAllProductName().size()-1; i++){
			Assert.assertTrue(!(productnamelist.get(i).compareTo(productnamelist.get(i+1))>0),"Failed : Products Not in Ascending Order");
			}
		}
		
		

	}
		
		
		
