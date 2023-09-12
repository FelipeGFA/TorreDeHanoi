import java.util.Scanner;

public class TorreDeHanoi {

    private static int contMovimentos = 0;

    private static void mover(int n, int origem, int destino) {
        System.out.println("Mova o disco " + n + " de " + origem + " para " + destino);
        contMovimentos++;
    }

    static void hanoi(int n, int origem, int destino, int trabalho) {
        if (n > 0) {
            hanoi(n - 1, origem, trabalho, destino);
            mover(n, origem, destino);
            hanoi(n - 1, trabalho, destino, origem);
        }
    }

    public static void resolverTorreDeHanoi(int n) {
        hanoi(n, 1, 3, 2);
    }

    public static void main(String[] args) {
        int n;

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Digite o número de discos: ");
            n = entrada.nextInt();
        }
        // Começa a medição do tempo
        long startTime = System.currentTimeMillis();

        TorreDeHanoi.resolverTorreDeHanoi(n);

        // Finaliza a medição do tempo
        long Cronometro = System.currentTimeMillis() - startTime;

        // Converte o tempo para horas, minutos, segundos e milissegundos
        long hours = Cronometro / (60 * 60 * 1000);
        Cronometro %= (60 * 60 * 1000);

        long minutes = Cronometro / (60 * 1000);
        Cronometro %= (60 * 1000);

        long seconds = Cronometro / 1000;
        Cronometro %= 1000;
        long milliseconds = Cronometro;
        
        // imprime o número de movimentos e o tempo de execução
        System.out.println("Total de movimentos: " + contMovimentos);
        System.out.printf("Tempo de execução: %02d:%02d:%02d:%04d\n", hours, minutes, seconds, milliseconds);
    }
}