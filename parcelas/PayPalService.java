package projeto.parcelas;

public class PayPalService implements OnlinePaymentService{

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(double amount, int mounths) {
        return amount * 0.01 * mounths;
    }
}
