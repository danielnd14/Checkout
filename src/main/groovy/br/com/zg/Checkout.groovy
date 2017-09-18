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

	void adicionar(String nome) throws IllegalArgumentException {

		Produto produto = estoque.consultarPorNome(nome)

		if (produto != null) {

			if (carrinho.containsKey(produto)) {

				carrinho.put(produto, carrinho.get(produto) + 1)

			} else {

				carrinho.put(produto, 1)

			}
		} else {
			throw new IllegalArgumentException("produto nao encontrado no estoque")
		}

	}

	void removerDoCarrinho(String name) throws IllegalArgumentException {

		Produto produto = estoque.consultarPorNome(name)

		int totalNoCarrinho = carrinho.get(produto)

		if (totalNoCarrinho > 0) {

			totalNoCarrinho--
			carrinho.put(produto, totalNoCarrinho)

		} else {

			throw new IllegalArgumentException("nao ha mais desse produto no carrinho")
		}

	}

	BigDecimal getTotalPrice() {

		BigDecimal total = 0.0
		BigDecimal discount = 0.0

		Produto produto

		carrinho.entrySet().each {

			produto = it.key
			int qtdCarrinho = it.value

			total += produto.price * qtdCarrinho

			int multiplo = regrasDesconto.getQuantidadeParaDesconto(produto)
			multiplo = qtdCarrinho / (multiplo != 0 ? multiplo : 1)
			discount += multiplo * produto.discount
		}

		return total - discount
	}

	BigDecimal getTotalDiscount() {

		BigDecimal total = 0.0
		Produto produto

		carrinho.entrySet().each {

			produto = it.key
			int qtdCarrinho = it.value

			int multiplo = regrasDesconto.getQuantidadeParaDesconto(produto)
			multiplo = qtdCarrinho / (multiplo != 0 ? multiplo : 1)
			total += multiplo * produto.discount

		}
		return total

	}

	BigDecimal pagar(BigDecimal pagamento) throws IllegalArgumentException {

		Produto produto
		BigDecimal troco = 0.0

		if ((pagamento - getTotalPrice()) >= 0) {

			carrinho.entrySet().each {
				produto = it.key
				estoque.colherProduto(produto, it.value)
			}

			troco += (pagamento - getTotalPrice())

		} else {
			throw new IllegalArgumentException("Valor insuficiente para o pagamento")
		}
		return troco
	}
}