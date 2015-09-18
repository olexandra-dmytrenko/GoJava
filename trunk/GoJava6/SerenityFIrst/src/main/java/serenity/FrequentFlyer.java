package serenity;

/**
 * Created by Oleksandra_Dmytrenko on 9/18/2015.
 */
public class FrequentFlyer {
    private static int totalBalance = 0;

    public FrequentFlyer(int initialBalance) {
        totalBalance = initialBalance;
    }

    public FrequentFlyer() {
        new FrequentFlyer(0);
    }

    public void flies(int distance) {
        System.out.println("I fly " + distance + ".");
    }

    public static FrequentFlyer withInitialBalanceOf(int initialBalance) {
        return new FrequentFlyer(initialBalance);
    }

    public int getBalance() {
        return totalBalance;
    }

    public Status getStatus() {
        if (totalBalance >= 0) {
            return Status.Bronze;
        } else if (totalBalance >= 10000)
            return Status.Silver;
        return null;
    }
}
