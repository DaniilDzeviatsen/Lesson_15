package by.teachmeskills.dzeviatsen.homework15;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlrPassport {
    private String firstName;
    private String secondName;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfIssue;
    private LocalDate dateOfExpire;
    private String passportNumber;
    private String passportID;

    public BlrPassport(String firstName, String secondName,
                       String gender, LocalDate dateOfBirth,
                       String passportNumber, String passportID, LocalDate dateOfIssue, LocalDate dateOfExpire) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.secondName = secondName;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpire = dateOfExpire;
        this.passportID = passportID;
        this.gender = gender;
        Pattern num = Pattern.compile("(AB|BM|HB|KH|MP|MC|KB|PP|SP|DP)\\d{7}");
        Matcher matcher = num.matcher(passportNumber);
        boolean gg= matcher.find();
        if (!gg) {
            throw new IllegalArgumentException("Wrong data input(Passport number)");
        }

        Pattern id = Pattern.compile("\\d{7}(A|B|C|K|M|E|H)\\d{3}(PB|BA|BI)\\d");
        Matcher matcher1 = id.matcher(passportID);
        boolean gg1=matcher1.find();
        if (!gg1) {
            throw new IllegalArgumentException("Wrong data input(Passport id number");
        }

        boolean ifDataValid = dateOfExpire.isAfter(dateOfIssue);
        if (!ifDataValid) {
            throw new IllegalArgumentException("Wrong data input(date of expire should be before date of issue");
        }
    }

    public boolean ifPassportValid(LocalDate now) {
        return dateOfExpire.isAfter(now);
    }
public String toString(){
    return "%s %s %s%s%n%s %s%n%s %s%n%s %s%n%s %s%n%s %s".formatted(firstName, secondName,"Gender:", gender,"Date of birth:", dateOfBirth,
            "Passport issued:", dateOfIssue, "Passport will be expired", dateOfExpire, "Passport number:", passportNumber,
            "Passport id:", passportID);
}
}
