package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public static List<Car> makeCarsFromCarsNameString(String carNameString) {
        return Arrays.stream(carNameString.split(",")).map(String::strip).map(Car::new).toList();
    }
}
