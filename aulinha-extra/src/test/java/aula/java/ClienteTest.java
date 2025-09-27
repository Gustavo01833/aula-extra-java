package aula.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testConstrutorComParametros() {
        Cliente cliente = new Cliente("Maria", "maria@email.com");
        assertEquals("Maria", cliente.getNome());
        assertEquals("maria@email.com", cliente.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEmail("joao@email.com");

        assertEquals("João", cliente.getNome());
        assertEquals("joao@email.com", cliente.getEmail());
    }

    @Test
    public void testToString() {
        Cliente cliente = new Cliente("Pedro", "pedro@email.com");
        String texto = cliente.toString();
        assertTrue(texto.contains("Pedro"));
        assertTrue(texto.contains("pedro@email.com"));
    }
}