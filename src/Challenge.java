public class Challenge {
    public static void main(String[] args) {
        String name = "Jonh Doe";
        String accountType = "Corrente";
        double cash = 12345.67;

        for (int i = 0; i < 40; i++) {
            System.out.print("*");
        }
        System.out.println("\nNome do cliente: " + name);
        System.out.println("Tipo da conta: " + accountType);
        System.out.println("Saldo atual: " + cash);
        for (int i = 0; i < 40; i++) {
            System.out.print("*");
        }
    }
}
