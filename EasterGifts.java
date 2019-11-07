import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> gifts = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            gifts.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.equals("No Money")) {
            String[] temp = command.split(" ");
            String firstCommand = temp[0];

            if (firstCommand.equals("OutOfStock")) {
                for (int i = 0; i < gifts.size(); i++) {
                    if (temp[1].equals(gifts.get(i))) {
                        gifts.set(i, "None");
                    }
                }
            }

            if (firstCommand.equals("Required")) {
                if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < gifts.size()) {
                    gifts.set(Integer.parseInt(temp[2]), temp[1]);
                }
            }

            if (firstCommand.equals("JustInCase")) {
                gifts.set(gifts.size() -1, temp[1]);
            }


            command = scanner.nextLine();
        }

        for (String gift : gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }


    }
}
