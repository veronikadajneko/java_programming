import java.util.ArrayList;
import java.util.List;

class Text {
    private List<String> textList = new ArrayList<String>();

    void outText(List<String> inList) {
        for (String str : inList) {
            StringBuilder strB = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    while (j < str.length() && str.charAt(j) != '>') {
                        j++;
                    }
                    j++;
                }
                if (j < str.length()) {
                    strB.append(str.charAt(j));
                }
            }
            textList.add(strB.toString());
        }

    }

    private List<Integer> number = new ArrayList<Integer>();
    private List<String> falseF = new ArrayList<String>();

    List<Integer> findFragments(List<String> inList) {
        for (int i = 0; i < inList.size(); i++) {
            int flag = 0;
            for (int j = 0; j < textList.size(); j++) {
                if (textList.get(j).contains(inList.get(i))) {
                    flag = 1;
                    number.add(j);
                    break;
                }
            }
            if (flag == 0) {
                number.add(-1);
            }
        }
        return number;
    }

    List<String> falseFragments(List<String> inList) {
        for (int i = 0; i < inList.size(); i++) {
            int flag = 0;
            for (int j = 0; j < textList.size(); j++) {
                if (textList.get(j).contains(inList.get(i))) {
                    flag = 1;
                    number.add(j);
                    break;
                }
            }
            if (flag == 0) {
                number.add(-1);
                falseF.add(inList.get(i));
            }
        }
        return falseF;
    }

}
