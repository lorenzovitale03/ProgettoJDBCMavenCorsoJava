package org.example;

public class Cliente {

    private String nome;
    private String email;
    private String telefono;
    private int idCliente;

    public Cliente(String email, String telefono, String nome) {
        this.email = email;
        this.telefono = telefono;
        this.nome = nome;
    }

    public Cliente(String nome, String email, String telefono, int idCliente) {
        this.nome = nome;
        this.email = email;
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public String getTelefono() {
        return telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
