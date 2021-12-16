// package se.marion;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.*;
// import static com.diogonunes.jcolor.Ansi.*;
// import static com.diogonunes.jcolor.Attribute.*;

// public class Konto {
//     HashMap<Integer, Integer> allaKonto= new HashMap<Integer, Integer>(); //har alla konto och deras saldo
//     // HashMap<Integer, String> allaTransaktioner= new HashMap<Integer, String>(); //har alla konto och deras transaktioner
//     HashMap<Integer, String> password = new HashMap<Integer, String>();
//     int number = 0;
//     // String Transaktionerna;

//     // LocalDateTime rightNow = LocalDateTime.now();
//     // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:ms");
//     // String date = rightNow.format(myFormatObj);

//     public void insats(int amount, int kontonummer){
//     //     String star = colorize("***** \n", YELLOW_TEXT(), BLACK_BACK());
//     //     String sAmount = colorize(String.valueOf(amount), GREEN_TEXT(), BLACK_BACK());
//     //     String sKontoNummer = colorize("Kontonummer:".concat(String.valueOf(kontonummer)).concat("\n"), YELLOW_TEXT(), BLACK_BACK());
//     //     allaKonto.replace(kontonummer, (allaKonto.get(kontonummer)+amount));
//     //    String saldo = String.valueOf(allaKonto.get(kontonummer));
//     //    String sInsats = "\n"+star.concat(sKontoNummer).concat("Amount in SEK: ").concat(sAmount).concat("\n").concat(colorize("Type: DEPOSIT\n", GREEN_TEXT(), BLACK_BACK()).concat(saldo+ "\n").concat(date));
//     //    if (allaTransaktioner.containsKey(kontonummer)){
//     //         allaTransaktioner.replace(kontonummer, allaTransaktioner.get(kontonummer).concat(sInsats)); 
//     //     }
//     //     else {
//     //         allaTransaktioner.put(kontonummer, sInsats);
//     //     }
//     //     System.out.println("The new amount is :"+allaKonto.get(kontonummer));
//     }

//     public void uttag(int amount, int kontonummer){
//         // if (allaKonto.get(kontonummer)-amount < 0){
//         //     System.out.println("Inte tillräckligt saldo. Din saldo är :"+allaKonto.get(kontonummer));
//         // }
//         // else {
//         // String star = colorize("***** \n", YELLOW_TEXT(), BLACK_BACK());
//         // String sAmount = colorize(String.valueOf(amount), RED_TEXT(), BLACK_BACK());
//         // String sKontoNummer = colorize("Kontonummer:".concat(String.valueOf(kontonummer)).concat("\n"), YELLOW_TEXT(), BLACK_BACK());
//         // allaKonto.replace(kontonummer, (allaKonto.get(kontonummer)-amount));
//         // String saldo = String.valueOf(allaKonto.get(kontonummer));
//         // String sUttag = "\n"+star.concat(sKontoNummer).concat("Amount in SEK: ").concat(sAmount).concat("\n").concat(colorize("Type: WITHDRAWL\n", RED_TEXT(), BLACK_BACK()).concat(saldo+ "\n").concat(date)); 
//         // if (allaTransaktioner.containsKey(kontonummer)){
//         //      allaTransaktioner.replace(kontonummer, allaTransaktioner.get(kontonummer).concat(sUttag)); 
//         // }
//         // else {allaTransaktioner.put(kontonummer, sUttag);
//         // }

//         // System.out.println("The new amount is :"+allaKonto.get(kontonummer));
//     }
// }




