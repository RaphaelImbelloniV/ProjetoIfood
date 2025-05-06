package main;

public class PedidoEntregue extends  PedidoEstado{

    private PedidoEntregue() {};
    private static PedidoEntregue instance = new PedidoEntregue();
    public static PedidoEntregue getInstance() {return  instance;}

    public String getEstado() {return "Pedido entregue";}
}
