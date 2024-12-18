package hust.soict.globalict.garbage;


public class NoGarbage {
	 public static void main(String[] args) {
	        System.out.println("Starting No Garbage...");
	        StringBuilder sb = new StringBuilder();

	        try {
	            for (int i = 0; i < 1_000_000; i++) {
	                // Efficient string manipulation using StringBuilder
	                sb.append("A");

	                // Optional: Print memory usage periodically
	                if (i % 100_000 == 0) {
	                    System.out.println("Iteration: " + i + " - Free memory: " + Runtime.getRuntime().freeMemory());
	                }
	            }
	        } catch (OutOfMemoryError e) {
	            System.out.println("Out of memory! But this is unlikely with StringBuilder.");
	        }

	        System.out.println("Final string length: " + sb.length());
	        System.out.println("Program terminated gracefully.");
	    }
}
