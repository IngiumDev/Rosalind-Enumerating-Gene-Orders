import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class EnumeratingGeneOrders {
    public static void main(String[] args) {
        int input = 7;
        // Save the output to a file
        try {
            PrintStream out = new PrintStream(new FileOutputStream("src\\output.txt"));
            System.setOut(out);
            System.out.println(getNumberOfPermutations(input));
            getPermutations(getSetOfNumbersOfN(input), "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * A permutation of length n is an ordering of the positive integers {1,2,…,n}. For example, π=(5,3,2,1,4) is a permutation of length 5.
     * Prints the total number of permutations of length n, followed by a list of all such permutations (in any order)
     *
     * @param n the number of elements in the permutation
     */
    public static String getSetOfNumbersOfN(int n) {
        StringBuilder permutation = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Add the number to the permutation
            permutation.append(i + 1);
        }
        return permutation.toString();
    }

    /**
     * @param n the number of elements in the permutation
     * @return the total number of permutations of length n
     */
    public static int getNumberOfPermutations(int n) {
        int numberOfPermutations = 1;
        for (int i = 1; i <= n; i++) {
            // Multiply the number of permutations by the number of elements
            numberOfPermutations *= i;
        }
        return numberOfPermutations;
    }

    /**
     * get all permutations of a given string
     *
     * @param permutation the numbers of the permutation
     * @param answer      should be empty string at the beginning
     */
    public static void getPermutations(String permutation, String answer) {
        if (permutation.length() == 0) {
            // Add space between each number
            String[] split = answer.split("");
            // Print the permutation
            for (int i = 0; i < split.length; i++) {
                System.out.print(split[i] + " ");
            }
            System.out.println();
            return;
        }
        // Loop through the permutation
        for (int i = 0; i < permutation.length(); i++) {
            // Get the character at the index
            char ch = permutation.charAt(i);
            // Get the substring of the permutation without the character at the index
            String left_substr = permutation.substring(0, i);
            // Get the substring of the permutation after the character at the index
            String right_substr = permutation.substring(i + 1);
            // Set string rest to the concatenation of the left substring and the right substring
            String rest = left_substr + right_substr;
            // Recursively call the function with the new permutation and the answer
            getPermutations(rest, answer + ch);
        }
    }
}
