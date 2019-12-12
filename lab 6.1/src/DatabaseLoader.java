import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

interface IDatabaseLoader {
    List<Person> load(String input, String format);
}
class DatabaseLoader implements IDatabaseLoader {
    @Override
    public List<Person> load(String input, String format) {
        List<Person> data = new ArrayList<>();
        try (FileReader reader = new FileReader(input)) {
            Scanner sc = new Scanner(reader);
            if ((format.equalsIgnoreCase("csv"))) {
                sc.nextLine();
                while (sc.hasNext()) {
                    Person person = new Person();
                    String note = sc.nextLine();
                    List<String> list = new ArrayList<>(Arrays.asList(note.split(";")));
                    person.readCSV(list);
                    data.add(person);
                }
            }
            if ((format.equalsIgnoreCase("json"))) {
                while (sc.hasNext()) {
                    Person person = new Person();
                    person.readJSON(sc.nextLine());
                    data.add(person);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
