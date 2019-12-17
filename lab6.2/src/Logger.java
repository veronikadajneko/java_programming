import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    private FileWriter writer;

    Logger(String output) {
        try {
            writer = new FileWriter(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void logFileWrite(String str) {
        var sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        try {
            writer.write((date + " " + str + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeFile() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
