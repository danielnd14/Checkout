package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class Produts {
    private HashMap<String, Double> produtos

    Produts() {
        produtos = [:]
    }

    void cadastrar(String produt, double price) {

        if (produtos.containsKey(produt)) {
            println("produto ja cadastrado, preço atualizado")
        }
        produtos.put(produt, price)

    }
    void remover(String produt){
        produtos.remove(produt)
    }
}
