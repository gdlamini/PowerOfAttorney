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

        }
        return false;
    }

}
