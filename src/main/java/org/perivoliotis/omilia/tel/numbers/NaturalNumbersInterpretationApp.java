package org.perivoliotis.omilia.tel.numbers;

import org.perivoliotis.omilia.tel.numbers.services.NaturalNumbersInterpretationService;
import org.perivoliotis.omilia.tel.numbers.services.TelephoneNumberValidator;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalNumbersInterpretationApp {

    static Pattern p = Pattern.compile("(\\d{1,3}\\s)*");
    static NaturalNumbersInterpretationService interpretationService = new NaturalNumbersInterpretationService();
    static TelephoneNumberValidator telephoneNumberValidator = new TelephoneNumberValidator();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "";
        while (!"q".equalsIgnoreCase(input)) {

            System.out.print("Please enter a phone number or q to quit: ");

            input = scanner.nextLine().trim();

            if (isValid(input)) {
                doInterpretation(input);
            } else if (!"q".equalsIgnoreCase(input)){
                System.out.println("Invalid input use only 1 to 3 digits followed by a single space");
            }

        }

        System.out.println("bye bye!");

    }

    private static boolean isValid(String input) {
        Matcher m = p.matcher(input + " ");
        return m.matches();
    }

    private static void doInterpretation(String input) {
        String[] tokens = input.split(" ");
        Set<String> interpretedNumbers = interpretationService.execute(tokens);
        interpretedNumbers.forEach(num -> {
            String isValidPart = telephoneNumberValidator.validateNumber(num) ? "[phone number: VALID]" : "[phone number: INVALID]";
            System.out.println(num + "   " + isValidPart);
        });
    }
}
