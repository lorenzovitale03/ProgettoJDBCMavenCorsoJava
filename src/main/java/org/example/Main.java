package org.example;

import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static DBConnection db;

    public static void main(String[] args) {
        try {
            db = new DBConnection();

            DBConnection connessione = new DBConnection();
            //Cliente clienteUno = new Cliente("giorgiacchi@libero.it","320001000","Giorgio Giacchi");
            //Cliente clienteDue = new Cliente("marcochiatti1994@gmail.com","3210039891","Marco Chiattini");
            //Cliente clienteTre = new Cliente("esempioUpdate@gmail.com","3301120053","Tom Newman");
            //connessione.inserisciClienti(clienteUno);
            //connessione.inserisciClienti(clienteDue);

            //Prodotti prodotto = new Prodotti("Scolapasta",2,"Scolapasta qualunque",3.2);
            Prodotti prodottoDue = new Prodotti("Termometro da cucina",10,"Per misurare il cibo",2.1);
            //connessione.inserireProdotti(prodotto);
            //connessione.inserireProdotti(prodottoDue);

            //connessione.updateClienti(clienteTre);
            connessione.updateProdotti(prodottoDue);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}