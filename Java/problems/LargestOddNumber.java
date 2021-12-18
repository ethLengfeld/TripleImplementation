package problems;

public class LargestOddNumber {
        public String largestOddNumber(String num) {
            boolean hasOdd = false;
            int i;
            for(i=num.length()-1; i > -1; i--) {

                if(Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                    hasOdd = true;
                    break;
                }
            }
            if(!hasOdd) {
                return "";
            }
            return num.substring(0,i+1);
        }
    }
