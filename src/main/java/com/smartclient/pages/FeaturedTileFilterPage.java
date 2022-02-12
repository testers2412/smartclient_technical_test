package com.smartclient.pages;

import com.smartclient.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

import static com.smartclient.drivermanager.ManageDriver.driver;

public class FeaturedTileFilterPage extends Utility {
    private static final Logger log = LogManager.getLogger(FeaturedTileFilterPage.class.getName());

    public FeaturedTileFilterPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//input[@id='isc_EM']")
    WebElement animalTab;
    @CacheLookup
    @FindBy(xpath = "//div[@id='isc_EJ']")
    WebElement maxLifeSlider;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[1]/span[1]")
    WebElement sortByPicker;
    @CacheLookup
    @FindBy(xpath = "//div[@class='labelAnchor']")
    WebElement ascendingCheckBox;
    @CacheLookup
    @FindBy(xpath = "//tr[@role='option']/td/div")
   List<WebElement> sortByOptions;

    public void setAnimal(String letter){
        animalTab.sendKeys(letter);
        log.info("Set Animal by sending letter : "+letter);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void moveMaxLifeSpanSlider(int x, int y){
        Actions moveSlider = new Actions(driver);
        moveSlider.dragAndDropBy(maxLifeSlider,x,y).build().perform();
        log.info("Move max life span slider to: 40");
    }
    public void sortOrder(String sortBy){
       //sortByPicker.click();

       for (WebElement option:sortByOptions){
            if(option.getText().equalsIgnoreCase(sortBy)){
                option.click();
                break;
            }
           log.info("Sort by : "+ sortBy);
        }
    }
    public void clickOnAscending(){
        ascendingCheckBox.click();
        log.info("Click on Ascending :"+ ascendingCheckBox.toString());
    }
    public void assertResult(){

    }



}
