import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("output.txt");
            FileWriter writerAge = new FileWriter("outputAge.txt");
            FileWriter writerState = new FileWriter("outputState.txt")){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Logger logger = new Logger("logfile.txt");
            IDatabaseloader loader = null;
            if(input.equals("input.csv")){
                loader = new CSVDatabaseloader();
            }
            if(input.equals("input.json")){
                loader = new JSONDatabaseloader();
            }
            Database database = new Database(loader);
            logger.logFileWrite("Считывание файла ");
            database.load(input);
            logger.logFileWrite("Сортировка ");
            database.sortByState();
            logger.logFileWrite("Запись в файл ");
            writer.write(database.getData().toString());
            logger.logFileWrite("запись в файл с учетом возраста");
            writerAge.write(database.ageList().toString());
            logger.logFileWrite(("Запись в файл штатов"));
            writerState.write(database.stateList().toString());
            logger.closeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
