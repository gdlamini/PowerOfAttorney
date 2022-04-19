package CourtGranted;

import SpecialPOA.AddODJagacy;
import SpecialPOA.ExcelFunctions;
import SpecialPOA.ReportClass;
import com.jagacy.util.JagacyException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainCG {

    private static Object AddODJagacy;

    public static void main(String[] args) throws IOException, JagacyException {

        String userData;
        String username;
        String password;
        String result;
        String comment;
        String runStatus;
        String accountNo;
        String option1;
        String option;
        String CSA;
        String title;
        String initials;
        String DoB;
        String surname;
        String firstName;
        String gender;
        String language;
        String idType;
        String idNumber;
        String dateIssued;
        String nationality;
        String consent;
        String occ_status;
        String occ_code;
        String designation;
        String address;
        String suburb;
        String city;
        String postalCode;
        String countryRes;
        String email;
        String countryBirth;



        boolean userLoggedIn = false;
        SpecialPOA.AddODJagacy preApproved = null;
        ExcelFunctions excel;
        AddODJagacy = new AddODJagacy();

        int _username = 0;
        int _password = 0;
        int _RunStatus = 0;
        int _userData = 0;
        int _Results = 0;
        int _accountNo = 0;
        int _Comment = 0;
        int _idNumber = 0;
        int _idType = 0;
        int _Id_UserData = 0;
        int _option = 0;
        int _option1 = 0;
        int _CSA = 0;
        int _title = 0;
        int _initials = 0;
        int _DoB = 0;
        int _surname = 0;
        int _firstName = 0;
        int _gender = 0;
        int _language = 0;
        int _dateIssued = 0;
        int _nationality = 0;
        int _consent = 0;
        int _occ_status = 0;
        int _occ_code = 0;
        int _designation = 0;
        int _address = 0;
        int _suburb = 0;
        int _city = 0;
        int _postalCode = 0;
        int _countryRes = 0;
        int _email = 0;
        int _countryBirth = 0;
        //   int _OverDraftAmount = 0;

        ExtentReports extent =  null;
        ExtentTest test = null;
        // Screen sikuliScreen = new Screen(0);
        String capture= "";

        String filePath = System.getProperty("user.dir")+"\\Data_File\\GeneralPOA.xlsx";
        ReportClass.ReportDirectory();

        try {

            extent = new ExtentReports(ReportClass.fullReportPath, true);
            ExcelFunctions.input_document = new FileInputStream(String.valueOf(new File(filePath)));
            excel =  new ExcelFunctions();

            _username = excel.columnsNames.indexOf("Username");
            _password = excel.columnsNames.indexOf("Password");
            _RunStatus = excel.columnsNames.indexOf("Run_Status");
            _option = excel.columnsNames.indexOf("Option");
            _accountNo = excel.columnsNames.indexOf("Account_No");
            _option1 = excel.columnsNames.indexOf("Option_");
            _CSA = excel.columnsNames.indexOf("CSA");
            _title = excel.columnsNames.indexOf("title");
            _initials = excel.columnsNames.indexOf("Initials");
            _DoB = excel.columnsNames.indexOf("DoB");
            _surname = excel.columnsNames.indexOf("Surname");
            _firstName = excel.columnsNames.indexOf("FirstName");
            _gender = excel.columnsNames.indexOf("Gender");
            _language = excel.columnsNames.indexOf("Language");
            _idType = excel.columnsNames.indexOf("IDType");
            _countryBirth = excel.columnsNames.indexOf("CountryBirth");
            _dateIssued = excel.columnsNames.indexOf("DateIssued");
            _idNumber = excel.columnsNames.indexOf("IDNumber");
            _nationality = excel.columnsNames.indexOf("Nationality");
            _consent = excel.columnsNames.indexOf("Consent");
            _occ_status = excel.columnsNames.indexOf("Occ_Status");
            _occ_code = excel.columnsNames.indexOf("Occ_Code");
            _designation = excel.columnsNames.indexOf("Designation");
            _address = excel.columnsNames.indexOf("Address");
            _suburb = excel.columnsNames.indexOf("Suburb");
            _city = excel.columnsNames.indexOf("City");
            _postalCode = excel.columnsNames.indexOf("PostalCode");
            _countryRes = excel.columnsNames.indexOf("Country_Residence");
            _email = excel.columnsNames.indexOf("Email");
//            _Option = excel.columnsNames.indexOf("Option");




            int reply = JOptionPane.showConfirmDialog(null, "Do you want to Add Power of Attorney...", "Power of Attorney...", JOptionPane.YES_NO_OPTION);

            if(reply == JOptionPane.YES_OPTION) {

                //Looping through the Excel Sheet
                for(int y = 1; y < ExcelFunctions.ScenarioCount; y++)
                {

                    password = excel.ReadCell(y,_password);
                    username = excel.ReadCell(y,_username);
                    runStatus = excel.ReadCell(y,_RunStatus);
                    option = excel.ReadCell(y,_option);
                    accountNo = excel.ReadCell(y,_accountNo);
                    option1 = excel.ReadCell(y,_option1);
                    CSA = excel.ReadCell(y,_CSA);
                    title = excel.ReadCell(y,_title);
                    initials = excel.ReadCell(y,_initials);
                    DoB = excel.ReadCell(y,_DoB);
                    surname = excel.ReadCell(y,_surname);
                    gender = excel.ReadCell(y,_gender);
                    firstName = excel.ReadCell(y,_firstName);
                    language = excel.ReadCell(y,_language);
                    idType = excel.ReadCell(y,_idType);
                    idNumber = excel.ReadCell(y,_idNumber);
                    countryBirth = excel.ReadCell(y,_countryBirth);
                    dateIssued = excel.ReadCell(y,_dateIssued);
                    nationality = excel.ReadCell(y,_nationality);
                    consent = excel.ReadCell(y,_consent);
                    occ_status = excel.ReadCell(y,_occ_status);
                    occ_code = excel.ReadCell(y,_occ_code);
                    designation = excel.ReadCell(y,_designation);
                    address = excel.ReadCell(y,_address);
                    suburb = excel.ReadCell(y,_suburb);
                    city = excel.ReadCell(y,_city);
                    postalCode = excel.ReadCell(y,_postalCode);
                    countryRes = excel.ReadCell(y,_countryRes);
                    email = excel.ReadCell(y,_email);



                    if(runStatus.equalsIgnoreCase("RUN"))
                    {

                        System.setProperty("sessionA.window", "true");
                        preApproved  = new AddODJagacy();
                        preApproved.open();

                        ExcelFunctions.output_document = new FileOutputStream(String.valueOf(new File(filePath)));

                        //Login
                        userLoggedIn = preApproved.userLogin(username, password, option,accountNo, option1, CSA,firstName,email,gender,language,DoB,suburb,surname,initials,idNumber,idType,postalCode,consent,countryRes,city,suburb,address,designation,occ_status,occ_code,consent,nationality,countryBirth);

                        //
                        if(userLoggedIn){

                            test = extent.startTest("Add Power of Attorney:", "Test Case Scenarios");
                            test.assignAuthor("AUTHOR: Data Management Team");
                            test.assignCategory("Add Power of Attorney:");


                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Adding of Power of Attorney has been Cancelled...");
                System.exit(0);
            }

            extent.endTest(test);
            extent.flush();
            JOptionPane.showMessageDialog(null, "Add Power of Attorney Completed..");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
