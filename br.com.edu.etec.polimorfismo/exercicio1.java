class Animal {
    public void fazerSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Au Au!");
    }
}

class Gato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Miau!");
    }
}

// Demonstração
public class exercicio1 {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        cachorro.fazerSom(); // Au Au!
        gato.fazerSom();     // Miau!
    }
}