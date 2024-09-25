package singleton;

public class MainTest {

    public static void main(String[] args) {
        // 싱글톤 객체 불러오기
        SingleTon systemSingleTon1 = SingleTon.getInstance();
        SingleTon systemSingleTon2 = SingleTon.getInstance();

        if (systemSingleTon1 == systemSingleTon2) {
            System.out.println("같은 객체를 바라보고 있습니다.");
        }

    }

}
