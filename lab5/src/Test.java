import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String html = "";
        String fragments="";
        StringBuilder sB = new StringBuilder();
        List<String> listHtml = new ArrayList<>();
        List<String> listFragments = new ArrayList<>();
        try (FileWriter output1 = new FileWriter("output1.out");
             FileWriter output2 = new FileWriter("output2.out");
             FileWriter output3 = new FileWriter("output3.out");
             Scanner input1 = new Scanner(new File("input1.html"));
             Scanner input2 = new Scanner(new File("input2.in"))) {

            readText(listHtml, sB, html, input1);
            readFragments(listFragments,fragments,input2);

            var value = new Tags();
            var variable = new Text();

            printList(value.SortTags(sB), output1);
            variable.outText(listHtml);
            printList(variable.findFragments(listFragments), output2);
            printList(variable.falseFragments(listFragments), output3);
        } catch (IOException e) {
            System.out.println("");
        }
    }

    private static void printList(List<?> list, Writer writer) throws IOException {
        for (var g : list) {
            writer.write(g.toString());
            writer.write('\n');
        }
    }

    private static void readText(List<String> list, StringBuilder sB, String str, Scanner input) throws IOException {
        while (input.hasNext()) {
            str = input.nextLine();
            list.add(str);
            sB.append(str);
            sB.append("\n");
        }
    }

    private static void readFragments(List<String> list, String str, Scanner input) throws IOException {
        while (input.hasNext()) {
            str = input.nextLine();
            String[] words = str.split(";");
            list.addAll(Arrays.asList(words));
        }
    }
}
