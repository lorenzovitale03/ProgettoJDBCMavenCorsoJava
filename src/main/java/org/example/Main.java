package org.example;

import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static DBConnection db;

    public static void main(String[] args) {
        try {
            db = new DBConnection();

            DBConnection connessione = new DBConnection();
            Scanner scanner = new Scanner(System.in);

            Cliente cliente = new Cliente("giorgix@gmail.com","300000200","Giorgio Giorgi");
            Prodotti prodotto = new Prodotti("Spazzolino",10,"Spazzolino da denti",1.5);

            System.out.println("Benvenuto nel Database");

            while (true){
                System.out.println("Premi 1 per aggiungere un cliente al database");
                System.out.println("Premi 2 per aggiornare clienti nel database");
                System.out.println("Premi 3 per rimuovere clienti dal database");
                System.out.println("Premi 4 per aggiungere prodotti al database");
                System.out.println("Premi 5 per aggiornare prodotti al database");
                System.out.println("Premi 6 per rimuovere prodotti dal database");
                System.out.println("Premi 7 per uscire dal Database");
                int input = scanner.nextInt();

                if(input == 1){
                    connessione.inserisciClienti(cliente);
                }else  if(input == 2){
                    connessione.updateClienti(cliente);
                }else if(input == 3){
                    connessione.removeClienti(cliente);
                }else if(input == 4){
                    connessione.inserireProdotti(prodotto);
                }else if(input == 5){
                    connessione.updateProdotti(prodotto);
                }else if(input == 6){
                    connessione.removeProdotti(prodotto);
                }else{
                    break;
                }

            }
            System.out.println("Sei uscito dal Database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}