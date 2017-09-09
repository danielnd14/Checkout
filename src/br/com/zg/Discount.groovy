package br.com.zg

/**
 * Created by daniel on 09/09/17.
 */
interface Discount {
    void setDiscount(Produto produto, double disconto, int quantidade)
    void updateDiscount(Produto produto, double disconto,int quantidade)
    void removeDiscount(Produto produto)

}