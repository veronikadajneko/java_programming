import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("text.java"));
        String str;
        StringBuilder sb = new StringBuilder();
        FileWriter writer = new FileWriter("newText.java");
        while (in.hasNext()) {
            str = in.nextLine();
            sb.append(str);
            sb.append("\n");
        }
        var value = new newText();
        writer.write(value.deleteCom(sb).toString());
        writer.close();
    }
}
