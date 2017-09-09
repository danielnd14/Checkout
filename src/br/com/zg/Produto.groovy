package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class Produto {

    private String name = ""
    private double price = 0
    private double discount = 0

    Produto(String nome, Double preco) {
        this.name = nome
        this.price = preco
        this.discount = 0.0
    }
}
