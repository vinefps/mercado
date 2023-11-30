public class PedidoItem {
    private String nomeItem;
    private int qtdeItem;
    private double precoItem;

    // Construtor
    public PedidoItem(String nomeItem, int qtdeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.qtdeItem = qtdeItem;
        this.precoItem = precoItem;
    }

    // Métodos getters e setters
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQtdeItem() {
        return qtdeItem;
    }

    public void setQtdeItem(int qtdeItem) {
        this.qtdeItem = qtdeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    // Método para atualizar estoque do item
    public boolean atualizaEstoqueItem() {
        // Lógica para atualizar o estoque do produto correspondente ao item
        // Retornar true se a atualização for bem-sucedida, false caso contrário
        return true;
    }
}