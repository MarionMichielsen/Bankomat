package se.marion;
import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.FileReader;
// import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;


public class Bankomat {

    Kund k = new Kund();
    int kundnummer = 0;
    int choice1;
    int choice2;
    int insats;
    int uttag;
    int kontonummer;
    String password;
   

    public void readFile(){
        String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/bankfil.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
             while (( line = br.readLine()) != null) {
                String[] parts = line.split(";");
                k.setName(parts[0]);
                k.setKontoNummer(Integer.parseInt(parts[1]));
                k.setPassword(parts[2]);
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
    public boolean checkPassword(String password){
        String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/bankfil.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
             while (( line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if ((kontonummer == Integer.parseInt(parts[1])) && (password.equals(parts[2])))
                return true;
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        return false;
    }


    public void mainMenu(){
            while (true){
        System.out.println(colorize("***HUVUDMENY***\n",
        YELLOW_TEXT(), 
        BLACK_BACK()));   
        System.out.println(colorize("(1). Logga in. \n(2.) Ny kund.",
        BLUE_TEXT(),
        BLACK_BACK()));
        System.out.println(colorize("(0). Avsluta. \n", 
        RED_TEXT(),
        BLACK_BACK()));
        System.out.print(colorize("Välkommen till bankens huvudmeny, vad  vill du göra? ",
        YELLOW_TEXT(),
        BLACK_BACK()));
        
        try { 
             choice1 = Integer.parseInt(System.console().readLine());
        }
            catch (Exception e){ 
                System.out.println("Ogiltig inmatning. Välj 0, 1 eller 2. Endast siffror tillåtna.");
                continue;            
            }
        switch (choice1){
            case (0):
            System.exit(0);
            case(1):
                login();
                break;
            case(2):
                newUser();
                break;
            default:
                System.out.println(colorize("Ogiltig inmatning. ", 
                YELLOW_TEXT(),
                BLACK_BACK()));
        }
    }
}
    public void login(){
        while (true){
        System.out.print(colorize("Skriv in ditt kontonummer: ", 
            BLUE_TEXT(), 
            BLACK_BACK()));    
            try { 
                kontonummer = Integer.parseInt(System.console().readLine());
           }
               catch (Exception e){ 
                   System.out.println("Ogiltig inmatning. Endast siffror tillåtna.");
                   continue;    
               }                        
        if (kontonummer == 000){
            mainMenu();
            break;
        }
        if (doesKontoExist(kontonummer)){
            while(true){
                System.out.println("Enter password");
                password = System.console().readLine();
                if (checkPassword(password))
                    break;
                System.out.println("Wrong password.Try again");
            }
            kontoMenu();
        }
    }
        }
    
        public boolean doesKontoExist(int kontonummer){                    
        String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/bankfil.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while (( line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if(kontonummer != Integer.parseInt(parts[1]))
                    continue;
               if (kontonummer == Integer.parseInt(parts[1]))
                   return true;
               }
            }
            catch(IOException ex){
            System.out.println(ex);
            }
            return false;
        }
   
    

    
    public void newUser(){
        while (true){
        System.out.println(colorize("Ny kund.",
        BLUE_TEXT(), 
            BLACK_BACK()));  
        System.out.println(colorize( "Välj ett kontonummer",
            YELLOW_TEXT(), 
                BLACK_BACK()));  
                try { 
                    kontonummer = Integer.parseInt(System.console().readLine());
               }
                   catch (Exception e){ 
                       System.out.println("Ogiltig inmatning. Välj ett kontonummer. Endast siffror tillåtna.");
                       continue;    
                   }      
        if (doesKontoExist(kontonummer)){
            System.out.println("Detta kontonummer är redan taget. Välj ett annat nummer");
        }
        else {
            System.out.println("Skriv in ditt namn");
            // String name = System.console().readLine();
            // konto.allaKonto.put(kontonummer, 0);
            k.setName(System.console().readLine());
            k.setKontoNummer(kontonummer);
            k.createPassword();
            k.setPassword(password);
            mainMenu();
        }
    }
}
    


    public void kontoMenu(){    
        while (true){
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
            try { 
                choice2 = Integer.parseInt(System.console().readLine());
           }
               catch (Exception e){ 
                   System.out.println("Ogiltig inmatning. Välj mellan 1-5.");
                   continue;    
               }                 
            switch (choice2){
                case(1):
                    System.out.println(colorize("Hur mycket pengar vill du ta ut? ",
                    BLUE_TEXT(), 
                    BLACK_BACK()));  
                    while (true){
                    try { 
                        uttag = Integer.parseInt(System.console().readLine());
                        LocalDateTime  datum = LocalDateTime .now();
                        Transaktion t = new Transaktion("Uttag",uttag, datum);
                            k.adjustSaldo(-uttag);
                            t.addToFile();
                            t.printLastTransaction();
                            k.addSaldoToFile();
                            System.out.println("Your saldo is: "+k.getSaldo());
                        break;
                   }
                       catch (Exception e){ 
                           System.out.println("Ogiltig inmatning. Hur mycket pengar vill du ta ut? Endast siffror tillåtna.");
                           continue;    
                       }               
                    }
                    break;
                case(2):
                    System.out.println(colorize("Hur mycket pengar vill du sätta in? ",
                    BLUE_TEXT(), 
                    BLACK_BACK()));  
                    while (true){
                    try { 
                        insats = Integer.parseInt(System.console().readLine());
                        LocalDateTime  datum = LocalDateTime .now();
                        Transaktion t = new Transaktion("Insats",insats, datum);
                        t.addToFile();
                        k.adjustSaldo(insats);
                        t.printLastTransaction();
                        System.out.println("Your saldo is: "+k.getSaldo());
                        k.addSaldoToFile();
                        break;
                   }
                       catch (Exception e){ 
                           System.out.println("Ogiltig inmatning. Hur mycket vill du sätta in? Endast siffror tillåtna.");
                           continue;    
                       } 
                    }                

                    break;
                case(3):
                    System.out.println("Din saldo är: "+ k.getSaldo());
                    break;
                case(4):
                    k.printTransactions();
                    break;
                case(5):
                    mainMenu();
                    break;
            }
        }
    }
}
