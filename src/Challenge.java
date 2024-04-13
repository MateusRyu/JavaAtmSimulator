import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "John Doe";
        String accountType = "Corrente";
        double cash = 12345.67;
        double value;
        String divider = "*".repeat(40);
        StringBuilder receipt = new StringBuilder(String.format("%s\nNome do cliente: %s\nTipo da conta: %s\nSaldo atual: %.2f\n%s", divider, name, accountType, cash, divider));
        int option = -1;
        String menu = """
                Digite o número entre parenteses ao lado da opção que gostaria de executar:
                
                (0) - Sair
                (1) - Consultar saldo
                (2) - Transferir valor
                (3) - Receber valor
                (4) - Imprimir recibo
                """;
        String timeStamp;

        System.out.println(receipt);

        while ( option != 0 ) {
            System.out.println(menu);
            option = scanner.nextInt();
            timeStamp = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date());
            System.out.println(divider);

            switch (option) {
                case 0:
                    // (0) - Sair
                    break;
                case 1:
                    // (1) - Consultar saldo
                    System.out.println(timeStamp + "\nSaldo atual: " + cash);
                    receipt.append(String.format("\n%s\nConsulta de saldo: %.2f\n%s\n", timeStamp, cash, divider));
                    break;
                case 2:
                    // (2) - Transferir valor
                    System.out.println(timeStamp + "\nQual a quantia que quer tranferir? (saldo atual: " + cash + ")");
                    value = scanner.nextDouble();
                    if (cash < value) {
                        System.out.println("Saldo indisponivel para a tranferencia informada!");
                        receipt.append(String.format("\n%s\nTentativa de tranferencia maior que o saldo atual.\nSaldo atual:%.2f\nValor requisitado para tranferencia: %.2f\n%s\n", timeStamp, cash, value, divider));
                    } else {
                        cash -= value;
                        System.out.println("Transferencia concluida com sucesso! Saldo atual: " + cash);
                        receipt.append(String.format("\n%s\nTranferencia efetuada no valor de %.2f.\nSaldo atual: %.2f\n\n%s", timeStamp, value, cash, divider));
                    }
                    break;
                case 3:
                    // (3) - Receber valor
                    System.out.println(timeStamp + "\nQual a quantia que vai receber?");
                    value = scanner.nextDouble();
                    cash += value;
                    System.out.println("Valor recebido com sucesso! Saldo atual: " + cash);
                    receipt.append(String.format("\n%s\nTranferencia recebida no valor de %.2f.\nSaldo atual: %.2f\n\n%s\n", timeStamp, value, cash, divider));
                    break;
                case 4:
                    // (4) - Imprimir recibo
                    System.out.println("Recibo impreso em:" + timeStamp + "\n\n" + receipt);
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
            System.out.println(divider);
        }
    }

}
