package umg.edu.gt.data_structure.stack;

public class SymbolValidator {

    public boolean isValid(String expr) {
        MyStack stack = new MyStack();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (!matches(top, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}