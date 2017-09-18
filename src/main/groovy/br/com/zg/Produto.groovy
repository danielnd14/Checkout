package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
class Produto implements Comparable<Produto> {

	private String name = ""
	private double price = 0

	String getName() {
		return name
	}

	void setName(String name) {
		this.name = name
	}

	double getPrice() {
		return price
	}

	void setPrice(double price) {
		this.price = price
	}

	double getDiscount() {
		return discount
	}

	void setDiscount(double discount) {
		this.discount = discount
	}
	private double discount = 0

	Produto(String nome, Double preco) {
		this.name = nome
		this.price = preco
		this.discount = 0.0
	}


	@Override
	int compareTo(Produto o) {

		if (this.name > o.name) {
			return 1
		} else if (this.name < o.name) {
			return -1
		}

		return 0
	}
	@Override
	String toString(){
		return this.name+"_"+this.price+" Centavos"
	}
}
