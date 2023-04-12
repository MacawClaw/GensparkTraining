import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Disarium {
    public static void main(String[] args) {

        //Check each number until the array is full
        int[] disariumNums = new int[19];

        int i = 0;
        int j = 0;
        while (disariumNums[18] == 0) {
            if (isDisarium(i)) {
                disariumNums[j] = i;
                j++;
            }
            i++;
        }

        System.out.println(Arrays.toString(disariumNums));


    }

    public static boolean isDisarium(int num) {
        //Get the digits
        ArrayList<Integer> digits = new ArrayList<>();

        int working_num = num;
        int digit = 0;
        //Use modulo operator to get the digits and store in an array
        //NOTE: This may also be achieved with a stack since the last elements are going to be accessed first
        while(working_num != 0) {
            digits.add(0,(working_num % 10));
            working_num /= 10;
        }

        //Calculate the number that will be compared to the original
        int sum = 0;
        for(int i = 0; i<digits.size(); i++) {
            sum += Math.pow(digits.get(i),i + 1);
        }

        if (sum == num) return true;
        return false;
    }
}
