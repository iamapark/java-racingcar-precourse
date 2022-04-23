package racingcar;

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
            throw new IllegalArgumentException();
        }

        if (this.movingNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
