package se.marion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaktion {
    private int number;
    private String sort;
    private int amount;
    private String datum;

    public Transaktion(String sort, int amount, LocalDateTime  datum){
        super();
        setNumber(number);
        setSort(sort);
        setAmount(amount);
        setDate(datum);
    }

    public void printLastTransaction(){
        System.out.println("Type: "+getSort()+"\nAmount: "+getAmount()+"\nDate: "+getDatum());
    }


    private void setDate(LocalDateTime datum) {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:ms");
        this.datum = rightNow.format(myFormatObj);
    }


    private void setAmount(int amount) {
        this.amount=amount;
    }


    private void setSort(String sort) {
        this.sort=sort;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public String  getDatum() {
        return datum;
    }


    public String getSort() {
        return sort;
    }


    public int getAmount() {
        return amount;
    }


public void addToFile() {
    String path = "C:/JAVA21/Codes/JavaA/Bankomat/banksystem/src/main/java/se/marion/log.txt";
    try (BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
    br.write("**************************\nDate: "+getDatum()+ "\nType: "+getSort()+"\nAmount: "+getAmount()+"\n");
}

 catch(IOException ex){
 System.out.println(ex);
 
    }

    
}
}