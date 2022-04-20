package com.medavante.testscripts;

import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.medavante.portal.datamodel.OrganizationModel;
import net.medavante.portal.dataproviders.DataProviders;
import net.medavante.portal.pages.MedAvantePortalPage;
import net.medavante.portal.pages.OrganizationPage;
import net.medavante.portal.selenium.core.BaseTest;
import net.medavante.portal.selenium.core.Configuration;

public class AddNewOrganization_SIP extends BaseTest {

    @Factory(dataProvider = "Browsers", dataProviderClass = DataProviders.class)
    public AddNewOrganization_SIP(String browser) {
        super(browser);
    }

    private OrganizationPage organizationPage;
    private MedAvantePortalPage medAvantePortalPage;
    private OrganizationModel org;

    @BeforeMethod
    public void getTestData() throws Exception {
        Properties properties = Configuration.readTestData("Organization");
        org = new OrganizationModel.AddOrganizationModelBuilder(properties.getProperty("name"), properties.getProperty(
                "abbreviation"), properties.getProperty("type")).setOrgSubType(properties.getProperty("subtype"))
                        .setorgComments(properties.getProperty("comments")).build();
        System.setProperty("className", getClass().getSimpleName());
    }

    @Test
    public void test_AddNewOrganization() throws Exception {
        reportLog("Login in to application");
        medAvantePortalPage = loginPage.loginInApplication("abcd", "efgh");
       
    }

}
