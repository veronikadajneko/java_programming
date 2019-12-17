import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CSVDatabaseloader implements IDatabaseloader {
    @Override
    public List<Person> load(String input) {
        List<Person> data = new ArrayList<>();
        try (FileReader reader = new FileReader(input)) {
            Scanner sc = new Scanner(reader);
            sc.nextLine();
            while (sc.hasNext()) {
                Person person = new Person();
                String note = sc.nextLine();
                List<String> list = new ArrayList<>(Arrays.asList(note.split(";")));
                person.readCSV(list);
                data.add(person);

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}