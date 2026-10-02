import javax.swing.JOptionPane;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ListaMercado listaMercado = new ListaMercado();

        String menu = """
                1 - Adicionar produto na lista
                2 - Consultar lista de compras
                3 - Sair
                
                Escolha uma opção:""";

        while (true) {
            // Janela para pedir a opção do menu
            String entrada = JOptionPane.showInputDialog(null, menu, "Lista de Mercado", JOptionPane.QUESTION_MESSAGE);

            // Se o udser fechar a janela ou clicar em "Cancelar"
            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Sistema encerrado!");
                return;
            }

            int opc;
            try {
                opc = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida! Digite apenas números.");
                continue;
            }

            switch (opc) {
                case 1:
                    // abre a janela para o usuario diigitar o nome do produto
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto:",
                            "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);

                    if (nome != null && !nome.trim().isEmpty()) {
                        listaMercado.registrarPedidos(nome.trim());
                        // Janela de confirmação
                        JOptionPane.showMessageDialog(null, "Produto adicionado: " + nome,
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 2:
                    if (listaMercado.getItens().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A sua lista de compras está vazia!", "Lista de Compras", JOptionPane.WARNING_MESSAGE);
                    } else {
                        StringBuilder textoLista = new StringBuilder("--- LISTA DE COMPRAS ---\n\n");

                        for (Map.Entry<String, Integer> entry : listaMercado.getItens().entrySet()) {
                            textoLista.append("- ").append(entry.getKey()).append(": ")
                                    .append(entry.getValue()).append("x\n");
                        }

                        textoLista.append("\nTotal de itens: ").append(listaMercado.getTotalPedido());

                        // Janela com o relatorio completo
                        JOptionPane.showMessageDialog(null, textoLista.toString(),
                                "Lista de Compras", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Sistema encerrado!");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
                    break;
            }
        }
    }
}