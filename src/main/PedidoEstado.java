package main;

public abstract class PedidoEstado{

    public abstract String getEstado();

    public boolean aguardarPagamento(Pedido pedido) {return false;}

    public boolean aprovar(Pedido pedido) {return false;}

    public boolean cancelar(Pedido pedido) {return false;}

    public boolean entregar(Pedido pedido) {return false;}

    public boolean entregue(Pedido pedido) {return false;}

    public boolean receber(Pedido pedido) {return false;}

    public boolean preparando(Pedido pedido) {return false;}
}
