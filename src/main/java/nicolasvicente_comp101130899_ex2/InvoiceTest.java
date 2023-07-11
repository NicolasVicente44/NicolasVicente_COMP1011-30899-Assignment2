package nicolasvicente_comp101130899_ex2;

import nicolasvicente_comp101130899_ex2.Invoice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceTest {
    public static void main(String[] args) {
        // Create an array of Invoice objects with the sample data
        Invoice[] invoices = {
                new Invoice("87", "Electric Sander", 7, 57.98),
                new Invoice("24", "Power Saw", 18, 99.99),
                new Invoice("7", "Sledge Hammer", 11, 21.50),
                new Invoice("77", "Hammer", 76, 11.99),
                new Invoice("39", "Lawn Mower", 3, 79.50),
                new Invoice("68", "Screw Driver", 106, 6.99),
                new Invoice("56", "Jig Saw", 21, 11.00)
        };

        // a) Sort the Invoice objects by partDescription and display the results
        List<Invoice> sortedByPartDescription = Arrays.stream(invoices)
                .sorted((i1, i2) -> i1.getPartDescription().compareTo(i2.getPartDescription()))
                .collect(Collectors.toList());
        System.out.println("Sorted by Part Description:");
        sortedByPartDescription.forEach(System.out::println);

        // b) Sort the Invoice objects by pricePerItem and display the results
        List<Invoice> sortedByPricePerItem = Arrays.stream(invoices)
                .sorted((i1, i2) -> Double.compare(i1.getPricePerItem(), i2.getPricePerItem()))
                .collect(Collectors.toList());
        System.out.println("\nSorted by Price Per Item:");
        sortedByPricePerItem.forEach(System.out::println);

        // c) Map each Invoice to partDescription and quantity, sort by quantity, and display the results
        List<String> sortedByQuantity = Arrays.stream(invoices)
                .map(i -> i.getPartDescription() + " (Quantity: " + i.getQuantity() + ")")
                .sorted(Comparator.comparingInt(i -> Integer.parseInt(i.split("Quantity: ")[1].replace(")", ""))))
                .collect(Collectors.toList());
        System.out.println("\nSorted by Quantity:");
        sortedByQuantity.forEach(System.out::println);


        // d) Map each Invoice to partDescription and value, order by Invoice value, and display the results
        List<String> sortedByInvoiceValue = Arrays.stream(invoices)
                .map(i -> i.getPartDescription() + " (Value: " + i.getQuantity() * i.getPricePerItem() + ")")
                .sorted((s1, s2) -> Double.compare(
                        Double.parseDouble(s1.split("Value: ")[1].replace(")", "")),
                        Double.parseDouble(s2.split("Value: ")[1].replace(")", ""))
                ))
                .collect(Collectors.toList());
        System.out.println("\nSorted by Invoice Value:");
        sortedByInvoiceValue.forEach(System.out::println);

        // e) Select invoice values in the range $200 to $500
        List<String> invoiceValuesInRange = Arrays.stream(invoices)
                .filter(i -> i.getQuantity() * i.getPricePerItem() >= 200 && i.getQuantity() * i.getPricePerItem() <= 500)
                .map(i -> i.getPartDescription() + " (Value: " + i.getQuantity() * i.getPricePerItem() + ")")
                .collect(Collectors.toList());
        System.out.println("\nInvoice Values in the range $200 to $500:");
        invoiceValuesInRange.forEach(System.out::println);

        // f) Find an invoice in which the partDescription contains the word "saw"
        Invoice sawInvoice = Arrays.stream(invoices)
                .filter(i -> i.getPartDescription().toLowerCase().contains("saw"))
                .findFirst()
                .orElse(null);
        System.out.println("\nInvoice with partDescription containing 'saw':");
        System.out.println(sawInvoice);
    }
}
