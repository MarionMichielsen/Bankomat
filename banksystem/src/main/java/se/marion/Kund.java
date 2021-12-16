package se.marion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Kund {

    private String password;
    private String name;
    private int kontonummer;
    private int saldo = 0;

    public void printTransactions(){

        String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/log.txt";
        int numberOfLines = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while (( line = br.readLine()) != null) {
                    System.out.println(line);
                    numberOfLines++;
                    if (numberOfLines == 5){
                        System.out.println("");
                        numberOfLines = 0;
                    }
                }
            }
            catch(IOException ex){
                System.out.println(ex);
            }
    }
    
        public void createPassword(){
            System.out.println("Please enter a password. \nIt has to be at 8-15 characters and contain both small and big letter, a number, and a special character. ");   
            while (true){    
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
    
                    java.util.regex.Matcher hasLetter = letter.matcher(password);
                    java.util.regex.Matcher hasDigit = digit.matcher(password);
                    java.util.regex.Matcher hasSpecial = special.matcher(password);
    
                    if (hasLetter.find() && hasDigit.find() && hasSpecial.find()){ 
                        setPassword(password);
                        break;
                    }
                    else { 
                        System.out.println("Please enter a valid password. \nIt has to contain a number, an uppercase, a lower case, and a special character.");
                    }
                }
            }
    }

    public boolean checkPassword(String password){
        while (true){
            if (password.equals(getPassword())){
                return true;
            }
            else {
                System.out.println("Wrong password. Please try again");
                password = System.console().readLine();
            }
            return false;
        }
    }

    private String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        }
    public Kund(){
        super();
        setName(name);
        setKontoNummer(kontonummer);
    }

    public void adjustSaldo(int amount){
        if (getSaldo()+amount< 0){
            System.out.println("Not enough saldo.");
        }
       else 
        saldo += amount;
    }

    int getSaldo() {
        return saldo;
    }

    public void setKontoNummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void addSaldoToFile() {
        String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/log.txt";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
        br.write("Saldo: "+getSaldo()+"\n"); 
        }
        catch (Exception e){
            
        }
    }
    
}
