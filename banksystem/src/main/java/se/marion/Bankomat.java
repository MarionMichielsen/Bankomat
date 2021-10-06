package se.marion;
import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bankomat {

    Konto konto = new Konto(); 
    int choice1;
    int choice2;
    int insats;
    int uttag;
    int kontonummer;
    String password;
    boolean choice = true;
    boolean finnsKonto = true;
    boolean inloggad;
    boolean validPassword = false;
    boolean guessPassword = false;
    boolean choiceInsats = true;
    boolean choiceUttag = true;


    public void mainMenu(){
            while (choice){
        System.out.println(colorize("***HUVUDMENY***\n",
        YELLOW_TEXT(), 
        BLACK_BACK()));   
        System.out.println(colorize("(1). Logga in. \n(2.) Skapa nytt konto.",
        BLUE_TEXT(),
        BLACK_BACK()));
        System.out.println(colorize("(0). Avsluta. \n", 
        RED_TEXT(),
        BLACK_BACK()));
        System.out.print(colorize("Välkommen till bankens huvudmeny, vad  vill du göra? ",
        YELLOW_TEXT(),
        BLACK_BACK()));
        
        try { //kollar om man har matat in en int
             choice1 = Integer.parseInt(System.console().readLine());
        }
            catch (Exception e){ //kastar en exception om det inte var en int
                System.out.println("Ogiltig inmatning. Välj 0, 1 eller 2. Endast siffror tillåtna.");
                continue;            
            }
        switch (choice1){
            case (0):
            System.exit(0);
            case(1):
                finnsKonto = false;
                login();
                choice = false;
                break;
            case(2):
                newUser();
                choice = false;
                break;
            default:
                System.out.println(colorize("Ogiltig inmatning. ", 
                YELLOW_TEXT(),
                BLACK_BACK()));
        }
    }
}
    public void login(){
        while (finnsKonto== false){
        System.out.print(colorize("Skriv in ditt kontonummer: ", 
            BLUE_TEXT(), 
            BLACK_BACK()));    
            try { //kollar om man har matat in en int
                kontonummer = Integer.parseInt(System.console().readLine());
           }
               catch (Exception e){ //kastar en exception om det inte var en int
                   System.out.println("Ogiltig inmatning. Endast siffror tillåtna.");
                   continue;    
               }                        
        if (kontonummer == 000){
            mainMenu();
        }
        else if (konto.allaKonto.containsKey(kontonummer)){    
                System.out.println("Enter password");
                password = System.console().readLine();
                checkPassword();
            continue;
                    }
        else {
            System.out.println("Detta kontonummer finns inte. Skriv in ditt kontonummer eller tryck 000 för att gå tillbaka till Huvudmenyn. ");
            finnsKonto = false;
    
    }
}
    }
    public void newUser(){
        while (finnsKonto = true){
        System.out.println(colorize("Skapa nytt konto ",
        BLUE_TEXT(), 
            BLACK_BACK()));  
        System.out.println(colorize( "Välj ett kontonummer",
            YELLOW_TEXT(), 
                BLACK_BACK()));  
                try { //kollar om man har matat in en int
                    kontonummer = Integer.parseInt(System.console().readLine());
               }
                   catch (Exception e){ //kastar en exception om det inte var en int
                       System.out.println("Ogiltig inmatning. Välj ett kontonummer. Endast siffror tillåtna.");
                       continue;    
                   }      
        if (konto.allaKonto.containsKey(kontonummer)){
            System.out.println("Detta kontonummer är redan taget. Välj ett annat nummer");
        }
        else {
            konto.allaKonto.put(kontonummer, 0);
            finnsKonto = false;
            createPassword();
            mainMenu();
        }
    }
}
    public void createPassword(){
        System.out.println("Please enter a password. \nIt has to be at 8-15 characters and contain both small and big letter, a number, and a special character. ");   
        while (!validPassword){    
            password = System.console().readLine();
        
            if (password.length() < 8){
                System.out.println("Invalid password, too short.");
            }
            else if (password.length()>15 ){
                System.out.println("Invalid password, too slong.");
            }
            else {
                Pattern letter = Pattern.compile("[a-zA-z]");
                Pattern digit = Pattern.compile("[0-9]");
                Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

                Matcher hasLetter = letter.matcher(password);
                Matcher hasDigit = digit.matcher(password);
                Matcher hasSpecial = special.matcher(password);

                if (hasLetter.find() && hasDigit.find() && hasSpecial.find()){ 
                    konto.password.put(kontonummer,password);
                    validPassword = true;
                    continue;
                }
                else { 
                    System.out.println("Please enter a valid password. \nIt has to contain a number, an uppercase, a lower case, and a special character.");
                    continue;
                }
            }

    }
}
    public void checkPassword(){
        while (!guessPassword){
            if (password.equals(konto.password.get(kontonummer))){
                inloggad = true;
                guessPassword = true;
                kontoMenu();
            }
            else {
                System.out.println("Wrong password. Please try again");
                password = System.console().readLine();
            }
        }
    }
    public void kontoMenu(){
    
        while (inloggad){
            choiceUttag = true;
            choiceInsats = true;
            System.out.println(colorize("\nKONTOMENY "+ kontonummer+"\n",
            YELLOW_TEXT(), 
            BLACK_BACK()));  
            System.out.println(colorize("(1). Ta ut pengar \n(2). Sätt in pengar ",
            BLUE_TEXT(), 
            BLACK_BACK()));  
            System.out.println(colorize("(3). Visa saldo ",
            GREEN_TEXT(), 
            BLACK_BACK()));  
            System.out.println(colorize("(4). Visa historia ",
            GREEN_TEXT(), 
            BLACK_BACK()));  
            System.out.println(colorize("(5). Avsluta ",
            RED_TEXT(), 
            BLACK_BACK()));  
            try { //kollar om man har matat in en int
                choice2 = Integer.parseInt(System.console().readLine());
           }
               catch (Exception e){ //kastar en exception om det inte var en int
                   System.out.println("Ogiltig inmatning. Välj mellan 1-5.");
                   continue;    
               }                 
            switch (choice2){
                case(1):
                    System.out.println(colorize("Hur mycket pengar vill du ta ut? ",
                    BLUE_TEXT(), 
                    BLACK_BACK()));  
                    while (choiceUttag){
                    try { //kollar om man har matat in en int
                        uttag = Integer.parseInt(System.console().readLine());
                        choiceUttag = false;
                        konto.uttag(uttag, kontonummer);
                   }
                       catch (Exception e){ //kastar en exception om det inte var en int
                           System.out.println("Ogiltig inmatning. Hur mycket pengar vill du ta ut? Endast siffror tillåtna.");
                           continue;    
                       }               
                    }
                    break;
                case(2):
                    System.out.println(colorize("Hur mycket pengar vill du sätta in? ",
                    BLUE_TEXT(), 
                    BLACK_BACK()));  
                    while (choiceInsats){
                    try { //kollar om man har matat in en int
                        insats = Integer.parseInt(System.console().readLine());
                        choiceInsats = false;
                        konto.insats(insats, kontonummer);
                   }
                       catch (Exception e){ //kastar en exception om det inte var en int
                           System.out.println("Ogiltig inmatning. Hur mycket vill du sätta in? Endast siffror tillåtna.");
                           continue;    
                       } 
                    }                

                    break;
                case(3):
                    System.out.println("Din saldo är: "+ konto.allaKonto.get(kontonummer));
                    break;
                case(4):
                    System.out.println(konto.allaTransaktioner);
                    break;
                case(5):
                inloggad = false;
                mainMenu();
                    break;
            }
        }
    }
}