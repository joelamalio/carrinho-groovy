package br.com.joelamalio.carrinho

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 *
 * @author joelamalio
 */
@RunWith(JUnit4.class)
class CarrinhoTest {
	
    
    @Test
    void quandoInicializarOCarrinhoDeveRetornarOTotalIgualAZero() {
        Carrinho carrinho = new Carrinho()
        Assert.assertEquals(0, carrinho.total(), 0)
    }
    
    @Test
    void quandoInicializarOCarrinhoDeveRetornarAQuantidadeTotalIgualAZero() {
        Carrinho carrinho = new Carrinho()
        Assert.assertEquals(0, carrinho.quantidadeTotal())
    }
    
    @Test
    void quandoAdicionar1FogaoAoCarrinhoDeveRetornarOTotalIgualA600() {
        Carrinho carrinho = new Carrinho()
        carrinho.adicionar(new Item(catalogo(100L), 1))
        Assert.assertEquals(600.00, carrinho.total(), 0)
    }
    
    @Test
    void quandoAdicionar3FogoesAoCarrinhoDeveRetornarOTotalIgualA1800() {
        Carrinho carrinho = new Carrinho()
        carrinho.adicionar(new Item(catalogo(100L), 3))
        Assert.assertEquals(1800.00, carrinho.total(), 0)
    }
    
    @Test
    void quandoAdicionar1Fogao1Ventilador1Notebook1CamaBoxAoCarrinhoDeveRetornarOTotalIgualA3020() {
        Carrinho carrinho = new Carrinho()
        carrinho.adicionar(new Item(catalogo(100L), 1))
        carrinho.adicionar(new Item(catalogo(200L), 1))
        carrinho.adicionar(new Item(catalogo(300L), 1))
        carrinho.adicionar(new Item(catalogo(400L), 1))
        Assert.assertEquals(3020, carrinho.total(), 0)
    }
    
    @Test
    void quandoAdicionar1FogaoAoCarrinhoDeveRetornarAQuantidadeTotalIgualA1() {
        Carrinho carrinho = new Carrinho()
        carrinho.adicionar(new Item(catalogo(100L), 1))
        Assert.assertEquals(1, carrinho.quantidadeTotal())
    }
    
    @Test
    void quandoAdicionar1VentiladorE2CamasAoCarrinhoDeveRetornarAQuantidadeTotalIgualA3() {
        Carrinho carrinho = new Carrinho()
        carrinho.adicionar(new Item(catalogo(200L), 1))
        carrinho.adicionar(new Item(catalogo(400L), 2))
        Assert.assertEquals(3, carrinho.quantidadeTotal())
    }
    
    @Test
    void quandoAdicionar1VentiladorEDepoisRemove_loDeveRetornarAQuantidadeTotalIgualAZero() {
        Carrinho carrinho = new Carrinho()
        Item ventilador = new Item(catalogo(200L), 1)
        carrinho.adicionar(ventilador)
        Assert.assertEquals(1, carrinho.quantidadeTotal())
        carrinho.remover(ventilador)
        Assert.assertEquals(0, carrinho.quantidadeTotal())
    }
    
    @Test
    void quandoAdicionar1NotebookAoCarrinhoEDepoisIncrementa_loEm4DeveRetornarAQuantidadeTotalIgualA5() {
        Carrinho carrinho = new Carrinho()
        Produto notebook = catalogo(300L)
        carrinho.adicionar(new Item(notebook, 1))
        Assert.assertEquals(1, carrinho.quantidadeTotal())
        carrinho.incrementar(notebook, 4)
        Assert.assertEquals(5, carrinho.quantidadeTotal())
    }
    
    @Test
    void quandoAdicionar10NotebooksAoCarrinhoEDepoisDecrementa_loEm2DeveRetornarAQuantidadeTotalIgualA8() {
        Carrinho carrinho = new Carrinho()
        Produto notebook = catalogo(300L)
        carrinho.adicionar(new Item(notebook, 10))
        Assert.assertEquals(10, carrinho.quantidadeTotal())
        carrinho.decrementar(notebook, 2)
        Assert.assertEquals(8, carrinho.quantidadeTotal())
    }
    
    private Produto catalogo(Long id) {
        Map<Long, Produto> catalogo = new HashMap<Long, Produto>()
        catalogo.put(100L, new Produto(100, "FOGAO", 600.00))
        catalogo.put(200L, new Produto(200, "VENTILADOR", 120.00))
        catalogo.put(300L, new Produto(300, "NOTEBOOK", 1500.00))
        catalogo.put(400L, new Produto(400, "CAMA BOX", 800.00))
        return catalogo.get(id)
    }
}

