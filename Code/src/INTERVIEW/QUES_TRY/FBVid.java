package INTERVIEW.QUES_TRY;

import java.util.*;


/**
 * Created by Shreyans Sheth [bholagabbar] on 4/11/2016 at 8:23 PM using IDEA
 */

class FBVid {

    private static HashMap<Character, ArrayList<Character>> hm = new HashMap<>();
    private  static TreeSet<String> set = new TreeSet<>();
    private static TreeSet<String> realWords = new TreeSet<>(new ArrayList<>(Arrays.asList("hi", "go")));

    private static void rec(String oriWord, StringBuilder currWord, int index) {
        if (index == oriWord.length()) {
            if (realWords.contains(currWord.toString())) {
                set.add(currWord.toString());
            }
            return;
        }
        for (char i : hm.get(oriWord.charAt(index))) {
            currWord.append(i);
            rec(oriWord, currWord, index + 1);
            currWord.deleteCharAt(currWord.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> al =new ArrayList<>();
        Collections.sort(al, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        hm.put('g', new ArrayList<>(Arrays.asList('g','h','f')));
        hm.put('i', new ArrayList<>(Arrays.asList('i','o','k')));
        String givenWord = "gi";
        rec(givenWord, new StringBuilder(), 0);
        System.out.println(set);
    }
}