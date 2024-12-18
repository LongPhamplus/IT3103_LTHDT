package hust.soict.globalict.garbage;

public class GabageCreator {
	public static void main(String[] args) {
        System.out.println("Starting Garbage Creator...");
        String s = "";

        try {
            for (int i = 0; i < 1_000_000; i++) {
                // Inefficient string concatenation
                s += "A";

                // Optional: Print memory usage periodically
                if (i % 100_000 == 0) {
                    System.out.println("Iteration: " + i + " - Free memory: " + Runtime.getRuntime().freeMemory());
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory due to inefficient string handling!");
        }

        System.out.println("Program terminated.");
    }
}
