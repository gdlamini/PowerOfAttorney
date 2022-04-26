package SpecialPOA;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;

public class AddODJagacy extends Session3270 {

    private int userIdRow;
    private int userIdColumn;
    private String message = null;

    public AddODJagacy() throws JagacyException {
        super("sessionA", "host3270.absa.co.za", 993, "IBM-3279-5-E", true);
    }


    public boolean userLogin(String username, String password) throws JagacyException, InterruptedException {
        waitForChange(10000);
        userIdRow = 22;
        userIdColumn = 26;
        this.writePosition(userIdRow, userIdColumn, "IMSV");
        this.writeKey(Key.ENTER);

        this.waitForChange(10000);
        userIdRow = 14;
        userIdColumn = 10;
        this.writePosition(userIdRow, userIdColumn, username);

        userIdRow = 16;
        userIdColumn = 11;
        this.writePosition(userIdRow, userIdColumn, password);
        this.writeKey(Key.ENTER);
        this.waitForChange(30000);

        userIdRow = 23;
        userIdColumn = 22;
        message = this.readPosition(userIdRow, userIdColumn, 40).trim();

        if (message.equalsIgnoreCase("INCORRECT OR NO PASSWORD ENTERED.") || message.equalsIgnoreCase("USERID IS NOT DEFINED TO RACF.") || message.equalsIgnoreCase("Your USERID is already logged on.")) {
            return false;
        } else {

            return true;
        }

    }

    public String specialPOA(String optionNew, String accountNo, String authOption, String CSA, String title, String initials, String DoB, String surname, String gender, String firstName, String language, String idType, String idNumber, String dateIssued, String countryBirth, String nationality, String consent, String occ_Status, String occ_Code, String designation, String address, String suburb, String city, String postalCode, String countryRes, String email) throws JagacyException, InterruptedException {

        userIdRow = 2;
        userIdColumn = 2;
        this.writePosition(userIdRow, userIdColumn, "/test mfs");
        this.writeKey(Key.ENTER);
        waitForChange(50000);


        this.writePosition(userIdRow, userIdColumn, "auth");
        this.writeKey(Key.ENTER);
        Thread.sleep(5000);
        waitForChange(10000);

        userIdRow = 4;
        userIdColumn = 53;
        this.writePosition(userIdRow, userIdColumn, optionNew); //
        Thread.sleep(5000);
        userIdRow = 7;
        userIdColumn = 17;
        this.writePosition(userIdRow, userIdColumn, accountNo);

        userIdRow = 10;
        userIdColumn = 37;
        this.writePosition(userIdRow, userIdColumn, authOption);
        this.writeKey(Key.ENTER);
        waitForChange(10000);

        userIdRow = 3;
        userIdColumn = 15;
        this.writePosition(userIdRow, userIdColumn, CSA);

        userIdRow = 4;
        userIdColumn = 16;
        this.writePosition(userIdRow, userIdColumn, title);

        userIdRow = 4;
        userIdColumn = 33;
        this.writePosition(userIdRow, userIdColumn, initials);

        userIdRow = 4;
        userIdColumn = 63;
        this.writePosition(userIdRow, userIdColumn, DoB);

        userIdRow = 5;
        userIdColumn = 16;
        this.writePosition(userIdRow, userIdColumn, surname);

        userIdRow = 5;
        userIdColumn = 57;
        this.writePosition(userIdRow, userIdColumn, gender);

        userIdRow = 6;
        userIdColumn = 16;
        this.writePosition(userIdRow, userIdColumn, firstName);

        userIdRow = 6;
        userIdColumn = 59;
        this.writePosition(userIdRow, userIdColumn, language);

        userIdRow = 7;
        userIdColumn = 16;
        this.writePosition(userIdRow, userIdColumn, idType);

        userIdRow = 7;
        userIdColumn = 33;
        this.writePosition(userIdRow, userIdColumn, idNumber);

        userIdRow = 7;
        userIdColumn = 62;
        this.writePosition(userIdRow, userIdColumn, dateIssued);

        userIdRow = 8;
        userIdColumn = 67;
        this.writePosition(userIdRow, userIdColumn, countryBirth);

        userIdRow = 9;
        userIdColumn = 16;
        this.writePosition(userIdRow, userIdColumn, nationality);

        userIdRow = 9;
        userIdColumn = 77;
        this.writePosition(userIdRow, userIdColumn, consent);

        userIdRow = 10;
        userIdColumn = 22;
        this.writePosition(userIdRow, userIdColumn, occ_Status);

        userIdRow = 11;
        userIdColumn = 22;
        this.writePosition(userIdRow, userIdColumn, occ_Code);

        userIdRow = 12;
        userIdColumn = 59;
        this.writePosition(userIdRow, userIdColumn, designation);

        userIdRow = 13;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, address);

        userIdRow = 14;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, "address2");

        userIdRow = 15;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, suburb);

        userIdRow = 16;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, city);

        userIdRow = 17;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, postalCode);

        userIdRow = 17;
        userIdColumn = 71;
        this.writePosition(userIdRow, userIdColumn, countryRes);

        userIdRow = 18;
        userIdColumn = 18;
        this.writePosition(userIdRow, userIdColumn, email);


        this.writeKey(Key.ENTER);
        waitForChange(30000);
       // System.out.println("Heading Message 3: ");
       // this.writeKey(Key.ENTER);
        userIdRow = 12;
        userIdColumn = 1;
        message = this.readPosition(userIdRow, userIdColumn, 65);
        System.out.println("Heading Message 3: " + message);
        this.writeKey(Key.CLEAR);
        return message;
//        waitForChange(50000);
//        userIdRow = 23;
//        userIdColumn = 22;
//        message = this.readPosition(userIdRow, userIdColumn, 40).trim();
//
////        if (message.equalsIgnoreCase("SPECIAL POWER OF ATTORNEY INFORMATION UPDATED SUCCESSFULLY")) {
////            return false;
////        } else {
////            this.writeKey(Key.ENTER);
////            return true;
////
////        }



    }

    public String generalPOA(String accountNo, String option, String option1, String CSA, String title, String initials, String idType, String idNumber, String postalCode, String email, String countryRes, String dateIssued, String gender, String language, String surname, String DoB, String firstName, String city, String suburb, String address, String designation, String occ_Status, String occ_Code, String consent, String nationality, String countryBirth) throws JagacyException {


            userIdRow = 2;
            userIdColumn = 2;
            this.writePosition(userIdRow, userIdColumn, "/test mfs");
            this.writeKey(Key.ENTER);
            waitForChange(50000);

            this.writePosition(userIdRow, userIdColumn, "auth");
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 4;
            userIdColumn = 53;
            this.writePosition(userIdRow, userIdColumn, option);

            userIdRow = 7;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, accountNo);

            userIdRow = 10;
            userIdColumn = 37;
            this.writePosition(userIdRow, userIdColumn, option1);
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 3;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, CSA);

            userIdRow = 4;
            userIdColumn = 16;
            this.writePosition(userIdRow, userIdColumn, title);

            userIdRow = 4;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, initials);

            userIdRow = 4;
            userIdColumn = 63;
            this.writePosition(userIdRow, userIdColumn, DoB);

            userIdRow = 5;
            userIdColumn = 16;
            this.writePosition(userIdRow, userIdColumn, surname);

            userIdRow = 5;
            userIdColumn = 57;
            this.writePosition(userIdRow, userIdColumn, gender);

            userIdRow = 6;
            userIdColumn = 16;
            this.writePosition(userIdRow, userIdColumn, firstName);

            userIdRow = 6;
            userIdColumn = 59;
            this.writePosition(userIdRow, userIdColumn, language);

            userIdRow = 7;
            userIdColumn = 37;
            this.writePosition(userIdRow, userIdColumn, idType);

            userIdRow = 7;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, idNumber);

            userIdRow = 7;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, dateIssued);

            userIdRow = 8;
            userIdColumn = 67;
            this.writePosition(userIdRow, userIdColumn, countryBirth);

            userIdRow = 9;
            userIdColumn = 16;
            this.writePosition(userIdRow, userIdColumn, nationality);

            userIdRow = 10;
            userIdColumn = 22;
            this.writePosition(userIdRow, userIdColumn, consent);

            userIdRow = 11;
            userIdColumn = 22;
            this.writePosition(userIdRow, userIdColumn, occ_Status);

            userIdRow = 12;
            userIdColumn = 59;
            this.writePosition(userIdRow, userIdColumn, occ_Code);

            userIdRow = 13;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, designation);

            userIdRow = 14;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, address);

            userIdRow = 15;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, "address2");

            userIdRow = 16;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, suburb);

            userIdRow = 16;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, city);

            userIdRow = 17;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, postalCode);

            userIdRow = 17;
            userIdColumn = 71;
            this.writePosition(userIdRow, userIdColumn, countryRes);

            userIdRow = 18;
            userIdColumn = 18;
            this.writePosition(userIdRow, userIdColumn, email);
            this.writeKey(Key.ENTER);
            waitForChange(50000);
            this.writeKey(Key.ENTER);

            return message;


    }


    public String signingInstruction(String option, String accountNo, String option1, String signature, String CSA, String title, String initials, String DoB, String surname, String gender, String firstName, String language, String idType, String idNumber, String dateIssued, String nationality, String countryBirth, String consent, String designation, String occ_status, String occ_code, String address, String address1, String suburb, String city, String postalCode, String countryRes, String email, String sign) throws JagacyException {


            userIdRow = 2;
            userIdColumn = 2;
            this.writePosition(userIdRow, userIdColumn, "/test mfs");
            this.writeKey(Key.ENTER);
            waitForChange(50000);

            this.writePosition(userIdRow, userIdColumn, "auth");
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 4;
            userIdColumn = 53;
            this.writePosition(userIdRow, userIdColumn, option);

            userIdRow = 7;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, accountNo);

            userIdRow = 10;
            userIdColumn = 37;
            this.writePosition(userIdRow, userIdColumn, option1);
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 2;
            userIdColumn = 59;
            this.writePosition(userIdRow, userIdColumn, signature);

            userIdRow = 3;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, CSA);

            userIdRow = 4;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, title);

            userIdRow = 4;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, initials);

            userIdRow = 4;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, DoB);

            userIdRow = 5;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, surname);

            userIdRow = 5;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, gender);

            userIdRow = 6;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, firstName);

            userIdRow = 6;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, language);

            userIdRow = 7;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, idType);

            userIdRow = 7;
            userIdColumn = 25;
            this.writePosition(userIdRow, userIdColumn, idNumber);

            userIdRow = 7;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, dateIssued);

            userIdRow = 8;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, nationality);

            userIdRow = 8;
            userIdColumn = 58;
            this.writePosition(userIdRow, userIdColumn, countryBirth);

            userIdRow = 10;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, consent);

            userIdRow = 10;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, designation);

            userIdRow = 11;
            userIdColumn = 23;
            this.writePosition(userIdRow, userIdColumn, occ_status);

            userIdRow = 12;
            userIdColumn = 23;
            this.writePosition(userIdRow, userIdColumn, occ_code);

            userIdRow = 14;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, address);

            userIdRow = 15;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, address1);

            userIdRow = 16;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, suburb);

            userIdRow = 17;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, city);

            userIdRow = 18;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, postalCode);

            userIdRow = 18;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, countryRes);

            userIdRow = 19;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, email);

            userIdRow = 21;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, sign);
            this.writeKey(Key.ENTER);

            return message;



    }

    public String courtGranted(String option, String accountNo, String option1, String authority, String signature, String CSA, String title, String initials, String DoB, String surname, String gender, String firstNames, String language, String idType, String idNumber, String dateIssued, String nationality, String countryBirth, String consent, String occ_Status, String occ_Code, String designation, String address, String address1, String suburb, String city, String postalCode, String countryRes, String email, String sign) throws JagacyException {

            userIdRow = 2;
            userIdColumn = 2;
            this.writePosition(userIdRow, userIdColumn, "/test mfs");
            this.writeKey(Key.ENTER);
            waitForChange(50000);

            this.writePosition(userIdRow, userIdColumn, "auth");
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 4;
            userIdColumn = 53;
            this.writePosition(userIdRow, userIdColumn, option);

            userIdRow = 7;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, accountNo);

            userIdRow = 10;
            userIdColumn = 37;
            this.writePosition(userIdRow, userIdColumn, option1);
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 1;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, authority);

            userIdRow = 3;
            userIdColumn = 59;
            this.writePosition(userIdRow, userIdColumn, signature);

            userIdRow = 4;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, CSA);

            userIdRow = 5;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, title);

            userIdRow = 5;
            userIdColumn = 34;
            this.writePosition(userIdRow, userIdColumn, initials);

            userIdRow = 5;
            userIdColumn = 61;
            this.writePosition(userIdRow, userIdColumn, DoB);

            userIdRow = 6;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, surname);

            userIdRow = 6;
            userIdColumn = 52;
            this.writePosition(userIdRow, userIdColumn, gender);

            userIdRow = 7;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, firstNames);

            userIdRow = 7;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, language);

            userIdRow = 8;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, idType);

            userIdRow = 8;
            userIdColumn = 25;
            this.writePosition(userIdRow, userIdColumn, idNumber);

            userIdRow = 8;
            userIdColumn = 56;
            this.writePosition(userIdRow, userIdColumn, dateIssued);

            userIdRow = 9;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, nationality);

            userIdRow = 9;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, countryBirth);

            userIdRow = 10;
            userIdColumn = 70;
            this.writePosition(userIdRow, userIdColumn, consent);

            userIdRow = 14;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, address);

            userIdRow = 15;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, address1);

            userIdRow = 16;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, suburb);

            userIdRow = 17;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, city);

            userIdRow = 18;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, postalCode);

            userIdRow = 18;
            userIdColumn = 66;
            this.writePosition(userIdRow, userIdColumn, countryRes);

            userIdRow = 19;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, email);


            userIdRow = 21;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, sign);
            this.writeKey(Key.ENTER);
            this.waitForChange(30000);

            return message;

    }

    public String youthConsent(String option,String accountNo,String option1,String signature,String CSA,String title,String initials,String DoB,String surname,String gender,String firstName,String language,String idType,String idNumber,String dateIssued,String nationality,String countryBirth,String consent,String occ_status,String occ_code,String designation,String address,String address1,String suburb,String city,String postalCode,String countryRes,String email,String clientCode,String sign) throws JagacyException {


            userIdRow = 2;
            userIdColumn = 2;
            this.writePosition(userIdRow, userIdColumn, "/test mfs");
            this.writeKey(Key.ENTER);
            waitForChange(50000);

            this.writePosition(userIdRow, userIdColumn, "auth");
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 4;
            userIdColumn = 53;
            this.writePosition(userIdRow, userIdColumn, option);

            userIdRow = 7;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, accountNo);

            userIdRow = 10;
            userIdColumn = 37;
            this.writePosition(userIdRow, userIdColumn, option1);
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, signature);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, CSA);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, title);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, initials);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, DoB);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, surname);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, gender);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, firstName);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, language);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, idType);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, idNumber);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, dateIssued);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, nationality);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, countryBirth);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, consent);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, occ_status);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, occ_code);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, designation);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, address);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, address1);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, suburb);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, city);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, postalCode);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, countryRes);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, email);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, clientCode);

            userIdRow = 14;
            userIdColumn = 10;
            this.writePosition(userIdRow, userIdColumn, sign);
            return message;
        }
    }
}