package CollectionHierarchy;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split("\\s+");
        int removes = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        for (Addable collection : List.of(addCollection, addRemoveCollection, myList)) {
            StringJoiner indexes = new StringJoiner(" ");
            for (String item : items) {
                indexes.add(String.valueOf(collection.add(item)));
            }
            System.out.println(indexes);
        }
        for (AddRemovable collection : List.<AddRemovable>of(addRemoveCollection, myList)) {
            StringJoiner removed = new StringJoiner(" ");
            for (int i = 0; i < removes; i++) {
                removed.add(collection.remove());
            }
            System.out.println(removed);
        }
    }
}
