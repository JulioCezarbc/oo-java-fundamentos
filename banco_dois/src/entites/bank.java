package entites;

import java.util.Random;
import java.time.LocalDate;


public class bank {
    private int numeroConta;
    private String nome;
    private LocalDate dataNascimento;

    private double valorInicial;
    private double saldo;


    public bank(String nome, LocalDate dataNascimento, double valorInicial) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        deposito(valorInicial);
        this.numeroConta = gerarNumeroConta();
    }

    public bank(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    private int gerarNumeroConta() {
        int limiteInferior = 0;
        int limiteSuperior = 1000;
        Random random = new Random();
        return random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }

    public void deposito(double dep){
        saldo += dep;
    }
    public void saque (double saq){
        double taxa = 5.0;
        saldo -= (saq +taxa);
    }

    private int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getYear();

        if (dataNascimento.getDayOfYear() > dataAtual.getDayOfYear()) {
            idade--;
        }
        return idade;
    }
    public String toString() {
        return "\nNome: " + getNome() +
                "\nIdade: " + calcularIdade() +
                "\nNumero da conta: " + getNumeroConta() +
                "\nSaldo: " + getSaldo();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public double getSaldo() {
        return saldo;
    }

}
