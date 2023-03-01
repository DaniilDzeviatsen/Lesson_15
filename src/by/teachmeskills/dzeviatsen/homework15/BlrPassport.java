package by.teachmeskills.dzeviatsen.homework15;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlrPassport {
    private final String firstName;
    private final String secondName;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfIssue;
    private final LocalDate dateOfExpire;
    private final String passportNumber;
    private final String passportID;

    public BlrPassport(String firstName, String secondName,
                       Gender gender, LocalDate dateOfBirth,
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
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Wrong data input(Passport number)");
        }

        Pattern id = Pattern.compile("\\d{7}[ABCKMEH]\\d{3}(PB|BA|BI)\\d");
        Matcher matcher1 = id.matcher(passportID);
        if (!matcher1.matches()) {
            throw new IllegalArgumentException("Wrong data input(Passport id number");
        }

        boolean ifDataValid = dateOfExpire.isAfter(dateOfIssue);
        if (!ifDataValid) {
            throw new IllegalArgumentException("Wrong data input (date of expire should be before date of issue");
        }
    }

    public boolean ifPassportValid(LocalDate now) {
        return dateOfExpire.isAfter(now);
    }

    public String toString() {
        return "%s %s %s%s%n%s %s%n%s %s%n%s %s%n%s %s%n%s %s".formatted(firstName, secondName, "Gender:", gender, "Date of birth:", dateOfBirth,
                "Passport issued:", dateOfIssue, "Passport will be expired", dateOfExpire, "Passport number:", passportNumber,
                "Passport id:", passportID);
    }
}
