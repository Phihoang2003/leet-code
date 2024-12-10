import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

//        System.out.println(calculator("III"));
//        System.out.println(calculator("IV"));
//        System.out.println(calculator("IX"));
//        System.out.println(calculator("LVIII"));
//        System.out.println(Roman13("MCMXCIV"));
//        System.out.println(maxProfit121(new int[]{7,6,4,3,1}));
//        System.out.println(lengthOfLastWord58("   fly me   to   the moon  "));
//       System.out.println(longestCommonPrefix14(new String[]{"flower","flow","flight"}));
//        System.out.println(isPalindrome125("A man, a plan, a canal: Panama"));
//        System.out.println(strStr28("sadbutsad","sad"));
//        System.out.println(canConstruct383("aa","aab"));
        System.out.println(isSubsequence392("axc","ahbgdc"));
    }

    public static int Roman13(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = map.get(String.valueOf(s.charAt(i)));

            if (i + 1 < s.length()) {
                int nextVal = map.get(String.valueOf(s.charAt(i + 1)));


                if (currentVal < nextVal) {
                    result += (nextVal - currentVal);
                    i++;
                } else {
                    result += currentVal;
                }
            } else {
                result += currentVal;
            }
        }
        return result;
    }

    public static int maxProfit121(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Khởi tạo giá mua thấp nhất với giá trị lớn nhất
        int maxProfit = 0;  // Khởi tạo lợi nhuận tối đa

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;  // Cập nhật giá mua thấp nhất
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;  // Cập nhật lợi nhuận tối đa
            }
        }

        return maxProfit;
    }

    public static int lengthOfLastWord58(String s) {
        int result=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                result++;
            }
            if(result>0 && s.charAt(i)==' '){
                break;
            }
        }
        return result;
    }

    public static String longestCommonPrefix14(String[] strs) {
       if(strs==null || strs.length==0){
           return "";
       }
       String prefix=strs[0];
       for(int i=1;i<strs.length;i++){
           while (strs[i].indexOf(prefix)!=0){
               prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                     return "";
           }
       }
        return prefix;
    }

    public static boolean isPalindrome125(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int strStr28(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public static boolean canConstruct383(String ransomNote, String magazine) {
        int charCount[]=new int[26];
        for(char c:magazine.toCharArray()){
            charCount[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(charCount[c-'a']==0){
                return false;
            }
            charCount[c-'a']--;
        }
        return true;
    }
    public static boolean isSubsequence392(String s, String t) {
        int j=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            j=t.indexOf(c,j);
            if(j==-1){
                return false;
            }
            j++;
        }
        return true;
    }

}


