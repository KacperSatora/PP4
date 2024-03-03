public class Receipt {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Clean Code, Robert C. Martin", 100.f, 8.f),
                new Item("Applying UML and Patterns, C. Larman", 300.f, 8.f),
                new Item("Shipping", 50.f, 23.f)
        };
        PrintResult(items);


    }

    private static void PrintResult(Item[] items) {
        String format = "|%1$-15s|%2$-13s|%3$-11s|\n";

        double totalNetto = 0.f, totalVat8 = 0.f, totalVat23 = 0.f;

        for (Item item : items) {
            totalNetto += item.getPrice();
            if (item.getVat() == 8.f) {
                totalVat8 += item.getValue();
            } else if (item.getVat() == 23.f) {
                totalVat23 += item.getValue();
            }
        }


        System.out.format(format, "", StringUtils.center("Total netto", 13), StringUtils.center(String.valueOf(totalNetto), 11));
        System.out.format(format, "---------------", "-------------", "-----------");
        System.out.format(format, StringUtils.center("VAT 8%", 15), StringUtils.center(String.valueOf(totalVat8), 13), StringUtils.center(String.valueOf(totalNetto + totalVat8), 11));
        System.out.format(format, StringUtils.center("VAT 23%", 15), StringUtils.center(String.valueOf(totalVat23), 13), StringUtils.center(String.valueOf(totalNetto + totalVat23 + totalVat8), 11));

    }
}

class Item {
    private String name;
    private double price;
    private double vat;

    public Item(String name, double price, double vat) {
        this.name = name;
        this.price = price;
        this.vat = vat;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return price * vat / 100;
    }

    public double getVat() {
        return vat;
    }
}

class StringUtils {
    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}