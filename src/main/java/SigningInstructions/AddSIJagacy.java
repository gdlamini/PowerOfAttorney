package SigningInstructions;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;

public class AddSIJagacy extends Session3270 {

    private int userIdRow;
    private int userIdColumn;
    private String message = null;


    public AddSIJagacy(String s) throws JagacyException {
        super("sessionA", "host3270.absa.co.za", 993, "IBM-3279-5-E", true);
    }

    public boolean userLogin(String username, String password, String option, String accountNo, String option1) throws JagacyException {
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
            this.writePosition(userIdRow, userIdColumn, "signatures 1");

            userIdRow = 3;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, "888");

            userIdRow = 4;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "MRS");

            userIdRow = 4;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, "TE");

            userIdRow = 4;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, "21041948");

            userIdRow = 5;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "DLAMINI");

            userIdRow = 5;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, "MALE");

            userIdRow = 6;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "GIFT MELUSI");

            userIdRow = 6;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, "E");

            userIdRow = 7;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "ID TYPE");

            userIdRow = 7;
            userIdColumn = 25;
            this.writePosition(userIdRow, userIdColumn, "ID NUMBER");

            userIdRow = 7;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, "COB");

            userIdRow = 8;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, "Y");

            userIdRow = 8;
            userIdColumn = 58;
            this.writePosition(userIdRow, userIdColumn, "COUNTRY OF BIRTH");

            userIdRow = 10;
            userIdColumn = 33;
            this.writePosition(userIdRow, userIdColumn, "Y");

            userIdRow = 10;
            userIdColumn = 55;
            this.writePosition(userIdRow, userIdColumn, "DESIGNATION");

            userIdRow = 11;
            userIdColumn = 23;
            this.writePosition(userIdRow, userIdColumn, "OCCUPATION STATUS");

            userIdRow = 12;
            userIdColumn = 23;
            this.writePosition(userIdRow, userIdColumn, "OCCUPATION CODE");

            userIdRow = 14;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, "ADDRESS 1");

            userIdRow = 15;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, "ADDRESS 2");

            userIdRow = 16;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, "TOWN");

            userIdRow = 17;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, "CITY");

            userIdRow = 18;
            userIdColumn = 31;
            this.writePosition(userIdRow, userIdColumn, "POSTAL CODE");

            userIdRow = 18;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, "COUNTRY");

            userIdRow = 19;
            userIdColumn = 17;
            this.writePosition(userIdRow, userIdColumn, "EMAIL");

            userIdRow = 21;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, "N");
            this.writeKey(Key.ENTER);

        }
        return false;
    }

}
