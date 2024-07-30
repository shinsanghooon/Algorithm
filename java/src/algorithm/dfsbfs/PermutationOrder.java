package algorithm.dfsbfs;

public class PermutationOrder {

    public static int n, m = 0;

    public static int[] ch;

    public static int[] pm;
    public static void main(String[] args) {

        n = 3;
        m = 2;

        ch = new int[n];
        pm = new int[m];

        int[] arr = {3, 6, 9};

        PermutationOrder t = new PermutationOrder();
        t.solution(arr);
    }

    public void solution(int[] arr) {
        DFS(0, arr);
    }

    private void DFS(int L, int[] arr) {

        if (L == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] != 1) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1, arr);
                }
                ch[i] = 0;
            }


        }


//        if (L == m) {
//            for (int x : pm) {
//                System.out.print(x + " ");
//
//            }
//            System.out.println();
//        } else {
//            for (int i = 0; i < n; i++) {
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    pm[L] = arr[i];
//                    DFS(L + 1);
//                    ch[i] = 0;
//                }
//            }
//        }
    }

}
