package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingMovingNumber {

    private final Integer movingNumber;

    public RacingMovingNumber(String movingNumber) {
        if ("".equals(movingNumber) || movingNumber == null) {
            throw new IllegalArgumentException();
        }

        try {
            this.movingNumber = Integer.valueOf(movingNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }

        if (this.movingNumber <= 0) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해야 합니다.");
        }
    }

    public static RacingMovingNumber getMovingNumberFromUserConsoleInput() {
        final String movingNumber = Console.readLine();
        try {
            return new RacingMovingNumber(movingNumber);
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            return getMovingNumberFromUserConsoleInput();
        }
    }
}
