import java.util.Scanner;

public class InputFromKeyboard {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("How old are you? ");
        int age = input.nextInt();
        System.out.print("How tall are you (m)");
        double height = input.nextDouble();
        System.out.println("Hello Mr." + name + ", " + age + " years old. "
                + "Your height is: " + height + ".");
    }
}
