/**
 * Enum que representa os possíveis status de um pedido em um sistema de e-commerce
 * Demonstra o uso de enum com métodos, campos e construtor personalizado
 */
public enum StatusPedido {
    
    // Valores do enum com descrições personalizadas
    NOVO("Pedido recebido, aguardando processamento") {
        @Override
        public boolean podeCancelar() {
            return true;
        }
        
        @Override
        public StatusPedido proximoStatus() {
            return PROCESSANDO;
        }
    },
    
    PROCESSANDO("Pedido em processamento no estoque") {
        @Override
        public boolean podeCancelar() {
            return true;
        }
        
        @Override
        public StatusPedido proximoStatus() {
            return ENTREGUE;
        }
    },
    
    ENTREGUE("Pedido entregue ao cliente") {
        @Override
        public boolean podeCancelar() {
            return false;
        }
        
        @Override
        public StatusPedido proximoStatus() {
            return this; // Último status, não avança
        }
    },
    
    CANCELADO("Pedido cancelado") {
        @Override
        public boolean podeCancelar() {
            return false;
        }
        
        @Override
        public StatusPedido proximoStatus() {
            return this; // Status final
        }
    };
    
    // Campo do enum
    private final String descricao;
    
    /**
     * Construtor do enum
     * @param descricao Descrição detalhada do status
     */
    private StatusPedido(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Retorna a descrição do status
     * @return String com a descrição
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Método abstrato que verifica se o pedido pode ser cancelado
     * Cada valor do enum implementa sua própria lógica
     * @return true se pode ser cancelado, false caso contrário
     */
    public abstract boolean podeCancelar();
    
    /**
     * Método abstrato que retorna o próximo status válido
     * @return Próximo status na sequência
     */
    public abstract StatusPedido proximoStatus();
    
    /**
     * Método estático para buscar enum por nome
     * @param nome Nome do status
     * @return StatusPedido correspondente
     * @throws IllegalArgumentException se nome não existir
     */
    public static StatusPedido fromString(String nome) {
        for (StatusPedido status : values()) {
            if (status.name().equalsIgnoreCase(nome)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + nome);
    }
    
    /**
     * Método que retorna todos os status ativos (não cancelados)
     * @return Array com status ativos
     */
    public static StatusPedido[] getStatusAtivos() {
        return new StatusPedido[]{NOVO, PROCESSANDO, ENTREGUE};
    }
}