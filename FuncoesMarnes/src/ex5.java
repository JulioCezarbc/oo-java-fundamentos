import java.util.Arrays;
import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe a quantidade de números: ");
        int n = entrada.nextInt();
        int[] numeros = new int[n];

        System.out.println("Informe os números:");

        for (int i = 0; i < n; i++) {
            numeros[i] = entrada.nextInt();
        }

        int[] numerosOrdenados = ordenarArray(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(numerosOrdenados));
    }

    public static int[] ordenarArray(int[] array) {
        int n = array.length;
        int[] arrayOrdenado = Arrays.copyOf(array, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayOrdenado[j] > arrayOrdenado[j + 1]) {
                    int temp = arrayOrdenado[j];
                    arrayOrdenado[j] = arrayOrdenado[j + 1];
                    arrayOrdenado[j + 1] = temp;
                }
            }
        }

        return arrayOrdenado;
    }
}