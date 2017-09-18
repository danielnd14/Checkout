package br.com.zg

import spock.lang.Specification
import spock.lang.Unroll

class CheckoutTest extends Specification {

	static Checkout checkoutA
	static Checkout checkoutB
	static Checkout checkoutC
	static Checkout checkoutD
	static Checkout checkoutABCD
	static Checkout checkoutABCD2

	void setupSpec() {
		checkoutA = new Checkout()
		checkoutB = new Checkout()
		checkoutC = new Checkout()
		checkoutD = new Checkout()
		checkoutABCD = new Checkout()
		checkoutABCD2 = new Checkout()
	}

	@Unroll
	def "Adicionando varios produtos A"() {


		when:
		checkoutA.adicionar(produto)

		then:
		totalprice == checkoutA.getTotalPrice()


		where:
		produto || totalprice
		"A"     || 50.0
		"A"     || 100.0
		"A"     || 130.0//discount
		"A"     || 180.0
		"A"     || 230.0
		"A"     || 260.0//discount
		"A"     || 310.0
		"A"     || 360.0
		"A"     || 390.0//discount
		"A"     || 440.0
		"A"     || 490.0
		"A"     || 520.0//discount
		"A"     || 570.0
		"A"     || 620.0
		"A"     || 650.0//discount
		"A"     || 700.0
		"A"     || 750.0
		"A"     || 780.0//discount
		"A"     || 830.0
		"A"     || 880.0
		"A"     || 910.0//discount
		"A"     || 960.0
		"A"     || 1010.0
		"A"     || 1040//discount
		"A"     || 1090.0
		"A"     || 1140.0
		"A"     || 1170.0//discount
		"A"     || 1220.0
		"A"     || 1270.0
		"A"     || 1300.0//discount
		"A"     || 1350.0
		"A"     || 1400.0
		"A"     || 1430.0//discount
		"A"     || 1480.0
		"A"     || 1530.0
		"A"     || 1560.0//discount
	}

	@Unroll
	def "Adicionando varios produtos B"() {


		when:
		checkoutB.adicionar(produto)

		then:
		totalprice == checkoutB.getTotalPrice()


		where:
		produto || totalprice
		"B"     || 30.0
		"B"     || 45.0//discount
		"B"     || 75.0
		"B"     || 90.0//discount
		"B"     || 120.0
		"B"     || 135.0//discount
		"B"     || 165.0
		"B"     || 180.0//discount
		"B"     || 210.0
		"B"     || 225.0//discount
		"B"     || 255.0
		"B"     || 270.0//discount
		"B"     || 300.0
		"B"     || 315.0//discount
		"B"     || 345.0
		"B"     || 360.0//discount
		"B"     || 390.0
		"B"     || 405.0//discount
		"B"     || 435.0
		"B"     || 450.0//discount
		"B"     || 480.0
		"B"     || 495.0//discount
		"B"     || 525.0
		"B"     || 540.0//discount
		"B"     || 570.0
		"B"     || 585.0//discount
	}

	@Unroll
	def "Adicionando varios produtos C"() {


		when:
		checkoutC.adicionar(produto)

		then:
		totalprice == checkoutC.getTotalPrice()


		where:
		produto || totalprice
		"C"     || 20.0
		"C"     || 40.0
		"C"     || 40.0//discount
		"C"     || 60.0
		"C"     || 80.0
		"C"     || 80.0//discount
		"C"     || 100.0
		"C"     || 120.0
		"C"     || 120.0//discount
		"C"     || 140.0
		"C"     || 160.0
		"C"     || 160.0//discount
		"C"     || 180.0
		"C"     || 200.0
		"C"     || 200.0//discount
		"C"     || 220.0
		"C"     || 240.0
		"C"     || 240.0//discount

	}

	@Unroll
	def "Adicionando varios produtos D"() {


		when:
		checkoutD.adicionar(produto)

		then:
		totalprice == checkoutD.getTotalPrice()


		where:
		produto || totalprice
		"D"     || 15.0
		"D"     || 30.0
		"D"     || 45.0
		"D"     || 60.0
		"D"     || 75.0
		"D"     || 90.0
		"D"     || 105.0
		"D"     || 120.0
		"D"     || 135.0
		"D"     || 150.0
		"D"     || 165.0
	}

	@Unroll
	def "Adicionando varios produtos ABCD"() {


		when:
		checkoutABCD.adicionar(produto)

		then:
		totalprice == checkoutABCD.getTotalPrice()


		where:
		produto || totalprice
		"D"     || 15.0
		"D"     || 30.0
		"D"     || 45.0
		"A"     || 95.0
		"A"     || 145.0
		"B"     || 175.0
		"C"     || 195.0
		"C"     || 215.0
		"A"     || 245.0
		"D"     || 260.0
		"C"     || 260.0
		"B"     || 275.0
		"D"     || 290.0
	}

	@Unroll
	def "Calculando desconto da compra apos adicao varios produtos ABCD"() {


		when:
		checkoutABCD2.adicionar(produto)
		checkoutABCD2.adicionar(produto)
		checkoutABCD2.adicionar(produto)
		checkoutABCD2.adicionar(produto)
		checkoutABCD2.adicionar(produto)
		checkoutABCD2.adicionar(produto)

		then:
		totalprice == checkoutABCD2.getTotalDiscount()


		where:
		produto || totalprice
		"D"     || 0.0
		"A"     || 40.0
		"B"     || 85.0
		"C"     || 125.0
	}

	@Unroll
	def "Calculando desconto de um produto apos adicao ABCD"() {
		given:
		Checkout checkoutAux = new Checkout()

		when:
		"Adicionando 6 produtos do tipo ${produto}"
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)

		then:
		"Verificando o desconto total após adicionar 6 ${produto}"
		totalDiscount == checkoutAux.getTotalDiscount()


		where:
		produto || totalDiscount
		"D"     || 0.0
		"A"     || 40.0
		"B"     || 45.0
		"C"     || 40.0
	}

	@Unroll
	def "Calculando preco apos remoção de um produto ABCD"() {
		given:
		Checkout checkoutAux = new Checkout()


		when:

		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)
		checkoutAux.adicionar(produto)

		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)

		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)

		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)

		checkoutAux.removerDoCarrinho(produto4)


		then:
		totalPrice == checkoutAux.getTotalPrice()


		where:
		produto | produto2 | produto3 | produto4 || totalPrice
		"D"     | "A"      | "B"      | "C"      || 660.0
		"A"     | "B"      | "C"      | "D"      || 665.0
		"D"     | "C"      | "B"      | "A"      || 630.0
		"C"     | "D"      | "A"      | "B"      || 650.0

	}

	def "Pagamentos"() {
		given:
		Checkout checkoutAux = new Checkout()

		when:
		checkoutAux.adicionar(produto)

		checkoutAux.adicionar(produto2)
		checkoutAux.adicionar(produto2)

		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)
		checkoutAux.adicionar(produto3)


		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)
		checkoutAux.adicionar(produto4)

		then:
		troco == checkoutAux.pagar(pagamento)

		where:
		produto | produto2 | produto3 | produto4 | pagamento || troco
		"D"     | "A"      | "B"      | "C"      | 250.0     || 0.0
		"A"     | "B"      | "C"      | "D"      | 195.0     || 0.0
		"D"     | "C"      | "B"      | "A"      | 310.0     || 0.0
		"C"     | "D"      | "A"      | "B"      | 270.0     || 0.0

		"D"     | "A"      | "B"      | "C"      | 251.0     || 1.0
		"A"     | "B"      | "C"      | "D"      | 205.0     || 10.0
		"D"     | "C"      | "B"      | "A"      | 325.0     || 15.0
		"C"     | "D"      | "A"      | "B"      | 300.0     || 30.0

	}

}