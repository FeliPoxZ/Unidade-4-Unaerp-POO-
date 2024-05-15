package produtos;

import java.util.ArrayList;

public abstract class Produtos {


    //Atributos
    private String marca;
    private String modelo;
    private double preco;

    //fim dos atributos


    //COnstrutores
    public Produtos() {

    }

    public Produtos(String marca, String modelo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    //FIm dos construtores

    //Getters e setters


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Fim dos getters e setters

    //ToString
    @Override
    public String toString() {
        return String.format("Nome: %s\n" +
                "Preço: %s\n" +
                "Marca: %s\n", getModelo(), getPreco(), getMarca());
    }
}
