import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        String str1;
        Scanner in = new Scanner(System.in);
        while (((str1 = in.nextLine()).length()) != 0) {
            text.add(str1);
        }

        TreeSet<Character> symbols = new TreeSet<Character>();
        for (var line : text) {
            for (var c : line.toCharArray()) {
                if (Character.isLetter(c))
                symbols.add(c);
            }
        }
        Iterator<Character> itr = symbols.iterator();

        while (itr.hasNext()){
                System.out.println(itr.next());
        }
    }
}
