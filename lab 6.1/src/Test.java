import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String format = in.next();
        String fromFile = "input." + format;
        Logger Log = new Logger("logfile.txt");
        FileWriter wr = new FileWriter("output.txt");
        FileWriter wrAge = new FileWriter("outputAge.txt");
        FileWriter wrState = new FileWriter("outputState.txt");
        IDatabaseLoader Loader = new DatabaseLoader();
        Database database = new Database(Loader);
        Log.logFileWrite("Считывание файла ");
        database.load(fromFile, format);
        Log.logFileWrite("Сортировка ");
        database.SortByState();
        Log.logFileWrite("Запись в файл ");
        wr.write(database.GetData().toString());
        Log.logFileWrite("запись в файл с учетом возраста");
        wrAge.write(database.AgeList().toString());
        Log.logFileWrite(("Запись штатов в файл "));
        wrState.write(database.StateList().toString());
        Log.closeFile();
    }
}

