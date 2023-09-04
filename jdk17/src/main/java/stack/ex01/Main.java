package stack.ex01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        String x;
        Scanner sc = new Scanner(System.in);
        x = sc.nextLine();  // 사용자로부터 문자열을 입력받습니다.
        System.out.println(isBalanced(x));  // 입력된 문자열의 괄호 순서가 올바른지 확인하고 결과를 출력합니다.
    }

    private static boolean isBalanced(String x) {
        Stack<Character> s = new Stack();
        // 여는괄호. ({[, 닫는괄호. )}]

        for (int i = 0; i < x.length(); i++) {
            if (isMatched(x.charAt(i), '(', '{', '[')) {
                s.push(x.charAt(i));
                System.out.println("여는괄호 : " + s.peek());
            } else {
                if (isMatched(x.charAt(i), ')', '}', ']')) {
                    System.out.println("닫는괄호 : " + x.charAt(i));

                    // 검사
                    Character top = s.pop();
                    if ((x.charAt(i) == ')' && top == '(')
                        || (x.charAt(i) == '}' && top == '{')
                        || (x.charAt(i) == ']' && top == '['))
                        ;
                    else {
                        System.out.println("?" + top);
                        return false;
                    }
                }
            }
        }

        return s.isEmpty();
    }

    private static boolean isMatched(Character c, Character... code) {
        return Arrays.stream(code).anyMatch((a) -> c == a);
    }
}
/*
    주어진 문자열을 입력받습니다.
    스택을 초기화합니다.
    문자열을 한 글자씩 순회하면서 다음 작업을 수행합니다:
    여는 괄호인 경우:
    스택에 해당 괄호를 push합니다.
    닫는 괄호인 경우:
    스택이 비어있는지 확인합니다. 비어있다면 올바르지 않은 괄호이므로 결과를 반환합니다.
    스택의 top에 있는 괄호와 현재 괄호가 짝이 맞는지 확인합니다. 짝이 맞지 않다면 결과를 반환합니다.
    짝이 맞는다면 스택에서 해당 괄호를 pop합니다.
    문자열을 모두 순회한 뒤, 스택이 비어있는지 확인합니다. 비어있다면 올바른 괄호이므로 true를 반환합니다. 그렇지 않다면 false를 반환합니다.
    이러한 접근 방식을 통해 주어진 문자열의 괄호가 올바른 순서로 짝지어졌는지 확인할 수 있습니다.


    스택을 활용할 수 있는 문제 예제입니다. 문제를 통해 스택의 특징을 복습해 보세요

    문제 : 괄호들이 올바르게 짝지어졌는지 확인하기
    문자열을 입력받아, 전체 문자열에서 괄호가 올바른 순서로 입력되었는지 확인하세요.

    올바르게 짝지어졌다는 의미는 다음과 같습니다.

    모든 여는 괄호에 대응하는 닫는 괄호가 있어야 함
    여는 괄호와 닫는 괄호의 순서가 일치해야 함
    모든 괄호 쌍은 서로 중첩되지 않음
    예시:

    "([code])(states){}"는 올바르게 짝지어졌음
    "([)]"은 올바르게 짝지어지지 않음
    "([](){([])})"은 올바르게 짝지어졌음
    "({([java])spring})"은 올바르게 짝지어졌음
    스택의 LIFO(Last In First Out) 특성을 활용하여 여는 괄호를 스택에 push하고, 닫는 괄호를 만났을 때 스택에서 pop하여 짝이 맞는지 확인합니다.
*/
