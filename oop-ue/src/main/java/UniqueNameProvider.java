
public class UniqueNameProvider {

    private static final CustomList customList = new CustomList();

    private static final boolean checkName(final String name) {
        Listable listable = new Listable() {

            public String getName() {
                return name;
            }
        };
        return UniqueNameProvider.customList.contains(listable);
    }

}
