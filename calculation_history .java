import java.util.*;

public class Calculations_handle {

    private Scanner userInput = new Scanner(System.in);
    private boolean keepOn = true;
    private Vector<Double> calculations = new Vector<>();

    public void start() {
        System.out.println("Welcome to my calculator!");
        while (keepOn) {
            calculate();
        }
        userInput.close();
    }

    public String chooseOperator() {
        String operator;
        while (true) {
            System.out.println("What to do?" +
                    "\n + for add" +
                    "\n - for minus" +
                    "\n * for multiply" +
                    "\n / for divide");
            operator = userInput.next();

            if (operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/")) {
                return operator;
            } else {
                System.out.println("Invalid operator. Please enter one of: +  -  *  /");
            }
        }
    }

    public double getFirstNumber() {
        System.out.println("Input the 1st number");
        while (!userInput.hasNextDouble()) {
            System.out.println("Please enter a valid number:");
            userInput.next();
        }
        return userInput.nextDouble();
    }

    public double getSecondNumber() {
        System.out.println("Input the 2nd number");
        while (!userInput.hasNextDouble()) {
            System.out.println("Please enter a valid number:");
            userInput.next();
        }
        return userInput.nextDouble();
    }

    public void addition(double a, double b) {
        calculations.addElement(a + b);
        System.out.println("The Num is: " + (a + b));
    }

    public void division(double a, double b) {
       
        calculations.addElement(a / b);
        System.out.println("The Num is: " + (a / b));
    }

    public void mult(double a, double b) {
        calculations.addElement(a * b);
        System.out.println("The Num is: " + (a * b));
    }

    public void sub(double a, double b) {
        calculations.addElement(a - b);
        System.out.println("The Num is: " + (a - b));
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n Pick an option: ");
            System.out.println("1. Another operation?");
            System.out.println("2. History?");
            System.out.println("3. Exit?");
            String choice = userInput.next();

            if (choice.equals("1")) {
                return;
            } else if (choice.equals("3")) {
                keepOn = false;
                exitMessage();
                return;
            } else if (choice.equals("2")) {
                loadHistory();
            } else {
                System.out.println("Invalid choice ");
            }
        }
    }

    public void loadHistory() {
        System.out.println(" Calculation History: ");
        if (calculations.isEmpty()) {
            System.out.println("no calculations yet");
            return;
        }
        for (int i = 0; i < calculations.size(); i++) {
            System.out.println((i + 1) + " " + calculations.get(i));
        }
    }

    public void exitMessage() {
        System.out.println("Calculations done: ");
        for (int i = 0; i < calculations.size(); i++) {
            System.out.println((i + 1) + "  " + calculations.get(i));
        }
        System.out.println("Thank you for using our program! Hope you enjoyed the experience!");
    }

    public void calculate() {
        String operation = chooseOperator();
        double num1 = getFirstNumber();
        double num2 = getSecondNumber();

        switch (operation) {
            case "+":
                addition(num1, num2);
                break;
            case "-":
                sub(num1, num2);
                break;
            case "*":
                mult(num1, num2);
                break;
            case "/":
                division(num1, num2);
                break;
            default:
                System.out.println("Invalid operation");
        }

        showMenu();
    }

    public static void main(String[] args) {
        // instantiate the same class name as declared above
        Calculations_handle handler = new Calculations_handle();
        handler.start();
    }
}
