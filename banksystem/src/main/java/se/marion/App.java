package se.marion;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
     
        Bankomat bank = new Bankomat();
        bank.readFile();
        bank.mainMenu();
    }
}
