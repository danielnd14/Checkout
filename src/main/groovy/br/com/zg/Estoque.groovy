package br.com.zg
/**
 * Created by daniel on 09/09/17.
 */
class Estoque {
    private Map<Produto, Integer> mapProdutos

    Estoque() {
        mapProdutos = [:]
    }

    void inserirNoEstoque(Produto produto, int quantidade) {

        if (mapProdutos.containsKey(produto)) {
            println("produto ja cadastrado, estoque atualizado")
        }
        mapProdutos.put(produto, quantidade)

    }

    void remover(Produto produto) {
        mapProdutos.remove(produto)
    }

    void colherProduto(Produto produto, int quantidade) {

        int totalEmEstoque = mapProdutos.get(produto)

        if (totalEmEstoque - quantidade >= 0) {

            totalEmEstoque -= quantidade
            mapProdutos.put(produto, totalEmEstoque)

        } else {
            throw new IllegalArgumentException("nao ha mais desse Produto em estoque")
        }

    }

    boolean exists(Produto produto) {
        return mapProdutos.containsKey(produto)
    }

    Produto consultarPorNome(String nome) {


        for (Produto produto1 : mapProdutos.keySet()) {
            if (nome.equalsIgnoreCase(produto1.name)) {
                return produto1
            }
        }
    }
}