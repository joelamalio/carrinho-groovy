package br.com.joelamalio.carrinho

/**
 *
 * @author joelamalio
 */
class Item implements Serializable {
    
    def Produto produto
    def Long quantidade
    
    public Item(produto, quantidade) {
        this.produto = produto
        this.quantidade = quantidade
    }
    
    public total() {
        BigDecimal total = produto.getValor()
        total.multiply(quantidade)
    }
    
    public alterar(quantidade) {
        this.quantidade += quantidade
        if (this.quantidade < 0) {
            this.quantidade = 0
        }
    }
    
    @Override
    public String toString() {
        quantidade + " x " + produto.getNome() + "(" + produto.getId() + ")"
    }
}

