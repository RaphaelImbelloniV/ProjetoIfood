package main;

public class FabricaDePedidos {

    public static IPedido obterPedido(String tipo) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("main.Pedido" + tipo);
            objeto = classe.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de pedido inexistente.");
        }

        if (!(objeto instanceof IPedido)) {
            throw new IllegalArgumentException("Classe não implementa IPedido.");
        }

        return (IPedido) objeto;
    }
}
