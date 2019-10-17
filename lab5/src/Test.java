import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner input1 = new Scanner(new File("input1.html"));
        Scanner input2 = new Scanner(new File("input2.in"));
        String html;
        String fragments;
        StringBuilder sB = new StringBuilder();
        List<String> listHtml = new ArrayList<String>();
        List<String> listFragments = new ArrayList<String>();
        FileWriter output1 = new FileWriter("output1.out");
        FileWriter output2 = new FileWriter("output2.out");
        FileWriter output3 = new FileWriter("output3.out");
        while (input1.hasNext()) {
            html = input1.nextLine();
            listHtml.add(html);
            listHtml.add("\n");
        }
        for(int i=0;i<listHtml.size();i++){
            sB.append(listHtml.get(i));
        }
        while (input2.hasNext()) {
            fragments = input2.nextLine();
            String[] words = fragments.split(";");
            listFragments.addAll(Arrays.asList(words));
        }
        var value = new Tags();
        for(var c : value.SortTags(sB)){
            output1.write(c.toString());
        }
        var variable = new Text();
        variable.outText(listHtml);
        for(var s : variable.findFragments(listFragments)){
            output2.write(s.toString());
            output2.write('\n');
        }
        for(var g : variable.falseFragments(listFragments)){
            output3.write(g.toString());
            output3.write('\n');
        }
        output1.close();
        output2.close();
        output3.close();
    }

}
