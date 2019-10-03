import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("text.txt"));
        String str = " ";
        StringBuilder sb = new StringBuilder();
        FileWriter writer = new FileWriter("newText.txt");

        while (in.hasNext()) {
            str = in.nextLine();
            sb.append(str);
            sb.append("\n");
        }

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '/') {
                while (sb.charAt(i) != '\n')
                    sb.deleteCharAt(i);
            }
            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '*') {
                while (sb.charAt(i) != '*' || sb.charAt(i + 1) != '/')
                    sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
            }
            int count = 0;
            if (sb.charAt(i) == '"') {
                i++;
                while (i < sb.length()) {
                    if (sb.charAt(i) == '"' && count % 2 == 0) {
                        break;
                    }
                    if (sb.charAt(i) == '\\') {
                        count++;
                    } else count = 0;
                    i++;
                }
                i++;
            }
            if (sb.charAt(i) == '\'') {
                while (i + 1 < sb.length() && sb.charAt(i + 1) != '\'')
                    i++;
                i++;
            }

        }
        writer.write(sb.toString());
        System.out.println(sb);
        writer.close();
    }
}
