package main;

public class PedidoCancelado extends PedidoEstado{

    private PedidoCancelado() {};
    private static PedidoCancelado instance = new PedidoCancelado();
    public static PedidoCancelado getInstance() {return  instance;}

    public String getEstado() {return "Cancelado";}
}
