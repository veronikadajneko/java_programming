import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Database implements IDatabase {
    private List<Person> data = new ArrayList<>();
    private IDatabaseloader loader;

    List<Person> getData() {
        return data;
    }

    Database(IDatabaseloader loader) {
        this.loader = loader;
    }

    public void load(String input) {
        data = loader.load(input);
    }

    Database sortByState() {
        var sorted = new Database(loader);
        sorted.data = data;
        sorted.data.sort(Comparator.comparing(Person::getState));
        return sorted;
    }

    List<Person> ageList() {
        List<Person> dataAge = new ArrayList<>();
        for (Person datum : data) {
            if ((datum.getAge() >= 18) && (datum.getAge() <= 60))
                dataAge.add(datum);
        }
        return dataAge;
    }

    List<String> stateList() {
        List<String> dataState = new ArrayList<>();
        for (Person datum : data) {
            dataState.add(datum.getState());
        }
        return dataState;
    }
}
