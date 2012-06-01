package br.com.joelamalio.carrinho

/**
 *
 * @author joelamalio
 */
class Produto implements Serializable {
    
    def Long id
    def String nome
    def BigDecimal valor
    
    public Produto(id, nome, valor) {
        this.id = id
        this.nome = nome
        this.valor = valor
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
	
}

