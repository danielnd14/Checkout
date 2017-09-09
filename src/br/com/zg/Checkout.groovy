package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class Checkout {
    private Produts produtos;
    Checkout(){
        produtos = new Produts()
        produtos.cadastrar("A",50)
        produtos.cadastrar("B",30)
        produtos.cadastrar("C",20)
        produtos.cadastrar("D",15)
    }
}
