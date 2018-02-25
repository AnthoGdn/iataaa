package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import org.junit.Test;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckersBoardMapperTest {

    @Test
    public void initialCheckersBoardToStringTest() {
        // WHEN
        String checkersString = CheckersBoardMapper.checkersBoardToString(getInitialCheckersBoard());

        // THEN
        assertThat(checkersString).isEqualTo(INITIAL_CHECKERS_BOARD_STRING);
    }

    @Test
    public void mixedCheckersBoardToStringTest() {
        // WHEN
        String checkersString = CheckersBoardMapper.checkersBoardToString(getMixedCheckersBoard());

        // THEN
        assertThat(checkersString).isEqualTo(MIXED_CHECKERS_BOARD_STRING);
    }

    @Test
    public void initialCheckersBoardStringToCheckersBoardTest() {
        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.stringToCheckersBoard(INITIAL_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoard).isEqualTo(getInitialCheckersBoard());
    }

    @Test
    public void mixedCheckersBoardStringToCheckersBoardTest() {
        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.stringToCheckersBoard(MIXED_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoard).isEqualTo(getMixedCheckersBoard());
    }

    @Test
    public void mixedCheckersBoardStringToCheckersBoardDtoTest() {
        // WHEN
        CheckersBoardDto checkersBoardDto = CheckersBoardMapper.stringToCheckersBoardDto(MIXED_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoardDto).isEqualTo(getMixedCheckersBoardDto());
    }
}
