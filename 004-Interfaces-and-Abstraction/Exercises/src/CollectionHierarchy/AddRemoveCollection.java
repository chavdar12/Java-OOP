package CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        return items.remove(items.size() - 1);
    }
}
