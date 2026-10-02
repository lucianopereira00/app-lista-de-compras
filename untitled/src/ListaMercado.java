
import java.util.HashMap;
import java.util.Map;

public class ListaMercado {
    private Map<String, Integer> itens = new HashMap<>();

    public void registrarPedidos(String nome) {
        itens.put(nome, itens.getOrDefault(nome, 0)+1);
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    public int getTotalPedido() {
        int total = 0;
        for(int qntd : itens.values()){
            total = total + qntd;
        }
        return total;
    }
}
