package main;

public class PedidoEmEntrega extends PedidoEstado{

    private PedidoEmEntrega() {};
    private static PedidoEmEntrega instance = new PedidoEmEntrega();
    public static PedidoEmEntrega getInstance() {return  instance;}

    public String getEstado() {return "Pedido em transito";}

    public boolean entregue(Pedido pedido) {
        pedido.setEstado(PedidoEntregue.getInstance());
        return true;
    }
}
