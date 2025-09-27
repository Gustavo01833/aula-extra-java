package aula.java;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testAdicionarProduto() {
        Cliente cliente = new Cliente("Ana", "ana@email.com");
        Pedido pedido = new Pedido(cliente);
        Produto produto = new Produto("Camiseta", 80.0);

        pedido.adicionarProduto(produto);

        assertEquals(1, pedido.getProdutos().size());
        assertEquals("Camiseta", pedido.getProdutos().get(0).getNome());
    }

    @Test
    public void testRemoverProduto() {
        Cliente cliente = new Cliente("Carlos", "carlos@email.com");
        Pedido pedido = new Pedido(cliente);
        Produto produto = new Produto("Tênis", 200.0);

        pedido.adicionarProduto(produto);
        pedido.removerProduto(produto);

        assertTrue(pedido.getProdutos().isEmpty());
    }

    @Test
    public void testCalcularTotal() {
        Cliente cliente = new Cliente("Fernanda", "fernanda@email.com");
        Pedido pedido = new Pedido(cliente);

        pedido.adicionarProduto(new Produto("Livro", 50.0));
        pedido.adicionarProduto(new Produto("Caneta", 5.0));

        assertEquals(55.0, pedido.calcularTotal());
    }

    @Test
    public void testExibirPedidosEntreHoras() {
        Cliente cliente = new Cliente("Lucas", "lucas@email.com");
        Pedido pedido1 = new Pedido(cliente);
        Pedido pedido2 = new Pedido(cliente);

        LocalDateTime agora = LocalDateTime.now();
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        List<Pedido> resultado = pedido1.exibirPedidosEntreHoras(
                pedidos,
                agora.minusHours(1),
                agora.plusHours(1)
        );

        assertEquals(2, resultado.size());
    }

    @Test
    public void testExibirPedidosPorDia() {
        Cliente cliente = new Cliente("Paula", "paula@email.com");
        Pedido pedido = new Pedido(cliente);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);

        int diaSemana = pedido.getDataHoraPedido().getDayOfWeek().getValue();

        List<Pedido> resultado = pedido.exibirPedidosPorDia(pedidos, diaSemana);

        assertEquals(1, resultado.size());
    }

    @Test
    public void testToString() {
        Cliente cliente = new Cliente("Marcos", "marcos@email.com");
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new Produto("Copo", 10.0));

        String texto = pedido.toString();
        assertTrue(texto.contains("Marcos"));
        assertTrue(texto.contains("Copo"));
        assertTrue(texto.contains("10.0"));
    }
}
