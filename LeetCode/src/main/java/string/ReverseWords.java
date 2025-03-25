package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-24 14:16
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        System.out.println(reverseWords.reverseWords(s1));
        System.out.println(reverseWords.reverseWords(s2));
        System.out.println(reverseWords.reverseWords(s3));
    }

    public String reverseWords(String s) {
        char[] initialArr = s.toCharArray();
        char[] newArr = new char[initialArr.length + 1];
        int newArrPos = 0;
        int i = initialArr.length - 1;
        while (i >= 0) {
            while (i >= 0 && initialArr[i] == ' ') {
                i--;
            }
            int right = i;
            while (i >= 0 && initialArr[i] != ' ') {
                i--;
            }
            for (int j = i + 1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if (j == right) {
                    newArr[newArrPos++] = ' ';
                }
            }
        }
        if(newArrPos == 0){
            return "";
        }else{
            return new String(newArr,0,newArrPos-1);
        }
    }
}
