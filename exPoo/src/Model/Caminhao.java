package Model;

public class Caminhao extends AutoMovel {
    private double carga;

    public Caminhao(String nomeMarca, String nomeModelo, String placa, double carga) {
        super(nomeMarca, nomeModelo, placa);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
}
