package racingcar;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingGame {

    public void start() {
        final RacingPlayers racingPlayers = getRacingPlayers();
        System.out.println("numberOfPlayers: " + racingPlayers.numberOfPlayers());

        final RacingMovingNumber racingMovingNumber = getRacingMovingNumber();
    }

    private RacingMovingNumber getRacingMovingNumber() {
        System.out.println("시도할 횟수");
        return RacingMovingNumber.getMovingNumberFromUserConsoleInput();
    }

    private RacingPlayers getRacingPlayers() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return RacingPlayers.getRacingPlayersFromUserConsoleInput();
    }
}
