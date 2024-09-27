package strategy;

import java.util.Base64;
import java.net.URLEncoder;

public class StrategyTest {

    public static void main(String[] args) {

        // 클라이언트 측 코드
        String message = "홍길동";

        // 1. 텍스트를 인코딩하는 클래스를 메모리에 올린다.
        Encoder encoder = new Encoder();

        // 전략 클래스 미리 생성해 보기
        NormalStrategy normalStrategy = new NormalStrategy();
        Base64Strategy base64Strategy = new Base64Strategy();
        AppendStrategy appendStrategy = new AppendStrategy();
        HTMLStrategy htmlStrategy = new HTMLStrategy();

        // 선략을 선택해서 설정
        encoder.setEncodingStrategy(base64Strategy);

        // 기능 호출해보기
        String outputMessage1 = encoder.getMessage(message);
        System.out.println(outputMessage1);

        // 전략 변경해보기
        encoder.setEncodingStrategy(appendStrategy);

        // 두 번째 기능 호출해보기
        String outputMessage2 = encoder.getMessage(message);
        System.out.println(outputMessage2);

        // 전략 변경해보기
        encoder.setEncodingStrategy(normalStrategy);

        // 세 번째 기능 호출해보기
        String outputMessage3 = encoder.getMessage(message);
        System.out.println(outputMessage3);

        // 전략 변경해보기
        encoder.setEncodingStrategy(htmlStrategy);

        // 네 번째 기능 호출해보기
        String outputMessage4 = encoder.getMessage(message);
        System.out.println(outputMessage4);

    } // end of main

}

// 인코딩 전략 인터페이스
interface EncodingStrategy {
    String encode(String text);
}

// 일반 텍스트를 보내는 전략 클래스 생성
class NormalStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return text;
    }
}

// Base64 인코딩 전략
class Base64Strategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}

// 특정 문자열을 추가하는 인코딩 전략
class AppendStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return text + " : " + "not base64";
    }
}

// HTML 인코딩 전략을 만들어주세요.
// http://localhost:8080/name=%22%ED%99%8D%EA%B8%B8%EB%8F%99%22
class HTMLStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}


// 핵심! - 클라이언트 클래스
class Encoder {

    // 1. 추상화 개념(멤버)
    private EncodingStrategy encodingStrategy;

    // 2.
    // 전략에 따라 메세지를 인코딩하여 반환
    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }

    // 3.
    // 전략을 따라서 동적으로 전략을 선택할 수 있는 기능
    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }

}