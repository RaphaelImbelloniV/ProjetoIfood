package main;

import java.util.Observable;

public class Pedido extends Observable implements IPedido {

    private String nome;
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoAguardandoPagamento.getInstance();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean aprovar() {
        boolean resultado = estado.aprovar(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean cancelar() {
        boolean resultado = estado.cancelar(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean receber() {
        boolean resultado = estado.receber(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean preparando() {
        boolean resultado = estado.preparando(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean entregar() {
        boolean resultado = estado.entregar(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean entregue() {
        boolean resultado = estado.entregue(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    public boolean aguardarPagamento() {
        boolean resultado = estado.aguardarPagamento(this);
        if (resultado) notificarAlteracao();
        return resultado;
    }

    private void notificarAlteracao() {
        setChanged();
        notifyObservers(estado.getEstado());
    }
}
