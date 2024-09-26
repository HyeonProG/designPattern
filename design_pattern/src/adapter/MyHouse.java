package adapter;

public class MyHouse {

    // 정적 메서드(기능)
    // 집에 220V 전기 콘센트를 연결하는 메서드
    public static void homeConnect(IElectronic220V electronic220v) {
        // 청소기, 드라이어기, 냉장고, TV....
        electronic220v.connect();
    }

    public static void main(String[] args) {
        
        // 1. 

        // 집 콘센트에 220V 스펙을 구현한 에어컨을 연결해 보자.
        AirConditioner airConditioner = new AirConditioner();
        homeConnect(airConditioner);

        HairDryer dryer = new HairDryer();
        // 문제 발생
        // homeConnect(dryer); 220V 에는 연결 불가

        // 어댑터 클래스를 가져옴
        ElectronicAdapter hairdryerConnectionAdapter = new ElectronicAdapter(dryer);
        homeConnect(hairdryerConnectionAdapter);
    } // end of main

} // end of MyHouse

// 스펙 : 220V 가전기기 인터페이스
interface IElectronic220V {
    void connect();
}

// 스펙 : 110V 가전기기 인터페이스
interface IElectronic110V {
    void connect();
}


class AirConditioner implements IElectronic220V {
    @Override
    public void connect() {
        System.out.println("에어컨 연결 220V On");
    }
}

class HairDryer implements IElectronic110V {
    @Override
    public void connect() {
        System.out.println("헤어 드라이기 연결 110V On");
    }
}
