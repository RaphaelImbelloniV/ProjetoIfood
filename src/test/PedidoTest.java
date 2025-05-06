package test;

import main.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeMethod
    public void setUp() {
        pedido = (Pedido) FabricaDePedidos.obterPedido("Comum");
    }

    // Pedido Aguardando Pagamento

    @Test
    public void naoDeveAguardarPagamentoQuandoJaAguardandoPagamento() {
        pedido.aguardarPagamento();
        assertFalse(pedido.aguardarPagamento());
    }

    @Test
    public void deveAprovarPedidoAguardandoPagamento() {
        pedido.aguardarPagamento();
        assertTrue(pedido.aprovar());
        assertEquals(PedidoAprovado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.aguardarPagamento();
        assertTrue(pedido.cancelar());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Aprovado

    @Test
    public void deveReceberPedidoAprovado() {
        pedido.aguardarPagamento();
        pedido.aprovar();
        assertTrue(pedido.receber());
        assertEquals(PedidoRecebido.getInstance(), pedido.getEstado());
    }

    // Pedido Recebido

    @Test
    public void devePrepararPedidoRecebido() {
        pedido.aguardarPagamento();
        pedido.aprovar();
        pedido.receber();
        assertTrue(pedido.preparando());
        assertEquals(PedidoEmPreparo.getInstance(), pedido.getEstado());
    }

    // Pedido Em Preparo

    @Test
    public void deveEntregarPedidoEmPreparo() {
        pedido.aguardarPagamento();
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        assertTrue(pedido.entregar());
        assertEquals(PedidoEmEntrega.getInstance(), pedido.getEstado());
    }

    // Pedido Em Entrega

    @Test
    public void deveMarcarPedidoComoEntregue() {
        pedido.aguardarPagamento();
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        pedido.entregar();
        assertTrue(pedido.entregue());
        assertEquals(PedidoEntregue.getInstance(), pedido.getEstado());
    }

    // Pedido Entregue

    @Test
    public void naoDeveMudarEstadoDePedidoEntregue() {
        pedido.aguardarPagamento();
        pedido.aprovar();
        pedido.receber();
        pedido.preparando();
        pedido.entregar();
        pedido.entregue();

        assertFalse(pedido.aprovar());
        assertFalse(pedido.cancelar());
        assertFalse(pedido.receber());
        assertFalse(pedido.entregar());
        assertFalse(pedido.entregue());
        assertFalse(pedido.preparando());
        assertFalse(pedido.aguardarPagamento());
        assertEquals(PedidoEntregue.getInstance(), pedido.getEstado());
    }

    // Pedido Cancelado

    @Test
    public void naoDeveMudarEstadoDePedidoCancelado() {
        pedido.aguardarPagamento();
        pedido.cancelar();

        assertFalse(pedido.aprovar());
        assertFalse(pedido.cancelar());
        assertFalse(pedido.receber());
        assertFalse(pedido.entregar());
        assertFalse(pedido.entregue());
        assertFalse(pedido.preparando());
        assertFalse(pedido.aguardarPagamento());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }
}
