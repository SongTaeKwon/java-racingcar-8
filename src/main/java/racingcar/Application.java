package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountString = Console.readLine();

        int tryCount;
        try {
            tryCount = Integer.parseInt(tryCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수 형태로 입력해야합니다.");
        }

        List<Car> cars = CarFactory.makeCarsFromCarsNameString(carNameString);

        Race race = new Race(cars, tryCount);

        race.startRace();
        race.printWinners();
    }
}
