class Veiculo {
    public void mover() {
        System.out.println("Veículo se movendo");
    }
}

class Carro extends Veiculo {
    @Override
    public void mover() {
        System.out.println("Carro andando na estrada");
    }
}

class Bicicleta extends Veiculo {
    @Override
    public void mover() {
        System.out.println("Bicicleta pedalando na ciclovia");
    }
}

// Método que demonstra polimorfismo
public class exercicio3 {
    public static void moverVeiculo(Veiculo veiculo) {
        veiculo.mover();
    }

    public static void main(String[] args) {
        Veiculo carro = new Carro();
        Veiculo bike = new Bicicleta();

        moverVeiculo(carro); // Carro andando na estrada
        moverVeiculo(bike);  // Bicicleta pedalando na ciclovia
    }
}