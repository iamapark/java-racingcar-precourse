package racingcar;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingGame {

    public void start() {
        final RacingPlayers racingPlayers = getRacingPlayers();
        final RacingMovingRound racingMovingNumber = getRacingMovingNumber();
        racingPlayers.play(racingMovingNumber);
    }

    private RacingMovingRound getRacingMovingNumber() {
        System.out.println("시도할 횟수");
        return RacingMovingRound.getRacingMovingRound();
    }

    private RacingPlayers getRacingPlayers() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return RacingPlayers.getRacingPlayersFromUserConsoleInput();
    }
}
