package br.com.zg

import spock.lang.Specification

class CheckoutTest extends Specification {

    def "Ao adicionar um item A não haverá desconto"() {
        given:
        Checkout checkout = new Checkout()

        when:
        checkout.add("A")

        then:
        50.0 == checkout.totalPrice
        0.0 == checkout.totalDiscount
    }

    def "Ao adicionar dois itens A não haverá desconto"() {
        given:
        Checkout checkout = new Checkout()

        when:
        checkout.add("A")
        checkout.add("A")

        then:
        100.0 == checkout.totalPrice
        0.0 == checkout.totalDiscount
    }

    def "Ao adicionar três itens A haverá desconto"() {
        given:
        Checkout checkout = new Checkout()

        when:
        checkout.add("A")
        checkout.add("A")
        checkout.add("A")

        then:
        130.0 == checkout.totalPrice
        20.0 == checkout.totalDiscount
    }

}