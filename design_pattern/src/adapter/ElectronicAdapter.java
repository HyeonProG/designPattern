package adapter;

// 핵심 개념
// 어댑터 클래스는 두 객체 간의 중재자로서, 서로 다른 인터페이스를 가진
// 객체들이 함께 동작할 수 있게 한다.

// 어댑터 클래스 : 110V 기기를 220V 전압에서 사용 가능 하도록 변환하는 역할
// 2. 변환하고자 하는 스펙을 구현해야 한다.
public class ElectronicAdapter implements IElectronic220V {

    // 1. 변환 시킬 스펙을 포함 관계로 가지고 있어야 한다.
    private IElectronic110V electronic110v;

    // 3. 생성자를 통해 110V 가전기기를 주입 받는다.
    // 이를 통해 110V와 220V를 연결할 수 있도록 처리
    public ElectronicAdapter(IElectronic110V electronic110v) {
        // 맴버변수에 초기화 처리
        this.electronic110v = electronic110v;
    }

    @Override
    public void connect() {
        // 어댑터는 220V 인터페이스로 호출된 메서드를
        // 110V 기기의 connect()로 변환하여 실행
        electronic110v.connect();
        System.out.println("어댑터를 통해 110v 가전기기를 220v 스펙에 연결합니다.");
    }

}
