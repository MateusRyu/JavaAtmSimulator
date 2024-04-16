import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private final int number;
    private final String password;
    private final String owner;
    private final String accountType;
    private double cash;
    private ArrayList<String> receipt;
    private final String divider = "=".repeat(40);

    public BankAccount(int number, String password, String owner, String accountType, double cash) {
        this.number = number;
        this.password = password;
        this.owner = owner;
        this.accountType = accountType;
        this.cash = cash;
    }

    public String getResume() {
        return String.format("%s\nNúmero da conta: %d\nNome do cliente: %s\nTipo da conta: %s\nSaldo atual: %.2f\n%s\n", divider, number, owner, accountType, cash, divider);
    }

    private String getTimestamp() {
        return new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date());
    }

    private void registerAction(String action) {
        String log = String.format("\n%s\n%s\n\n%s\n", getTimestamp(), action, this.divider);
        this.receipt.add(log);
    }

    public void printCash() {
        String timeStamp = getTimestamp();
        System.out.println(timeStamp + "\nSaldo atual: " + cash);
        registerAction(String.format("Consulta de saldo: %.2f", cash));
    }

    void printReceipt() {
        System.out.println("Recibo impreso em:" + getTimestamp() + "\n\n" + getResume());
        for (String action : receipt) {
            System.out.println(action);
        }
    }

    void sendCash(double value) {
        if (cash < value) {
            System.out.println("Saldo indisponivel para a tranferencia informada!");
            registerAction(String.format("Tentativa de tranferencia maior que o saldo atual.\nSaldo atual:%.2f\nValor requisitado para tranferencia: %.2f", cash, value));
        } else {
            cash -= value;
            System.out.println("Transferencia concluida com sucesso! Saldo atual: " + cash);
            registerAction(String.format("Tranferencia efetuada no valor de %.2f.\nSaldo atual: %.2f", value, cash));
        }
    }

    void receiveCash(double value) {
        cash += value;
        System.out.println("Valor recebido com sucesso! Saldo atual: " + cash);
        registerAction(String.format("Tranferencia recebida no valor de %.2f.\nSaldo atual: %.2f", value, cash));
    }
}
