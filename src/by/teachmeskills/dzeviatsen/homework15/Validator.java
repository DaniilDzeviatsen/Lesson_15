package by.teachmeskills.dzeviatsen.homework15;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class Validator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose operation:"+ "\n"+ "1)passport validation" +"\n"+"2)TextFilter");
        int taskNum=Integer.parseInt(sc.nextLine());
        switch (taskNum){
            case 1-> {


                System.out.println("Enter first name");
                String firstName = sc.nextLine();
                System.out.println("Enter secondName");
                String secondName = sc.nextLine();
                System.out.println("Enter gender");
                String gender = sc.nextLine();
                System.out.println("Enter day of birth");
                int dayOfBirth = Integer.parseInt(sc.nextLine());
                System.out.println("Enter month of birth");
                int monthOfBirth = Integer.parseInt(sc.nextLine());
                System.out.println("Enter year of birth");
                int yearOfBirth = Integer.parseInt(sc.nextLine());
                LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
                System.out.println("Enter passport number");
                String passportNumber = sc.nextLine();
                System.out.println("Enter passport id");
                String passportID = sc.nextLine();
                System.out.println("Enter day of issue");
                int dayOfIssue = Integer.parseInt(sc.nextLine());
                System.out.println("Enter month of issue");
                int monthOfIssue = Integer.parseInt(sc.nextLine());
                System.out.println("Enter year of issue");
                int yearOfIssue = Integer.parseInt(sc.nextLine());
                LocalDate dateOfIssue = LocalDate.of(yearOfIssue, monthOfIssue, dayOfIssue);
                System.out.println(dateOfIssue);
                System.out.println("Enter duration period of the passport");
                LocalDate dateOfExpire = dateOfIssue.plusYears(Integer.parseInt(sc.nextLine()));
                System.out.println(dateOfExpire);
                BlrPassport pp = new BlrPassport(firstName, secondName, gender, dateOfBirth,
                        passportNumber, passportID, dateOfIssue, dateOfExpire);
                System.out.println("Is passport not overdue:  " + pp.ifPassportValid(LocalDate.now(ZoneId.of("Europe/Minsk"))));
                System.out.println(pp.toString());
            }
            case 2->{
                System.out.println("Enter line of bad words split by comma+space");
                String badWordss=sc.nextLine();
                TextBlackListFilter pp = new TextBlackListFilter(badWordss);
                System.out.println("Enter line you want to check");
                String userText=sc.nextLine();
                System.out.println("Does your text contain bad words?");
                System.out.println(pp.ifContainsBadWords(userText));
                System.out.println("How many bad words does it contain?");
                System.out.println(pp.badWordsCount(userText));
                System.out.println("Your sensored line is:");
                System.out.println(pp.toSencoredText(userText));
            }
        }
    }
}
