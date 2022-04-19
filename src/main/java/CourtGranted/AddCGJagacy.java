package CourtGranted;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;

public class AddCGJagacy extends Session3270 {

    private int userIdRow;
    private int userIdColumn;
    private String message = null;


    public AddCGJagacy() throws JagacyException {
        super("sessionA","host3270.absa.co.za",993,"IBM-3279-5-E",true);
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

            userIdRow = 1;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, "1");

            userIdRow = 3;
            userIdColumn = 59;
            this.writePosition(userIdRow, userIdColumn, "1");

            userIdRow = 4;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, "888");

            userIdRow = 5;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "1");

            userIdRow = 5;
            userIdColumn = 34;
            this.writePosition(userIdRow, userIdColumn, "KM");

            userIdRow = 5;
            userIdColumn = 61;
            this.writePosition(userIdRow, userIdColumn, "02011992");

            userIdRow = 6;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "King");

            userIdRow = 6;
            userIdColumn = 52;
            this.writePosition(userIdRow, userIdColumn, "M");

            userIdRow = 7;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "Don");

            userIdRow = 7;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, "E");

            userIdRow = 8;
            userIdColumn = 11;
            this.writePosition(userIdRow, userIdColumn, "1");

            userIdRow = 8;
            userIdColumn = 25;
            this.writePosition(userIdRow, userIdColumn, "920102");

            userIdRow = 8;
            userIdColumn = 56;
            this.writePosition(userIdRow, userIdColumn, "18042022");

            userIdRow = 9;
            userIdColumn = 15;
            this.writePosition(userIdRow, userIdColumn, "SOU01");

            userIdRow = 9;
            userIdColumn = 62;
            this.writePosition(userIdRow, userIdColumn, "SO003");

            userIdRow = 10;
            userIdColumn = 70;
            this.writePosition(userIdRow, userIdColumn, "Y");

            userIdRow = 14;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "1250");

            userIdRow = 15;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "Makhanda Street");

            userIdRow = 16;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "Bhekuzulu");

            userIdRow = 17;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "Vryheid");

            userIdRow = 18;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "3100");

            userIdRow = 18;
            userIdColumn = 66;
            this.writePosition(userIdRow, userIdColumn, "SO003");

            userIdRow = 19;
            userIdColumn = 19;
            this.writePosition(userIdRow, userIdColumn, "gift.dlamini@absa.africa");


            userIdRow = 21;
            userIdColumn = 54;
            this.writePosition(userIdRow, userIdColumn, "N");
            this.writeKey(Key.ENTER);
            this.waitForChange(30000);




        }

        return false;
    }
}
