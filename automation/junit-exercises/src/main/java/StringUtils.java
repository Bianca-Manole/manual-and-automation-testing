public class StringUtils {


    public String reverse(String s) {

        if(s == null){
            throw new NullPointerException();
        }

        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;


    }

    public boolean isPalindrom(String s) {

        if(s == null){
            throw new NullPointerException();
        }
         return reverse(s).equals(s);

    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int countVowels(String s) {
        if(s == null) {
            throw new NullPointerException();
        }
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        return count;

    }
}
