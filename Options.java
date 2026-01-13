import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Options {
    Call Call(double strikePrice, double premium, boolean buy) {
        return new Call(strikePrice, premium, buy);
    }
    Put Put(double strikePrice, double premium, boolean buy) {
        return new Put(strikePrice, premium, buy);
    }
    BuyShare BuyShare(double buyPrice, double quantity) {
        return new BuyShare(buyPrice, quantity);
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Holding> Holdings = new ArrayList<Holding>();
    private boolean shouldContinue = true;
    class PnL {
        double price;
        double profits;
        
        public PnL(double price, double profits) {
            this.price = price;
            this.profits = profits;
        }
    }
    {
        try {
            while (shouldContinue) {
                System.out.println("Enter BC to buy call, SC to sell call, BS to buy share, etc ");
                String command = br.readLine();
                if (command != null && command.equals("BC")) {
                    System.out.println("Enter strike price: ");
                    double strikePrice = Double.parseDouble(br.readLine());
                    System.out.println("Enter premium: ");
                    double premium = Double.parseDouble(br.readLine());
                    Call call = Call(strikePrice, premium, true);
                    Holdings.add(call);
                } else if (command != null && command.equals("SC")) {
                    System.out.println("Enter strike price: ");
                    double strikePrice = Double.parseDouble(br.readLine());
                    System.out.println("Enter premium: ");
                    double premium = Double.parseDouble(br.readLine());
                    Call call = Call(strikePrice, premium, false);
                    Holdings.add(call);
                } else if (command != null && command.equals("BP")) {
                    System.out.println("Enter strike price: ");
                    double buyPrice = Double.parseDouble(br.readLine());
                    System.out.println("Enter premium: ");
                    double quantity = Double.parseDouble(br.readLine());
                    Put Put = Put(buyPrice, quantity, true);
                    Holdings.add(Put);
                }
                else if (command != null && command.equals("SP")) {
                    System.out.println("Enter strike price: ");
                    double strikePrice = Double.parseDouble(br.readLine());
                    System.out.println("Enter premium: ");
                    double premium = Double.parseDouble(br.readLine());
                    Put Put = Put(strikePrice, premium, false);
                    Holdings.add(Put);
                }
                else if (command != null && command.equals("BS")) {
                    System.out.println("Enter buy price: ");
                    double buyPrice = Double.parseDouble(br.readLine());
                    System.out.println("Enter quantity: ");
                    double quantity = Double.parseDouble(br.readLine());
                    BuyShare buyShare = BuyShare(buyPrice, quantity);
                    Holdings.add(buyShare);
                }
                else if (command != null && command.equals("end")) {

                    ArrayList<PnL> PnLs = new ArrayList<PnL>();
                    System.out.println("Enter end price range start: ");
                    double endPriceStart = Double.parseDouble(br.readLine());
                    System.out.println("Enter end price range end: ");
                    double endPriceEnd = Double.parseDouble(br.readLine());
                    for (double endPrice = endPriceStart; endPrice <= endPriceEnd; endPrice += 0.25) {
                        double total = 0;
                    for (Holding holding : Holdings) {
                        total += holding.end(endPrice);
                    }
                    PnLs.add(new PnL(endPrice, total));
                }
                for (PnL pnl : PnLs) {
                    System.out.println("Price: " + pnl.price + " P&L: " + pnl.profits);
                    shouldContinue = false;
                }
            }
        }} catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}