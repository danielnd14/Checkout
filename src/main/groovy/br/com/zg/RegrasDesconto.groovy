package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class RegrasDesconto implements Discount {
    private Map<Produto, Integer> regras//produto e quantidade a ser comprada para encaixar no desconto
    private Estoque estoque

    RegrasDesconto(Estoque mapProdutos) {
        this.estoque = mapProdutos
        regras = [:]

    }

    @Override
    void setDiscount(Produto produto, double desconto, int quantidade) {

        if (estoque.exists(produto)) {

            produto.discount = desconto
            regras.put(produto, quantidade)

        } else {
            println("nao existe esse produto no estoque")
        }

    }

    @Override
    void updateDiscount(Produto produto, double disconto, int quantidade) {
        setDiscount(produto, disconto, quantidade)
    }

    @Override
    void removeDiscount(Produto produto) {
        regras.remove(produto)
    }

    int getQuantidadeParaDesconto(Produto produto) {
        return regras.get(produto) != null ? regras.get(produto) : 0
    }
}
