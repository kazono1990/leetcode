package jp.co.kazono.leetcode.LC0151_Reverse_Words_in_a_String;

public class Solution {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return null;
        char s_arr[] = s.toCharArray();
        int len = s_arr.length;

        // reverse the whole string.
        reverse(s_arr, 0, len - 1);
        reverseWords(s_arr, len);
        return cleanSpaces(s_arr, len);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }

    private void reverseWords(char[] arr, int len) {
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < j || i < len && arr[i] == ' ') i++; // skip spaces
            while (j < i || j < len && arr[j] != ' ') j++; // skip non spaces
            reverse(arr, i, j - 1); // reverse the word
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // blue is sky the
        System.out.println(s.reverseWords("the sky is blue"));
    }
}
