package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayer {

    private final int MIN_MOVING_FORWARD_NUMBER = 4;

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

    public boolean tryMovingForward() {
        final int randomNumber = pickNumberInRange(0, 9);
        return randomNumber >= MIN_MOVING_FORWARD_NUMBER;
    }
}
