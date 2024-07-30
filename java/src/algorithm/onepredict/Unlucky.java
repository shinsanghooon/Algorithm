//package algorithm.onepredict;
//
//import java.util.*;
//
//public class Unlucky {
//
//    public class State {
//        String value;
//
//        int step;
//
//        public State(String value, int step) {
//            String.value = value;
//            this.step = step;
//        }
//    }
//
//    public static void main(String[] args) {
//        Unlucky t = new Unlucky();
//        int n = 4;
//        long result = t.solution2(n);
//        System.out.println("result = " + result);
//    }
//
//    public long solution2(int n) {
//
//        Queue<State> q = new LinkedList<>();
//        List<String> list = new ArrayList<>();
//
//        q.add(new State("4", 1));
//
//
//        while (!q.isEmpty()) {
//            State state = q.poll();
//            list.add(state.value);
//
//            int step = state.step;
//
//
//
//        }
//
//    }
//
//    private static String getString(long unlucky, String idx) {
//        String nextValue = unlucky + idx;
//        return nextValue;
//    }
//
//
//    public long solution(int n) {
//
//        long[] target = {4, 13};
//
//        List<Long> list = new ArrayList<>();
//        Queue<State> q = new LinkedList<>();
//
//        q.add(new State(4, 1));
//        while (!q.isEmpty()) {
//
//            State state = q.poll();
//            long poll = state.value;
//
//            list.add(poll);
//
//            for (int i = 0; i < target.length; i++) {
//                int nextStep = state.step + 1;
//
//                if (nextStep == 2) {
//                    if (target[i] == 4) {
//                        q.add(new State(44, nextStep));
//                    } else {
//                        q.add(new State(target[i], nextStep));
//                    }
//                    System.out.println("nextStep = " + nextStep + " / nextNumber = " + target[i]) ;
//                } else {
//                    String nextNumber = getNextNumber(poll, target[i], nextStep);
//                    if (nextNumber.length() == nextStep) {
//                        q.add(new State(Long.parseLong(nextNumber), nextStep));
//                        System.out.println("nextStep = " + nextStep + " / nextNumber = " + nextNumber) ;
//                    } else {
//                        q.add(new State(poll, nextStep));
//                        System.out.println("nextStep = " + nextStep + " / nextNumber = " + poll) ;
//                    }
//
//                }
//            }
//
//            if (Math.pow(2, state.step) > 5000) {
//                break;
//            }
//        }
//
//        Collections.sort(list);
//
//        return list.get(n-1);
//    }
//
//    private String getNextNumber(long poll, long i, int nextStep) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(poll);
//        sb.append(i);
//        return sb.toString();
//    }
//
//
//
//
//}
