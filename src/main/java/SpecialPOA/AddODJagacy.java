package SpecialPOA;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;

public class AddODJagacy extends Session3270 {

    private int userIdRow;
    private int userIdColumn;
    private String message = null;

    public AddODJagacy() throws JagacyException
    {
        super("sessionA","host3270.absa.co.za",993,"IBM-3279-5-E",true);
    }




        public boolean userLogin(String username,String password, String accountNo, String option, String option1, String CSA,String title,String initials,String idType,String idNumber,String postalCode,String email,String countryRes, String dateIssued,String gender,String language,String surname, String DoB, String firstName,String city,String suburb,String address,String designation,String occ_Status,String occ_Code,String consent,String nationality,String countryBirth) throws JagacyException
    {
        waitForChange(10000);
        userIdRow = 22;
        userIdColumn = 26;
        this.writePosition(userIdRow, userIdColumn, "IMSV");
        this.writeKey(Key.ENTER);

        this.waitForChange(10000);
        userIdRow = 14;
        userIdColumn = 10;
        this.writePosition(userIdRow,userIdColumn,username);

        userIdRow = 16;
        userIdColumn = 11 ;
        this.writePosition(userIdRow, userIdColumn, password);
        this.writeKey(Key.ENTER);
        this.waitForChange(30000);

        userIdRow =  23;
        userIdColumn = 22;
        message = this.readPosition(userIdRow,userIdColumn,40).trim();

        if(message.equalsIgnoreCase("INCORRECT OR NO PASSWORD ENTERED.") || message.equalsIgnoreCase("USERID IS NOT DEFINED TO RACF.") || message.equalsIgnoreCase("Your USERID is already logged on.")) {
            return false;
        }else {

            userIdRow = 2;
            userIdColumn = 2;
            this.writePosition(userIdRow, userIdColumn, "/test mfs");
            this.writeKey(Key.ENTER);
            waitForChange(50000);

            this.writePosition(userIdRow, userIdColumn,"auth");
            this.writeKey(Key.ENTER);
            waitForChange(10000);

            userIdRow = 4;
            userIdColumn = 53;
            this.writePosition(userIdRow, userIdColumn,option);

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

            return true;

        }


    }


}
