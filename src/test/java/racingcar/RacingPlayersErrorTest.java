package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import util.StandardOutputAssertionTest;

/**
 * @author jinyoung
 * @date 2022/04/23
 */
public class RacingPlayersErrorTest extends StandardOutputAssertionTest {

    @Test
    @DisplayName("사용자로부터 값을 입력 받아서 레이싱 플레이어를 식별. 잘못된 값을 입력 받는 경우 적절한 에러 문구를 출력하는지 검증")
    void 잘못된_값을_입력받는경우_적절한_에러문구를_출력하는지_검증_RacingPlayers_test() {
        assertGetRacingPlayersPrintProperErrorMessage("[ERROR] 자동차 이름은 5글자를 넘길 수 없습니다.", "pobi,mango-hello", "pobi,mango");
    }

    void assertGetRacingPlayersPrintProperErrorMessage(String expectedErrorMessage, String expectedReadLine, String... expectedReadLineValues) {
        try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn(expectedReadLine, expectedReadLineValues);
            RacingPlayers.getRacingPlayersFromUserConsoleInput();
            assertEquals(expectedErrorMessage, output());
        }
    }
}
