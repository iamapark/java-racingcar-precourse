package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayerMovingTest {

    private final RacingPlayer mangoPlayer = new RacingPlayer("mango");

    @Test @DisplayName("RacingPlayerMoving: 경주 플레이어가 생성한 랜덥 값이 4 이상인 경우 전진하는지 검증")
    void 생성한_랜덤값이_4이상인경우_전진하는지_RacingPlayerMoving_test() {
        assertPlayerTryForwardResult(4, true);
    }

    @Test @DisplayName("RacingPlayerMoving: 경주 플레이어가 생성한 랜덤 값이 3 이하인 경우 멈추는지 검증")
    void 생성한_랜덤값이_3이하인경우_멈추는지_RacingPlayerMoving_test() {
        assertPlayerTryForwardResult(3, false);
        assertPlayerTryForwardResult(2, false);
        assertPlayerTryForwardResult(1, false);
    }

    void assertPlayerTryForwardResult(Integer expectedRandomNumber, boolean expectedPlayerMovingForwardResult) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(expectedRandomNumber);
            assertEquals(expectedPlayerMovingForwardResult, mangoPlayer.tryMovingForward());
        }
    }
}
