interface InstrumentoMusical {
    void tocar();
}

class Guitarra implements InstrumentoMusical {
    @Override
    public void tocar() {
        System.out.println("🎸 Guitarra tocando acordes...");
    }
}

class Piano implements InstrumentoMusical {
    @Override
    public void tocar() {
        System.out.println("🎹 Piano tocando melodias...");
    }
}

// Demonstração
public class exercicio5 {
    public static void tocarInstrumento(InstrumentoMusical instrumento) {
        instrumento.tocar();
    }

    public static void main(String[] args) {
        InstrumentoMusical guitarra = new Guitarra();
        InstrumentoMusical piano = new Piano();

        tocarInstrumento(guitarra); // 🎸 Guitarra tocando acordes...
        tocarInstrumento(piano);    // 🎹 Piano tocando melodias...
    }
}