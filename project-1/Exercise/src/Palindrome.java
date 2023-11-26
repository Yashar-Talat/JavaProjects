public class Palindrome {
    public static void main(String[] args) {
        String str1 = "radar";
        String str2 = "hannah";
        String str3 = "hello";

        boolean result1 = isPalindrome(str1);
        boolean result2 = isPalindrome(str2);
        boolean result3 = isPalindrome(str3);

        System.out.println(str1 + " is a palindrome: " + result1); // باید true چاپ کند
        System.out.println(str2 + " is a palindrome: " + result2); // باید true چاپ کند
        System.out.println(str3 + " is a palindrome: " + result3); // باید false چاپ کند
    }

    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
