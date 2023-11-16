package projeto.parcelas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número: ");
        int number = leitor.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(leitor.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = leitor.nextDouble();

        System.out.print("Entre com o número de parcelas: ");
        int n = leitor.nextInt();
        Contract obj = new Contract(number,date,totalValue);
        ContractService contractService = new ContractService(new PayPalService());
        contractService.processContract(obj,n);


        System.out.println("Parcelas");
        for (Installment installment : obj.getInstallments()){
            System.out.println(installment);
        }
        leitor.close();
    }
}
