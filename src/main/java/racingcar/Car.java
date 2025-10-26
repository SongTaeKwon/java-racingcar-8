package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int POINT = 4;

    private final String name;
    private int position;

    public Car(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        } else if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 자동차 이름: " + name);
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progressTurn() {
        if (tryMove()) {
            go();
        } else {
            stop();
        }
    }

    public void printPosition() {
        String positionString = name + " : " + "-".repeat(position);
        System.out.println(positionString);
    }

    private void go() {
        position++;
    }

    private void stop() {
    }

    private static boolean tryMove() {
        return Randoms.pickNumberInRange(MIN, MAX) >= POINT;
    }
}
