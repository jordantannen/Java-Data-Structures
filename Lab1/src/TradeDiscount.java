import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

// Programmer: Jordan Tannenbaum
public class TradeDiscount {
    public static void main(String[] args) {
        // Create scanner object and take user input
        Scanner input = new Scanner(System.in);

        System.out.print("Name of Program User: ");
        String userName = input.nextLine();

        System.out.print("Item Description: ");
        String itemDescription = input.nextLine();

        System.out.print("The List Price: ");
        double listPrice = input.nextDouble();

        System.out.print("Discount Rate: ");
        double discountRate = input.nextDouble();

        // This extra nextLine() is because the nextDouble() does not read the newline character
        input.nextLine();
        System.out.print("Salesperson Name: ");
        String salesPerson = input.nextLine();

        // Set variables for tax, shipping fee, and commission. Make necessary calculations
        // Setting the variable here makes it easier to adjust if needed than if it were done in print statements
        double salesTax = .06075;
        int shippingFee = 75;
        double commission = .2;
        double tradeDiscountAmount = listPrice * discountRate;
        double netPrice = listPrice - tradeDiscountAmount;
        double totalPrice = netPrice + (netPrice * salesTax) + shippingFee;
        double commissionAmount = commission * netPrice;

        // declare an object that will display two decimal digits
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        // Create Calendar object
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date nextWeek = cal.getTime();

        // declare an object that will display the current date
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
        System.out.println();
        System.out.println("Today's Date is: " + dtToday.format(myDate) +
                ". The trade discount expires on " + dtToday.format(nextWeek) + ".");

        // Produce output
        System.out.println(" Username: " + userName);
        System.out.println(" Item Description: " + itemDescription);
        System.out.println(" List Price: " + nf.format(listPrice));
        System.out.println(" Discount Rate: " + discountRate);
        System.out.println(" Trade Discount Amount: " + nf.format(tradeDiscountAmount));
        System.out.println(" Net Price Amount: " + nf.format(netPrice));
        System.out.println(" Sales Tax: " + salesTax * 100 + "%");
        System.out.println(" Total Amount of Purchase: " + nf.format(totalPrice));
        System.out.println(" Commission Amount: " + nf.format(commissionAmount));
        System.out.println(" Salesperson Name: " + salesPerson);

    }
}