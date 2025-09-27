package aula.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testConstrutorComParametros() {
        Produto produto = new Produto("Notebook", 3500.0);
        assertEquals("Notebook", produto.getNome());
        assertEquals(3500.0, produto.getPreco());
    }

    @Test
    public void testSettersAndGetters() {
        Produto produto = new Produto();
        produto.setNome("Celular");
        produto.setPreco(2500.0);

        assertEquals("Celular", produto.getNome());
        assertEquals(2500.0, produto.getPreco());
    }

    @Test
    public void testToString() {
        Produto produto = new Produto("Mouse", 150.0);
        String texto = produto.toString();
        assertTrue(texto.contains("Mouse"));
        assertTrue(texto.contains("150.0"));
    }
}