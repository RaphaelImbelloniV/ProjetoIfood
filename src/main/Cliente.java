package main;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanharPedido(Pedido notificar) {
        notificar.addObserver(this);
    }

    @Override
    public void update(Observable notificar, Object arg) {
        this.ultimaNotificacao = this.nome + ", o status do pedido foi alterado: " + arg;
        // System.out.println(this.ultimaNotificacao);
    }
}
