package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import org.junit.Test;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckersBoardMapperTest {

    @Test
    public void initialCheckersBoardToString_Test() {
        // WHEN
        String checkersString = CheckersBoardMapper.checkersBoardToString(getInitialCheckersBoard());

        // THEN
        assertThat(checkersString).isEqualTo(INITIAL_CHECKERS_BOARD_STRING);
    }

    @Test
    public void mixedCheckersBoardToString_Test() {
        // WHEN
        String checkersString = CheckersBoardMapper.checkersBoardToString(getMixedCheckersBoard());

        // THEN
        assertThat(checkersString).isEqualTo(MIXED_CHECKERS_BOARD_STRING);
    }

    @Test
    public void initialCheckersBoardStringToCheckersBoard_Test() {
        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.stringToCheckersBoard(INITIAL_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoard).isEqualTo(getInitialCheckersBoard());
    }

    @Test
    public void mixedCheckersBoardStringToCheckersBoard_Test() {
        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.stringToCheckersBoard(MIXED_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoard).isEqualTo(getMixedCheckersBoard());
    }

    @Test
    public void mixedCheckersBoardStringToCheckersBoardDto_Test() {
        // WHEN
        CheckersBoardDto checkersBoardDto = CheckersBoardMapper.stringToCheckersBoardDto(MIXED_CHECKERS_BOARD_STRING);

        // THEN
        assertThat(checkersBoardDto).isEqualTo(getMixedCheckersBoardDto());
    }

    @Test
    public void checkersBoardDtoToCheckersBoard_Test_WithInitialBoard() {
        // WHEN
        CheckersBoardDto checkersBoardDto = getInitialCheckersBoardDto();

        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.checkersBoardDtoToCheckersBoard(checkersBoardDto);

        // THEN
        assertThat(checkersBoard).isEqualTo(getInitialCheckersBoard());
    }

    @Test
    public void checkersBoardDtoToCheckersBoard_Test_WithMixedBoard() {
        // WHEN
        CheckersBoardDto checkersBoardDto = getMixedCheckersBoardDto();

        // WHEN
        CheckersBoard checkersBoard = CheckersBoardMapper.checkersBoardDtoToCheckersBoard(checkersBoardDto);

        // THEN
        assertThat(checkersBoard).isEqualTo(getMixedCheckersBoard());
    }
}
