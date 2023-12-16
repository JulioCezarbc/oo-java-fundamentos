package entites;

public class AutoMovel {
    private String NomeMarca;
    private String NomeModelo;
    private String Placa;

    public AutoMovel(String nomeMarca, String nomeModelo, String placa) {
        NomeMarca = nomeMarca;
        NomeModelo = nomeModelo;
        Placa = placa;
    }
    public AutoMovel(){

    }

    public String getNomeMarca() {
        return NomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        NomeMarca = nomeMarca;
    }

    public String getNomeModelo() {
        return NomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        NomeModelo = nomeModelo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }
}
