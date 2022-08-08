package algorithm.dfsbfs;

public class BinaryNumber {

    public void DFS(int n) {

        if (n == 0) {
            return;
        } else {
            DFS(n/2);
            int i = n % 2;
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        BinaryNumber T = new BinaryNumber();
        T.DFS(11);
    }
}
