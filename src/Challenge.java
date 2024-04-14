import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(666, "WhoKilledUNOwen", "John Doe", "Corrente", 12345.67);
        String divider = "-".repeat(80);
        int option = -1;
        String menu = """
                Digite o número entre parenteses ao lado da opção que gostaria de executar:
                
                (0) - Sair
                (1) - Consultar saldo
                (2) - Transferir valor
                (3) - Receber valor
                (4) - Imprimir recibo
                """;

        System.out.println(account.getResume());

        while ( option != 0 ) {
            System.out.println(menu);
            option = scanner.nextInt();
            String timestamp = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date());
            double value;
            System.out.println(divider);

            switch (option) {
                case 0:
                    // (0) - Sair
                    break;
                case 1:
                    // (1) - Consultar saldo
                    account.printCash();
                    break;
                case 2:
                    // (2) - Transferir valor
                    System.out.println(timestamp + "\nQual a quantia que quer tranferir?");
                    value = scanner.nextDouble();
                    account.sendCash(value);
                    break;
                case 3:
                    // (3) - Receber valor
                    System.out.println(timestamp + "\nQual a quantia que vai receber?");
                    value = scanner.nextDouble();
                    account.receiveCash(value);
                    break;
                case 4:
                    // (4) - Imprimir recibo
                    account.printReceipt();
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
            System.out.println(divider);
        }
    }

}
