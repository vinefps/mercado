import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Criação Categorias:
        Categoria ips = new Categoria("Painel Ips");
        Categoria va = new Categoria("Painel va");
        Categoria tn = new Categoria("Painel tn");

        //Criação Produtos:
        Produto monitor1 = new Produto("dell-ips", 500, "24 polegadas", 10, ips);
        Produto monitor2 = new Produto("dell-va", 1000, "24 polegadas", 10, va);
        Produto monitor3 = new Produto("dell-tn", 1500, "24 polegadas", 10, tn);
        Produto monitor4 = new Produto("dell-ips-2", 2000, "24 polegadas", 10, ips);
        Produto monitor5 = new Produto("dell-va-2", 2500, "24 polegadas", 10, va);

        //Lista dos produtos:
        ArrayList<Produto> listaMonitores = new ArrayList<>();

        listaMonitores.add(monitor1);
        listaMonitores.add(monitor2);
        listaMonitores.add(monitor3);
        listaMonitores.add(monitor4);
        listaMonitores.add(monitor5);

        //---------------------------------------------------
        Date hAtual = new Date();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        //PEDIDO 1:

        Pedido pedido1 = new Pedido(1, hAtual, 0, 1);
        PedidoItem item1 = new PedidoItem("dell-ips", 1, monitor1.getPrecoProduto());
        PedidoItem item2 = new PedidoItem("dell-va", 1, monitor2.getPrecoProduto());
        PedidoItem item3 = new PedidoItem("dell-va-2", 1, monitor5.getPrecoProduto());

        if (validarEInserirItem(item1, listaMonitores, pedido1) &&
                validarEInserirItem(item2, listaMonitores, pedido1) &&
                validarEInserirItem(item3, listaMonitores, pedido1)) {
            listaPedidos.add(pedido1);
            System.out.println("Pedido 1 inserido com sucesso.");
            // Calculando e exibindo o valor total a pagar para o Pedido 1
            pedido1.setPrecoTotal(pedido1.calculaTotalPagar());
            System.out.println("Valor Total a Pagar para Pedido 1: " + pedido1.getPrecoTotal());
        } else {
            System.out.println("Erro ao inserir Pedido 1.");
        }

        //PEDIDO 2:

        Pedido pedido2 = new Pedido(2, hAtual, 0, 1);
        PedidoItem item4 = new PedidoItem("dell-ips", 2, monitor1.getPrecoProduto());
        PedidoItem item5 = new PedidoItem("dell-va", 2, monitor2.getPrecoProduto());
        PedidoItem item6 = new PedidoItem("dell-va-2", 2, monitor5.getPrecoProduto());

        if (validarEInserirItem(item4, listaMonitores, pedido2) &&
                validarEInserirItem(item5, listaMonitores, pedido2) &&
                validarEInserirItem(item6, listaMonitores, pedido2)) {
            listaPedidos.add(pedido2);
            System.out.println("Pedido 2 inserido com sucesso.");
            // Calculando e exibindo o valor total a pagar para o Pedido 2
            pedido2.setPrecoTotal(pedido2.calculaTotalPagar());
            System.out.println("Valor Total a Pagar para Pedido 2: " + pedido2.getPrecoTotal());
        } else {
            System.out.println("Erro ao inserir Pedido 2.");
        }
    }

    private static boolean validarEInserirItem(PedidoItem item, ArrayList<Produto> listaMonitores, Pedido pedido) {
        for (Produto monitor : listaMonitores) {
            if (monitor.getNomeProduto().equals(item.getNomeItem())) {
                if (monitor.getEstoqueAtual() >= item.getQtdeItem()) {
                    // Item e estoque válidos, adicionando ao pedido
                    PedidoItem novoItem = new PedidoItem(item.getNomeItem(), item.getQtdeItem(), monitor.getPrecoProduto());
                    pedido.inserirItensPedido(novoItem);

                    // Atualizando estoque
                    monitor.setEstoqueAtual(monitor.getEstoqueAtual() - item.getQtdeItem());

                    // Atualizando status do pedido para 2
                    pedido.alterarStatus(2);

                    return true;
                } else {
                    System.out.println("Estoque insuficiente para o item: " + item.getNomeItem());
                    return false;
                }
            }
        }

        System.out.println("Produto não encontrado para o item: " + item.getNomeItem());
        return false;
    }
}
