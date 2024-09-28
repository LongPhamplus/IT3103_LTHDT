import java.util.*;

public class NumberOfDays {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Get month: ");
        String month = input.nextLine();
        System.out.println("Get Year: ");
        int year = 0;
        try {
            year = input.nextInt();
        } catch (Exception e) {
            System.out.println(
                    "valid inputs of year 1999 is only 1999, but not 99, \"one thousand nine hundred ninety-" + //
                            "nine\", or anything else.");
            System.exit(0);
        }

        String[] Month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] Abbreviation = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "Jul", "Aug.", "Sept.",
                "Oct.", "Nov.", "Dec." };
        String[] In3letters = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec" };
        String[] InNumber = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12" };

        List<String> MonthToList = Arrays.asList(Month), AbbreviationToList = Arrays.asList(Abbreviation),
                In3lettersToList = Arrays.asList(In3letters), InNumberToList = Arrays.asList(InNumber);
        int[] DayOfMonthInCommonYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] DayOfMonthInLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (MonthToList.contains(month)) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(DayOfMonthInLeapYear[MonthToList.indexOf(month)]);
            } else {
                System.out.println(DayOfMonthInCommonYear[MonthToList.indexOf(month)]);
            }
        } else if (AbbreviationToList.contains(month)) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(DayOfMonthInLeapYear[AbbreviationToList.indexOf(month)]);
            } else {
                System.out.println(DayOfMonthInCommonYear[AbbreviationToList.indexOf(month)]);
            }
        } else if (In3lettersToList.contains(month)) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(DayOfMonthInLeapYear[In3lettersToList.indexOf(month)]);
            } else {
                System.out.println(DayOfMonthInCommonYear[In3lettersToList.indexOf(month)]);
            }
        } else if (InNumberToList.contains(month)) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(DayOfMonthInLeapYear[InNumberToList.indexOf(month)]);
            } else {
                System.out.println(DayOfMonthInCommonYear[InNumberToList.indexOf(month)]);
            }
        } else {
            System.out.printf("There are no %s months in the year.", month);
        }
    }
}
