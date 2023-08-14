package converter.example;

import converter.example.mbn.LogControlMBean;

import java.util.Scanner;

public class Processor {
    private final Converter converter;
    private final LogControlMBean mbean;

    public Processor(final Converter converter, final LogControlMBean mbean) {
        this.converter = converter;
        this.mbean = mbean;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter to exit 'exit'");
            System.out.println("Enter a string :\n");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                try {
                    processInput(input);
                } catch (Exception e) {
                    System.out.println("Error processing input: " + e.getMessage());
                }
            }
        }
    }

    private void processInput(final String input) {
        if (mbean.isLogEnabled()) {
            converter.text(input);
        } else {
            System.out.println("Logging is disabled. Unable to perform string conversion.");
        }
    }
}
