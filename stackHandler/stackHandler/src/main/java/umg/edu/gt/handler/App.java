package umg.edu.gt.handler;

import umg.edu.gt.data_structure.stack.SymbolValidator;

public class App {

    public static void main(String[] args) {
        SymbolValidator validator = new SymbolValidator();

        if (args.length > 0) {
            String expr = args[0];
            boolean result = validator.isValid(expr);
            System.out.println(expr + " -> " + result);
            return;
        }
        
        String validCase = "(a+b) * [c-d]";
        String invalidCase = "([)]";

        System.out.println(validCase + " -> " + validator.isValid(validCase));
        System.out.println(invalidCase + " -> " + validator.isValid(invalidCase));
    }
}