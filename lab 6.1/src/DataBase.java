import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
interface IDatabase {
    List<Person> GetData();
    void load(String fromFile, String format) throws FileNotFoundException;
    List<Person> AgeList() throws IOException;
}
class Database implements IDatabase {
    private List<Person> data = new ArrayList<>();
    private IDatabaseLoader loaderCSV;


    @Override
    public List<Person> GetData() {
        return data;
    }

    Database(IDatabaseLoader loader) {
        this.loaderCSV = loader;
    }

    @Override
    public void load(String fromFile, String format) throws FileNotFoundException {
        data = loaderCSV.load(fromFile, format);
    }

    Database SortByState() {
        var sorted = new Database(loaderCSV);
        sorted.data = data;
        sorted.data.sort(Comparator.comparing(Person::getState));
        return sorted;
    }

    @Override
    public List<Person> AgeList() throws IOException {
        List<Person> dataAge = new ArrayList<>();
        for (Person datum : data) {
            if((datum.GetAge() >= 18) && (datum.GetAge() <=60))
                dataAge.add(datum);
        }
        return dataAge;
    }

    public List<String> StateList() {
        List<String> dataState = new ArrayList<>();
        for (Person datum : data) {
            dataState.add(datum.getState());
        }
        return dataState;
    }
}
