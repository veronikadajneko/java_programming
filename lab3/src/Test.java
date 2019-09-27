import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        String str1;
        Scanner in = new Scanner(System.in);
        while (((str1 = in.nextLine()).length()) != 0) {
            text.add(str1);
        }
        var value = new Symbols();
        value.addLetters(text);
        value.printLetters();
    }
}
