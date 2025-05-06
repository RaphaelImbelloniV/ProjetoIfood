package main;

public class PedidoEmPreparo extends PedidoEstado{

    private PedidoEmPreparo() {};
    private static PedidoEmPreparo instance = new PedidoEmPreparo();
    public static PedidoEmPreparo getInstance() {return  instance;}

    public String getEstado() {return "Pedido Preparando";}

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEmEntrega.getInstance());
        return true;
    }
}
