import java.util.Scanner;

/**
 * Classe principal que demonstra o uso do enum StatusPedido
 * Simula um sistema simples de gerenciamento de pedidos
 */
public class SistemaPedidos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE PEDIDOS ===\n");
        
        // Demonstração 1: Iterando sobre todos os valores do enum
        System.out.println("1. TODOS OS STATUS DISPONÍVEIS:");
        System.out.println("--------------------------------");
        for (StatusPedido status : StatusPedido.values()) {
            System.out.printf("- %s: %s%n", status.name(), status.getDescricao());
        }
        
        // Demonstração 2: Trabalhando com um pedido específico
        System.out.println("\n2. SIMULAÇÃO DE FLUXO DE PEDIDO:");
        System.out.println("--------------------------------");
        
        StatusPedido pedidoAtual = StatusPedido.NOVO;
        System.out.println("Status inicial do pedido: " + pedidoAtual);
        System.out.println("Descrição: " + pedidoAtual.getDescricao());
        System.out.println("Pode cancelar? " + pedidoAtual.podeCancelar());
        
        // Simula avanço no status
        System.out.println("\n--- Avançando para próximo status ---");
        pedidoAtual = pedidoAtual.proximoStatus();
        System.out.println("Novo status: " + pedidoAtual);
        System.out.println("Descrição: " + pedidoAtual.getDescricao());
        System.out.println("Pode cancelar? " + pedidoAtual.podeCancelar());
        
        // Demonstração 3: Uso de métodos estáticos do enum
        System.out.println("\n3. MÉTODOS ESTÁTICOS DO ENUM:");
        System.out.println("--------------------------------");
        
        System.out.println("Status ativos no sistema:");
        for (StatusPedido statusAtivo : StatusPedido.getStatusAtivos()) {
            System.out.println("- " + statusAtivo.name());
        }
        
        // Demonstração 4: Busca por nome
        System.out.println("\n4. BUSCA DE STATUS POR NOME:");
        System.out.println("--------------------------------");
        try {
            StatusPedido statusBusca = StatusPedido.fromString("entregue");
            System.out.println("Status encontrado: " + statusBusca);
            System.out.println("Descrição: " + statusBusca.getDescricao());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Demonstração 5: Uso em switch (funcionalidade muito comum)
        System.out.println("\n5. USO DO ENUM EM SWITCH:");
        System.out.println("--------------------------------");
        
        StatusPedido[] fluxoTeste = {StatusPedido.NOVO, StatusPedido.PROCESSANDO, 
                                   StatusPedido.ENTREGUE, StatusPedido.CANCELADO};
        
        for (StatusPedido status : fluxoTeste) {
            System.out.printf("Status: %s - ", status);
            
            switch (status) {
                case NOVO:
                    System.out.println("Ação: Iniciar processamento");
                    break;
                case PROCESSANDO:
                    System.out.println("Ação: Preparar para envio");
                    break;
                case ENTREGUE:
                    System.out.println("Ação: Finalizar pedido");
                    break;
                case CANCELADO:
                    System.out.println("Ação: Registrar motivo do cancelamento");
                    break;
                default:
                    System.out.println("Ação: Status desconhecido");
            }
        }
        
        // Demonstração 6: Interação com usuário
        System.out.println("\n6. INTERAÇÃO COM USUÁRIO:");
        System.out.println("--------------------------------");
        
        System.out.print("Digite um status (NOVO, PROCESSANDO, ENTREGUE, CANCELADO): ");
        String inputUsuario = scanner.nextLine();
        
        try {
            StatusPedido statusUsuario = StatusPedido.fromString(inputUsuario);
            System.out.println("\n=== INFORMAÇÕES DO STATUS ===");
            System.out.println("Nome: " + statusUsuario.name());
            System.out.println("Ordem: " + (statusUsuario.ordinal() + 1));
            System.out.println("Descrição: " + statusUsuario.getDescricao());
            System.out.println("Pode cancelar: " + statusUsuario.podeCancelar());
            
            StatusPedido proximo = statusUsuario.proximoStatus();
            if (proximo != statusUsuario) {
                System.out.println("Próximo status: " + proximo);
            } else {
                System.out.println("Este é um status final");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Status válidos são: NOVO, PROCESSANDO, ENTREGUE, CANCELADO");
        }
        
        scanner.close();
        
        System.out.println("\n=== DEMONSTRAÇÃO CONCLUÍDA ===");
    }
}