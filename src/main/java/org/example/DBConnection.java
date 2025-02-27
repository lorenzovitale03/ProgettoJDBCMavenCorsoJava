package org.example;

import java.sql.*;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "root";
    private String nameDb = "GestioneOrdini";
    private Connection conn;
    private Statement st;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url,user,password);
        st = conn.createStatement();
        System.out.println("DB Connesso");
        createDb();
        clientTable();
        productsTable();
        ordersTable();
        orderDetailsTable();
    }

    private void createDb() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + this.nameDb;
        st.executeUpdate(sql);
        System.out.println("Connesso a" + this.nameDb);
        conn = DriverManager.getConnection(url+nameDb,user,password);
        st = conn.createStatement();
    }

    private void clientTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clienti ("
                + "id_cliente INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(100) NOT NULL, "
                + "email VARCHAR(150) UNIQUE NOT NULL, "
                + "telefono VARCHAR(20) NULL"
                + ")";
        st.executeUpdate(sql);
        System.out.println("Tabella clienti creata");
    }

    private void productsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS prodotti ("
                + "id_prodotto INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(150) NOT NULL, "
                + "descrizione TEXT NULL, "
                + "prezzo DECIMAL(10,2) NOT NULL, "
                + "quantita_disponibile INT NOT NULL "
                + ")";
        st.executeUpdate(sql);
        System.out.println("Tabella prodotti creata");
    }

    private void ordersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ordini ("
                + "id_ordine INT PRIMARY KEY AUTO_INCREMENT, "
                + "id_cliente INT NOT NULL, "
                + "data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "CONSTRAINT cliente_fk FOREIGN KEY (id_cliente) REFERENCES clienti(id_cliente) ON DELETE CASCADE"
                + ")";
        st.executeUpdate(sql);
        System.out.println("Tabella ordini creata");
    }

    private void orderDetailsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS dettagliordini ("
                + "id_dettagli_ordini INT PRIMARY KEY AUTO_INCREMENT, "
                + "id_ordine INT NOT NULL, "
                + "id_prodotto INT NOT NULL,"
                + "quantità INT NOT NULL,"
                + "prezzo_unitario DECIMAL(10,2) NOT NULL,"
                + "CONSTRAINT ordine_fk FOREIGN KEY (id_ordine) REFERENCES ordini(id_ordine) ON DELETE CASCADE, "
                + "CONSTRAINT prodotti_fk FOREIGN KEY (id_prodotto) REFERENCES prodotti(id_prodotto) ON DELETE CASCADE"
                + ")";
        st.executeUpdate(sql);
        System.out.println("Tabella dettagli ordini creata");
    }

    //CRUD
    public void inserisciClienti (Cliente c) throws SQLException {
       String sql = "INSERT INTO clienti(nome, email, telefono) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,c.getNome());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getTelefono());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " inserito nel sistema");
    }

    public void updateClienti(Cliente c) throws SQLException {
        String sql ="UPDATE clienti SET nome = ?, email = ?, telefono = ? WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getTelefono());
        ps.setInt(4, c.getIdCliente());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " modificato nel sistema");
    }

    public void removeClienti(Cliente c) throws SQLException {
        String sql = "DELETE FROM clienti WHERE nome = ? AND email = ? AND telefono = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2,c.getEmail());
        ps.setString(3, c.getTelefono());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " rimosso dal sistema");
    }

    public void inserireProdotti (Prodotti p) throws SQLException {
        String sql = "INSERT INTO prodotti(nome, descrizione, prezzo, quantita_disponibile) VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantita());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " aggiunto al sistema");
    }

    public void updateProdotti(Prodotti p) throws SQLException{
        String sql = "UPDATE prodotti SET nome = ?, descrizione = ?, prezzo = ?, quantita_disponibile = ? " +
                "WHERE id_prodotto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantita());
        ps.setInt(5, p.getIdProdotti());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " aggiornato nel sistema");
    }

    public void removeProdotti(Prodotti p) throws SQLException{
        String sql = "DELETE FROM prodotti WHERE nome = ? AND descrizione = ? AND prezzo = ? AND quantita_disponibile = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,p.getNome());
        ps.setString(2,p.getDescrizione());
        ps.setDouble(3,p.getPrezzo());
        ps.setInt(4,p.getQuantita());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + " rimosso dal sistema");
    }
    
}
