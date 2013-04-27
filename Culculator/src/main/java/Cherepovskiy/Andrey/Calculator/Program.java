package Cherepovskiy.Andrey.Calculator;

public class Program {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new GraphicalUI();
        } else if ("-c".compareTo(args[0]) == 0) {
            new ConsoleUI().start();
        } else{
            System.out.println("You tried to run the calculator with the wrong parameter.");
            System.out.println("To start the calculator in console mode, use the parameter \"-c\"");
            System.out.println("To start the calculator in graphical mode, don't use the parameter");
        }
    }
}