class Forma {
    public double calcularArea() {
        return 0;
    }
}

class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

class Retangulo extends Forma {
    private double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

// Demonstração
public class exercicio2 {
    public static void main(String[] args) {
        Forma[] formas = {
            new Circulo(5),
            new Retangulo(4, 6)
        };

        for (Forma forma : formas) {
            System.out.println("Área: " + forma.calcularArea());
        }
    }
}