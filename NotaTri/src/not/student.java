package not;

public class student {
    public double nota,nota1,nota2;
    public String nome;
    public String ps;
    public double media;

    public double NotaFinal(double nota,double nota1, double nota2){
        media = nota + nota1 + nota2;
        return media;
    }
    public void finalN(){
        if (this.media >= 60.00) ps = "PASS";
        else ps = "FAILED";
    }

    @Override
    public String toString() {
        if (ps.equals("PASS")) {
            return "Nome: " + nome +
                    "\nNota: " + media +
                    "\nResultado: " + ps;
        } else {
            return "Nome: " + nome +
                    "\nNota: " + media +
                    "\nResultado: " + ps +
                    "\nFaltou " + (60.0 - media) + " pontos.";
        }
    }
}
