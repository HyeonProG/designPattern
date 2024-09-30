package decorator;

// Coffee 인터페이스: 커피의 비용과 설명을 제공하는 메서드 정의
interface Coffee {
    double getCost(); // 커피의 가격을 반환하는 메서드

    String getDescription(); // 커피의 설명을 반환하는 메서드
}

// 기본적인 커피 구현 클래스 (Decorator 역할을 함)
public class Cafe implements Coffee {
    @Override
    public double getCost() {
        return 1; // 기본 커피의 가격을 1로 설정
    }

    @Override
    public String getDescription() {
        return "Simple coffee"; // 기본 커피의 설명을 "Simple coffee"로 반환
    }
}

// MilkDecorator 클래스: 커피에 우유를 추가하는 데코레이터 클래스
class MilkDecorator extends Cafe {
    private Coffee coffee; // 데코레이터가 장식할 Coffee 객체

    // 생성자: 우유 데코레이터에 커피 객체를 전달받음
    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    // 커피의 비용에 우유 비용을 추가
    public double getCost() {
        return coffee.getCost() + 0.5; // 기존 커피의 가격에 우유 추가 비용 0.5를 더함
    }

    // 커피의 설명에 "milk"를 추가
    public String getDescription() {
        return coffee.getDescription() + ", milk"; // 기존 설명에 "milk" 추가
    }

    // 메인 메서드: 데코레이터 패턴을 테스트하는 코드
    public static void main(String[] args) {
        // 우유가 추가된 커피 객체 생성 (MilkDecorator로 Simple coffee에 우유 추가)
        Coffee myCoffee = new MilkDecorator(new Cafe());

        // 커피의 설명 출력
        System.out.println(myCoffee.getDescription()); // 출력: Simple coffee, milk
    }
}