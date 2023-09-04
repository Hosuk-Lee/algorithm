package stack.ex02;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String duel = sc.nextLine();
        String result = checkDefense(duel);

        System.out.println(result);
    }

    public static String checkDefense(String duel) {
        Stack<Character> s = new Stack();
        for (int i = 0; i < duel.length(); i++) {
            char c = duel.charAt(i);
            if (c == '(') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return "NO";
                }
                if ('(' == s.pop()) {
                    ;
                } else {
                    return "NO";
                }
            }
        }
        return s.isEmpty() ? "YES" : "NO";
    }
/*
정의의 용사가 나쁜 악당과 싸우고 있습니다. 나쁜 악당은 하나라도 터지면 우주가 멸망해버리는 폭탄 ‘(‘ 를 발사하였습니다. 이 폭탄을 막을 방법은 폭탄과 정확하게 같은 개수만큼 용사 레이저 ‘)’ 를 발사하는 것뿐입니다. 용사 레이저도 너무 강력하여 폭탄보다 먼저 발사되거나 많이 발사해버리면 폭발하여 우주가 멸망합니다.
예를 들어, “(())()()” 의 경우 폭탄과 레이저의 개수가 일치하여 방어에 성공했지만, “((()((())” 또는 “)))(())” 의 경우에는 폭탄이 레이저보다 많거나 레이저가 폭탄보다 많아 폭발하여 우주가 멸망하게 됩니다. “)(“ 의 경우에는 개수는 일치하지만 폭탄보다 레이저가 먼저 발사되어 우주가 멸망하게 됩니다.
용사와 악당의 결투를 문자열로 받아 방어에 성공했는지 판별해보는 프로그램을 작성하세요.
*/
}
