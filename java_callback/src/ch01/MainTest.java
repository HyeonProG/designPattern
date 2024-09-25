package ch01;

public class MainTest {

    public static void main(String[] args) {
        Button button = new Button("나의 버튼 1");

        // 버튼 인스턴스에 콜백 메서드 동작 정의
        button.addEventListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println("----------------------");
                System.out.println(">> 콜백 메서드 실행 <<");
                System.out.println(event);
                System.out.println("----------------------");
            }
        });

        // 버튼을 클릭
        button.click("안녕 홍길동");
    }

}
