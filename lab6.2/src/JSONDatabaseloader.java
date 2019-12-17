import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class JSONDatabaseloader implements IDatabaseloader{

    @Override
    public List<Person> load(String input) {
        List<Person> data = new ArrayList<>();
       try( var fileReader = new FileReader(input)){
            Scanner sc = new Scanner(fileReader);
            sc.nextLine();
            while (sc.hasNext() && !sc.nextLine().equals("]")) {
                Person person = new Person();
                person.readJSON(sc.nextLine());
                data.add(person);
            }
        } catch (IOException e) {
           e.printStackTrace();
       }
       return data;
    }
}
