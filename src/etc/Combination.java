package etc;

import java.util.Scanner;
import java.util.Stack;

public class Combination {

    // 백트래킹
    static void combination_backTracking(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            print(arr, visited, n);
        } else {
            for(int i = start; i < n; i++){
                visited[i] = true;
                combination_backTracking(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    // 재귀
    private static void combination_recursive(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0)
            print(arr, visited, n);
        else if (depth != n) {
            visited[depth] = true;
            combination_recursive(arr, visited, depth + 1, n, r - 1);
            visited[depth] = false;
            combination_recursive(arr, visited, depth + 1, n, r);
        }
    }

    //조합 (순서 관심 없고 뽑은 유무만 생각)
    private static void combination(int[] comArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : comArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if(target == n)return;

        comArr[index] = target;
        combination(comArr, n, r-1, index+1, target+1); //뽑는 경우
        combination(comArr, n, r, index, target+1); //안 뽑는 경우
    }

    private static void permutaion(int[] arr, boolean[] visited, int n, int r, Stack<Integer> stack) {
        if(stack.size() == r){
            for (Integer integer : stack)
                System.out.print(integer + " ");
            System.out.println();
        } else{
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    stack.push(arr[i]);
                    permutaion(arr, visited, n, r, stack);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }

    private static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = 0;
        System.out.println("몇 개의 수를 입력할지 정해주세요.");
        int n = sc.nextInt();

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        System.out.println(n + "개의 숫자를 입력해주세요.");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();


        System.out.println("몇 개의 조합으로 구현할지 입력해주세요");
        int r = sc.nextInt();

        System.out.println(n + "개의 수 중에서 " + r + "개 뽑기");
        System.out.println("========백트래킹 구현========");
        combination_backTracking(arr, visited, start,  n, r);
        System.out.println("========재귀 구현========");
        combination_recursive(arr, visited, start, n, r);
        Stack<Integer> stack = new Stack<>();
        System.out.println("========순열 구현========");
        permutaion(arr, visited, n, r, stack);
    }


}
