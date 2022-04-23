package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayers {

    private final List<RacingPlayer> racingPlayers;

    public RacingPlayers(String racingParticipators) {
        if ("".equals(racingParticipators) || racingParticipators == null) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        this.racingPlayers = new ArrayList<>();
        for (String carPlayerName : racingParticipators.split(",")) {
            this.racingPlayers.add(new RacingPlayer(carPlayerName));
        }
    }

    public Integer numberOfPlayers() {
        return this.racingPlayers.size();
    }
}
