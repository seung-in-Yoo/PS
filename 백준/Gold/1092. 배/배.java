import java.util.*;

//그리디 알고리즘 -> 가장 무거운 크레인으로 가장 무거운 박스를 먼저 처리
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 크레인 수
        Integer[] cranes = new Integer[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = sc.nextInt();
        }

        int M = sc.nextInt(); // 박스 수
        ArrayList<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(sc.nextInt());
        }

        Arrays.sort(cranes, Collections.reverseOrder()); // 무거운 순이니 reversOrder
        boxes.sort(Collections.reverseOrder()); // 무거운 순

        // 크레인 무게 제한보다 박스가 무거운 경우 
        if (cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0; // 옮기는 시간(1분 단위)
        
        // 박스 다 옮길때까지
        while (!boxes.isEmpty()) {
            int movedBox = 0; // 박스를 가리키는 인덱스
            for (int i = 0; i < N;) { // 크레인 순서대로
                if (movedBox >= boxes.size()) {
                    break;
                }    
 
                if (cranes[i] >= boxes.get(movedBox)) {
                    boxes.remove(movedBox); // 박스 옮기고 제거
                    i++; // 다음 크레인으로 이동
                } else {
                    movedBox++; // 현재 박스를 다음 박스로
                }
            }
            time++; // 1분 소요
        }

        System.out.println(time);
    }
}