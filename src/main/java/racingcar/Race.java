package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;
    private int count;

    public Race(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("적어도 1개 이상의 차량이 있어야 합니다.");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("최소 1번 이상의 시도를 해야합니다.");
        }
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        String winnerString = winners.stream().map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerString);
    }

    public List<Car> getWinners() {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == max)
                .toList();
    }

    public void startRace() {
        while (count-- > 0) {
            tryOnce();
        }
    }

    private void tryOnce() {
        progressTurn();
        printPosition();
        System.out.println();
    }

    private void progressTurn() {
        cars.forEach(Car::progressTurn);
    }

    private void printPosition() {
        cars.forEach(Car::printPosition);
    }
}
