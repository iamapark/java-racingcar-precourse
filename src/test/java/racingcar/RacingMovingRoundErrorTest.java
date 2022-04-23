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
public class RacingMovingRoundErrorTest extends StandardOutputAssertionTest {

    @Test @DisplayName("사용자로부터 값을 입력 받아서 몇 번 이동할 것인지 저장. 잘못된 값을 입력 받는 경우 적절한 에러 문구를 출력하는지 검증: 숫자 이외의 문자 입력")
    void 숫자_이외의_문자_입력받는경우_적절한_에러문구를_출력하는지_검증_RacingMovingNumber_test() {
        assertGetRacingMovingNumberPrintProperErrorMessage("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.", "!@#!@", "5");
    }

    @Test @DisplayName("사용자로부터 값을 입력 받아서 몇 번 이동할 것인지 저장. 잘못된 값을 입력 받는 경우 적절한 에러 문구를 출력하는지 검증: 1보다 작은 숫자 입력")
    void _1보다_작은_값을_입력받는경우_적절한_에러문구를_출력하는지_검증_RacingMovingNumber_test() {
        assertGetRacingMovingNumberPrintProperErrorMessage("[ERROR] 0보다 큰 숫자를 입력해야 합니다.", "0", "5");
    }

    void assertGetRacingMovingNumberPrintProperErrorMessage(String expectedErrorMessage, String expectedReadLine, String... expectedReadLineValues) {
        try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn(expectedReadLine, expectedReadLineValues);
            RacingMovingRound.getRacingMovingRound();
            assertEquals(expectedErrorMessage, output());
        }
    }
}
