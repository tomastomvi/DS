abstract class Funcionario {
    public abstract double calcularSalario();
}

class Gerente extends Funcionario {
    @Override
    public double calcularSalario() {
        return 8000.0;
    }
}

class Vendedor extends Funcionario {
    @Override
    public double calcularSalario() {
        return 3000.0 + 500.0; // salário base + comissão
    }
}

// Demonstração
public class exercicio4 {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();

        System.out.println("Salário do Gerente: " + gerente.calcularSalario());
        System.out.println("Salário do Vendedor: " + vendedor.calcularSalario());
    }
}