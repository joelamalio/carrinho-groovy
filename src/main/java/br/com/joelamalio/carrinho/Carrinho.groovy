package br.com.joelamalio.carrinho

/**
 *
 * @author joelamalio
 */
class Carrinho implements Serializable {
    
    private List<Item> itens
    private BigDecimal total
    
    public Carrinho() {
        this.itens = new ArrayList<Item>()
        this.total = BigDecimal.ZERO
    }
    
    public total(){
        total
    }
    
    public adicionar(item) {
        itens.add(item)
        calcularTotal()
    }
    
    public remover(item) {
        itens.remove(item)
        calcularTotal()
    }
    
    public incrementar(produto, quantidade) {
        for (Item item in itens) {
            if (item.produto.equals(produto)) {
                item.alterar(quantidade)
            }
        }
        calcularTotal()
    }
    
    public decrementar(produto, quantidade) {
        for (Item item in itens) {
            if (item.produto.equals(produto)) {
                item.alterar(-quantidade)
            }
        }
        calcularTotal()
    }
    
    public quantidadeTotal() {
        Long quantidade = 0
        for (Item item in itens) {
            quantidade += item.getQuantidade()
        }
        quantidade
    }
    
    private calcularTotal() {
        total = BigDecimal.ZERO
        for (Item item in itens) {
            total = total.add(item.total())
        }
    }
	
}

