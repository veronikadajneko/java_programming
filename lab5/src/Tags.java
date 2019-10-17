import java.util.*;

class Tags {
    private List<String> list = new ArrayList<String>();

    List<String> SortTags(StringBuilder inStr) {
        StringBuilder openTags = new StringBuilder();
        for (int i = 0; i < inStr.length() - 1; i++) {
            if (inStr.charAt(i) == '<' && inStr.charAt(i + 1) != '/') {
                openTags.append(inStr.charAt(i));
                i++;
                while (inStr.charAt(i) != '>') {
                    openTags.append(inStr.charAt(i));
                    i++;
                }
                openTags.append(inStr.charAt(i));
                openTags.append('\n');
                list.add(openTags.toString());
                openTags.setLength(0);
            }
        }
        Set<String> set = new HashSet<String>(list);
        list =  new ArrayList<String>(set);
        list.sort(Comparator.comparingInt(String::length));
        return list;
    }

}
