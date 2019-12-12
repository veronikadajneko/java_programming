import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    private FileWriter writer;
    Logger(String output) throws IOException {
        writer = new FileWriter(output);
    }

    void logFileWrite(String str) throws IOException {
        var sdf = new SimpleDateFormat("dd-M-yyyy hh::mm::ss");
        String date = sdf.format(new Date());
        try{
            writer.write((date + " " + str +"\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeFile() throws IOException {
        writer.close();
    }
}
