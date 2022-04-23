package racingcar;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayer {

    private final String carPlayerName;

    public RacingPlayer(String carPlayerName) {
        if ("".equals(carPlayerName) || carPlayerName == null) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }

        if (carPlayerName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘길 수 없습니다.");
        }

        this.carPlayerName = carPlayerName;
    }
}
