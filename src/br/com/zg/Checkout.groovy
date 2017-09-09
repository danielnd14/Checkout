package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class Checkout {
    private Estoque estoque
    private RegrasDesconto regrasDesconto
    private Map<Produto, Integer> carrinho

    Checkout() {
        estoque = new Estoque()


        Produto a = new Produto("A", 50.0)
        Produto b = new Produto("B", 30.0)
        Produto c = new Produto("C", 20.0)
        Produto d = new Produto("D", 15.0)

        estoque.inserirNoEstoque(a, 500)
        estoque.inserirNoEstoque(b, 300)
        estoque.inserirNoEstoque(c, 200)
        estoque.inserirNoEstoque(d, 150)

        regrasDesconto = new RegrasDesconto(estoque)
        regrasDesconto.setDiscount(a, 20, 3)
        regrasDesconto.setDiscount(b, 15, 2)
        regrasDesconto.setDiscount(c, 20, 3)
        regrasDesconto.setDiscount(d, 0, 1)
        carrinho = [:]

    }

    void add(String nome) {

        Produto produto = estoque.consultarPorNome(nome)

        if (produto != null) {

            if (carrinho.containsKey(produto)) {

                carrinho.put(produto, carrinho.get(produto) + 1)

            } else {

                carrinho.put(produto, 1)

            }
        } else {
            println("produto nao encontrado no estoque")
        }

    }

    void remover(String name) {

        Produto produto = estoque.consultarPorNome(name)

        int totalNoCarrinho = carrinho.get(produto)

        if (totalNoCarrinho > 0) {

            totalNoCarrinho--
            carrinho.put(produto, totalNoCarrinho)

        } else {
            println("nao ha mais desse produto no carrinho")//talvez seja melhor lancar uma excessao
        }

    }

    double getTotalPrice() {
        double total = 0.0
        double discount = 0.0

        Produto produto

        for (Map.Entry<Produto, Integer> entrada : carrinho.entrySet()) {

            produto = entrada.key
            int qtdCarrinho = entrada.value

            total += produto.price * qtdCarrinho

            int multiplo = regrasDesconto.getQuantidadeParaDesconto(produto)
            multiplo = qtdCarrinho / (multiplo != 0 ? multiplo : 1)
            discount += multiplo * produto.discount

        }
        return total - discount
    }

    double getTotalDiscount() {

        double total = 0.0
        Produto produto
        for (Map.Entry<Produto, Integer> entrada : carrinho.entrySet()) {

            produto = entrada.key
            int qtdCarrinho = entrada.value

            int multiplo = regrasDesconto.getQuantidadeParaDesconto(produto)
            multiplo = qtdCarrinho / (multiplo != 0 ? multiplo : 1)
            total += multiplo * produto.discount
        }
        return total

    }

    double pagar(double pagamento) {

        Produto produto
        double troco = 0.0

        if ((pagamento - getTotalPrice()) >= 0) {

            for (Map.Entry<Produto, Integer> entrada : carrinho.entrySet()) {
                produto = entrada.key
                estoque.colherProduto(produto, entrada.value)
            }

            troco += (pagamento - getTotalPrice())

        } else {
            println("Valor insuficiente para o pagamento")//talvez seja melhor lancar uma excessao
        }
    }
}
