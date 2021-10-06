package se.marion;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Bankomat bank = new Bankomat();
        bank.mainMenu();
    }
}
