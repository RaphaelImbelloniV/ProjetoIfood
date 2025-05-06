package main;

public class PedidoAguardandoPagamento extends PedidoEstado{

    private PedidoAguardandoPagamento() {};
    private static PedidoAguardandoPagamento instance = new PedidoAguardandoPagamento();
    public static PedidoAguardandoPagamento getInstance() {return instance;}

    public String getEstado() {return "AguardandoPagamento";}

    public boolean aprovar(Pedido pedido) {
        pedido.setEstado(PedidoAprovado.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoCancelado.getInstance());
        return true;
    }
}
