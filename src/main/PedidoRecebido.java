package main;

public class PedidoRecebido extends PedidoEstado{

    private PedidoRecebido() {};
    private static PedidoRecebido instance = new PedidoRecebido();
    public static PedidoRecebido getInstance() {return  instance;}

    public String getEstado() {return "Recebido";}

    public boolean preparando(Pedido pedido) {
        pedido.setEstado(PedidoEmPreparo.getInstance());
        return true;
    }
}
