import java.util.*;

// 시뮬레이션 -> 그냥 문제에서 요구한대로 따라가면 되긴하는데 은근 까다로운듯

public class Main {
    public static class Student {
        int number;     // 학생 번호
        int recommend;  // 추천 횟수
        int time;       // 사진틀에 올라온 시간 

        Student(int number, int recommend, int time) {
            this.number = number;
            this.recommend = recommend;
            this.time = time;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사진틀 개수
        int totalCount = sc.nextInt(); // 전체 학생의 총 추천 수
        int[] recommendStudent = new int[totalCount];
        
        for (int i=0; i<totalCount; i++) {
            recommendStudent[i] = sc.nextInt();
        }
        
        List<Student> frame = new ArrayList<>(); // 사진틀
        int currentTime = 0;
        
        for (int studentNumber : recommendStudent) {
            boolean found = false;

            // 사진틀에 이미 있는 학생이면 추천 수 증가시키기 
            for (Student s : frame) {
                if (s.number == studentNumber) {
                    s.recommend++;
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }
            
            // 사진틀이 비어있으면 사진틀에 학생 추가
            if (frame.size() < N) {
                frame.add(new Student(studentNumber, 1, currentTime++));
            } else {
                // 사진틀이 꽉 찼으면, 추천 수가 가장 적고 오래된 학생 제거
                frame.sort((a, b) -> {
                    if (a.recommend == b.recommend) {
                        return a.time - b.time; // 오래된 순
                    }
                    return a.recommend - b.recommend; // 추천 적은 순
                });

                frame.remove(0); // 제거
                frame.add(new Student(studentNumber, 1, currentTime++)); // 새 학생 추가
            }
        }
        
        List<Integer> result = new ArrayList<>();
            for (Student s : frame) {
                result.add(s.number); // 학생 번호만 저장
            }

            Collections.sort(result); // 번호 오름차순 정렬

            for (int num : result) {
                System.out.print(num + " ");
            }

    }
}