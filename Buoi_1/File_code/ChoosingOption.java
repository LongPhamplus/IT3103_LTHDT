import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        String[] options = { "Scissors", "Rock", "Paper" };
        int selection = JOptionPane.showOptionDialog(null, "Select one:", "Let's play a game!",
                0, 3, null, options, options[0]);
        if (selection == 0)
        {
            JOptionPane.showMessageDialog(null, "You have chose Scissors !!!");
        }
        else if (selection == 1)
        {
            JOptionPane.showMessageDialog(null, "You have chose Rock !!!");
        }
        else if (selection == 2)
        {
            JOptionPane.showMessageDialog(null, "You have chose Paper !!!");
        }

        System.exit(0);
    }
}