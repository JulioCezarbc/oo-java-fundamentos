package cont;

public class imp {
    public String nome;
    public String setor;
    public  double salario;
    public double salarioLiq(){
        double salarioLiq;
        if (salario >= 3500) salarioLiq = salario - 1000;
        else salarioLiq = salario - 250;
        return salarioLiq;
    }
    public double salarioBonus(){
        double bonus;
        if (salario >= 3500) bonus = salario + (salario*0.10);
        else bonus = salario + (salario*0.20);
        return bonus;
    }

    @Override
    public String toString() {
        return "Informações: " +
                "\nNome: " + nome +
                "\nSetor: " + setor +
                "\nSalario bruto: " + salario +
                "\nSalario liquido: " + salarioLiq() +
                "\nSalario com bonus: " + salarioBonus();
    }

}
