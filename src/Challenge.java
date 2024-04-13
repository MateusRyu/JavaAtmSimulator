import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "John Doe";
        String accountType = "Corrente";
        double cash = 12345.67;
        int option = -1;
        String menu = """
                Digite o número entre parenteses ao lado da opção que gostaria de executar:
                
                (0) - Sair
                (1) - Consultar saldo
                (2) - Transferir valor
                (3) - Receber valor
                (4) - Imprimir recibo
                """;
        String divider = "*".repeat(40);

        System.out.println(divider);
        System.out.println("Nome do cliente: " + name);
        System.out.println("Tipo da conta: " + accountType);
        System.out.println("Saldo atual: " + cash);
        System.out.println(divider);

        while ( option != 0 ) {
            System.out.println(menu);
            option = scanner.nextInt();
        }
    }
}
