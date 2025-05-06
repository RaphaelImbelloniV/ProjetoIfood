package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificaClienteTest {

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = (Pedido) FabricaDePedidos.obterPedido("Comum");
    }

    @Test
    public void testAprovacaoDePedidoNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("João");
        cliente.acompanharPedido(pedido);
        pedido.aprovar();
        assertEquals("João, o status do pedido foi alterado: Aprovado", cliente.getUltimaNotificacao());
    }

    @Test
    public void testCancelamentoDePedidoNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("Maria");
        cliente.acompanharPedido(pedido);
        pedido.cancelar();
        assertEquals("Maria, o status do pedido foi alterado: Cancelado", cliente.getUltimaNotificacao());
    }

    @Test
    public void testRecebimentoDePedidoNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("Maria");
        cliente.acompanharPedido(pedido);
        pedido.aprovar();
        pedido.receber();
        assertEquals("Maria, o status do pedido foi alterado: Recebido", cliente.getUltimaNotificacao());
    }

    @Test
    public void testPreparoDePedidoNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("Carlos");
        cliente.acompanharPedido(pedido);
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        assertEquals("Carlos, o status do pedido foi alterado: Pedido Preparando", cliente.getUltimaNotificacao());
    }

    @Test
    public void testEntregaDePedidoNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("Ana");
        cliente.acompanharPedido(pedido);
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        pedido.entregar();
        assertEquals("Ana, o status do pedido foi alterado: Pedido em transito", cliente.getUltimaNotificacao());
    }

    @Test
    public void testPedidoEntregueNotificaClienteCorretamente() {
        Cliente cliente = new Cliente("Lucas");
        cliente.acompanharPedido(pedido);
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        pedido.entregar();
        pedido.entregue();
        assertEquals("Lucas, o status do pedido foi alterado: Pedido entregue", cliente.getUltimaNotificacao());
    }
}
