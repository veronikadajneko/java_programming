import java.util.List;
import java.util.TreeSet;

class Symbols {
    private TreeSet<Character> treeSet = new TreeSet<Character>();
  public void addLetters(List<String> text){
      for (var line : text) {
          for (var c : line.toCharArray()) {
              if (Character.isLetter(c))
                  treeSet.add(c);
          }
      }
  }
   void printLetters(){
      for (Character symbol : treeSet) {
          System.out.println(symbol);
      }
  }
}
