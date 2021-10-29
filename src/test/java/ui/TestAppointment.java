package ui;

import Objects.Account;
import Objects.Appointment;
import Pages.*;
import Utils.Constants;
import data.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestAppointment extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    MakeAppointmentPage makeAppointmentPage;
    AppointmentConfirmationPage appointmentConfirmationPage;

    @BeforeClass
    public void preCondition() {
        homePage = new HomePage(driver);
        homePage.navigate(Constants.AUT_URL);
        homePage.clickMakeAppointment();

        loginPage = new LoginPage(driver);
        loginPage.login(Data.getAccount());

        makeAppointmentPage = new MakeAppointmentPage(driver);
        appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
    }

    @Test
    public void testMakeAppointment() {
        makeAppointmentPage.makeAppointment(Data.getAppointment());
        appointmentConfirmationPage.compareAppointment(appointmentConfirmationPage.getAppointmentInfo(), Data.getAppointment());
    }
}