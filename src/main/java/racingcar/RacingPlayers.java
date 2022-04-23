package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayers {

    private final List<RacingPlayer> racingPlayers;

    protected RacingPlayers(String racingParticipators) {
        if ("".equals(racingParticipators) || racingParticipators == null) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        this.racingPlayers = new ArrayList<>();
        for (String carPlayerName : racingParticipators.split(",")) {
            this.racingPlayers.add(new RacingPlayer(carPlayerName));
        }
    }

    public static RacingPlayers getRacingPlayersFromUserConsoleInput() {
        final String racingParticipators = Console.readLine();
        try {
            return new RacingPlayers(racingParticipators);
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            return getRacingPlayersFromUserConsoleInput();
        }
    }

    protected Integer numberOfPlayers() {
        return this.racingPlayers.size();
    }

    public List<RacingPlayer> getRacingPlayers() {
        return racingPlayers;
    }

    public void play(RacingMovingRound racingMovingRound) {
        System.out.println("실행 결과");
        for (int round = 0; round < racingMovingRound.movingNumber(); round++) {
            startRound();
        }
        printFinalResult();
    }

    private void printFinalResult() {
        final RacingWinners racingWinners = RacingWinners.getRacingWinners(this);
        final StringBuilder winnerNames = new StringBuilder();
        for (RacingPlayer winner : racingWinners.getRacingWinners()) {
            winnerNames.append(winner.getCarPlayerName()).append(",");
        }
        System.out.println("최종 우승자: " + winnerNames.deleteCharAt(winnerNames.length() - 1));
    }

    private void startRound() {
        for (RacingPlayer racingPlayer : this.racingPlayers) {
            racingPlayer.tryMovingForward();
            racingPlayer.printCurrentStatus();
        }
        System.out.println();
    }
}
