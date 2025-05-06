package main;

public class PedidoAprovado extends PedidoEstado{

    private PedidoAprovado() {};
    private static PedidoAprovado instance = new PedidoAprovado();
    public static PedidoAprovado getInstance() {return  instance;}

    public String getEstado() {return "Aprovado";}

    public boolean receber(Pedido pedido) {
        pedido.setEstado(PedidoRecebido.getInstance());
        return true;
    }
}
