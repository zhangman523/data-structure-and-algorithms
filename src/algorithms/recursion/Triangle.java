package algorithms.recursion;

import java.io.IOException;

import static dataStructure.link.InterIterator.getInt;

/**
 * Java 三角数字
 * 据说毕达哥拉斯理论家，又称一群在毕达哥拉斯领导下工作的古希腊数学家，发现了在数字序列1，3，6，10，15，21...
 * 这个数列中的n 项是由第n-1项 加上n得到
 */
public class Triangle {
    static int theNumber;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();

        int theAnswer = triangle(theNumber);
        System.out.println("Triangle = " + theAnswer);
    }

    private static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n + triangle(n - 1));
        }
    }
}
