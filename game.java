import java.util.Scanner;

    public class game {
        public static void main(String[] args) {

            // 게임에서 사용 할 변수
            int[] num = new int[3];
            int[] user = new int[3];
            int gamecnt = 1;
            boolean close = false; // 게임 종료를 위한 변수 선언 / 초기값을 false로 설정해두었고 true가 되면 게임 종료


            // 난수 생성
            for (int i = 0; i < num.length; i++) {
                int random = (int) (Math.random() * 10); // (int) Math.random() * (최댓값-최소값+1) + 최소값
                for (int j = 0; j < i; j++) {
                    if (num[j] == random) {
                        i--;
                        break;
                    }
                }
                num[i] = random;
//                System.out.print(num[i]); // 난수 확인용 출력


            }

            // 게임 시작
            Scanner sc = new Scanner(System.in);
            System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
            while (!close) { // while문 이용하여 close의 값이 true가 될 때 까지 무한루프를 돌게 함
                System.out.print(gamecnt + "번째 시도 : ");
                String[] input = sc.nextLine().split(""); // 사용자 입력 값을 String 배열로 받음
                // split() 메서드는 특정한 문자나 패턴을 기준으로 분리하여 문자열 배열로 만드는 역할
                // ex) 사용자가 "1234"라는 값을 입력, input 배열에는 "1", "2", "3", "4"라는 네 개의 문자열이 저장

                for (int i = 0; i < user.length; i++) {
                    user[i] = Integer.parseInt(input[i]); // String 배열을 int형으로 변환하여 user에 저장
                    //Integer.parseInt() 메서드는 문자열을 인자로 받아 정수형으로 변환하는 기능을 함
                }

                // 스트라이크, 볼 카운트 부분
                int scnt = 0;
                int bcnt = 0;

                for (int i = 0; i < num.length; i++) {
                    for (int j = 0; j < user.length; j++) {
                        if (num[i] == user[j]) {
                            if (i == j) { // i 와 j 의 값과 자릿수가 동일하다면
                                scnt++;
                            } else { // i 와 j 의 값은 동일하지만 자릿수가 다르다면
                                bcnt++;
                            }
                        }
                    }
                }

                // 게임 결과 출력
                if (scnt == 3) {
                    close = true;
                    System.out.println(scnt + "S");
                    System.out.println(gamecnt + "번만에 맞췄습니다. 야호!");
                    System.out.println("게임 종료");
                } else if (scnt == 0 && bcnt == 0) {
                    System.out.println(bcnt + "B" + scnt + "S");
                    gamecnt++;
                } else if (scnt == 0) {
                    System.out.println(bcnt + "B");
                    gamecnt++;
                } else if (bcnt == 0) {
                    System.out.println(scnt + "S");
                    gamecnt++;
                } else {
                    System.out.println(bcnt + "B" + scnt + "S");
                    gamecnt++;
                }
            }
        }
    }
