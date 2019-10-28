import java.util.TreeMap;

public class phoneBook {
    public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook) {
        TreeMap<Integer, String> result = new TreeMap<>();
        for (String key : phoneBook.keySet()) {
            int phoneNum = phoneBook.get(key);
            result.put(phoneNum, key);
        }
        return result;
    }
}
