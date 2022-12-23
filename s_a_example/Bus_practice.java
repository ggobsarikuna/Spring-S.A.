package s_a_example;

public class Bus_practice{
    int max_passenger = 30;
    int crt_passenger = 0;
    int pay = 1000;
    final int BUS_NUM;
    int oil = 100;
    int speed = 100;
    String ride = "운행";
    String back = "차고지행";
    boolean bus_state = false;

    Bus_practice(int BUS_NUM){
        this.BUS_NUM = BUS_NUM;
        System.out.println(BUS_NUM + "번 버스입니다!");
        state(ride);
    }

    public void state(String state){ //운행 상태 true면 운행 false면 차고지행
        if (state.equals(ride)){
            bus_state = true;
        } else {
            bus_state = false;
        }
    }

    public void setOil(int setOil){ //오일
        oil += setOil;
        System.out.println("주유량: " + oil);

        if (oil < 10){
            System.out.println("주유가 필요합니다.");
            state(back);
            System.out.println(back);
        } else {
            state(ride);
            System.out.println(ride);
        }
    }

    public void passenger(int person){
        if (!bus_state){ //차고지행 버스면 함수 실행 X
            return;
        }
        crt_passenger += person;

        if (crt_passenger > max_passenger){ //최대 승객 수 초과하면 남은 좌석수 0, 승객수는 최대
            person = max_passenger;
            crt_passenger = max_passenger;
            System.out.println("최대 승객 수를 초과했습니다.");
        }

        System.out.println("탑승 승객 수 = " + person);
        System.out.println("잔여 승객 수 = " + (max_passenger - person));
        System.out.println("요금 확인 = " + (person * pay));
    }

    public void setSpeed(int setSpeed){
        if (oil < 10){ //주유량 10 미만이면 운행 안하므로 함수 실행 X
            System.out.println("주유량을 확인해 주세요.");
            return;
        }

        speed += setSpeed;
        System.out.println("속도: " + speed);
    }
}
