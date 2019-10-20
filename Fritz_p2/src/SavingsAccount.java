public class SavingsAccount{

    private static double annualInterestRate;

    private double savingsBalance;

    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public static void modifyInterestRate(double newRate){
        annualInterestRate = (newRate * 0.01);
    }

    public double calculateMonthlyInterest(double savingsBalance){
        this.savingsBalance = savingsBalance + ((savingsBalance) * (annualInterestRate) / 12);
        return this.savingsBalance;
    }

}

class Application{

    public static void main(String args[]){
        int i;
        double balance1;
        double balance2;
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        saver1.modifyInterestRate(4);
        saver2.modifyInterestRate(4);

        balance1 = 2000;
        balance2 = 3000;
        for(i = 0; i < 12; i++){
            balance1 = saver1.calculateMonthlyInterest(balance1);
            balance2 = saver2.calculateMonthlyInterest(balance2);
            System.out.printf("Month %d :\nSaver1 balance = %.2f\n" +
                    "Saver2 balance = %.2f\n\n", i + 1, balance1, balance2);
        }

        saver1.modifyInterestRate(5);
        saver2.modifyInterestRate(5);

        balance1 = saver1.calculateMonthlyInterest(balance1);
        balance2 = saver2.calculateMonthlyInterest(balance2);
        System.out.printf("Month %d(at 5%% interest):\nSaver1 balance = %.2f\n" +
                    "Saver2 balance = %.2f\n", i + 1, balance1, balance2);



    }



}
