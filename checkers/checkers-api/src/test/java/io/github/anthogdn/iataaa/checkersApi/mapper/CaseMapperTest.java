package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseMapperTest {

    @Test
    public void stringToEmptyCaseTest() {
        // WHEN
        CaseDto c = CaseMapper.stringToCaseDto(" ");

        // THEN
        assertThat(c).isEqualTo(CaseDto.EMPTY);
    }

    @Test
    public void stringToWhitePieceCaseTest() {
        // WHEN
        CaseDto c = CaseMapper.stringToCaseDto("x");

        // THEN
        assertThat(c).isEqualTo(CaseDto.WHITE_PIECE);
    }

    @Test
    public void stringToWhiteQueenCaseTest() {
        // WHEN
        CaseDto c = CaseMapper.stringToCaseDto("X");

        // THEN
        assertThat(c).isEqualTo(CaseDto.WHITE_QUEEN);
    }

    @Test
    public void stringToBlackPieceCaseTest() {
        // WHEN
        CaseDto c = CaseMapper.stringToCaseDto("o");

        // THEN
        assertThat(c).isEqualTo(CaseDto.BLACK_PIECE);
    }

    @Test
    public void stringToBlackQueenCaseTest() {
        // WHEN
        CaseDto c = CaseMapper.stringToCaseDto("O");

        // THEN
        assertThat(c).isEqualTo(CaseDto.BLACK_QUEEN);
    }

    @Test
    public void stringToCaseShouldGetExceptionTest() {
        // GIVEN
        boolean throww = false;

        // WHEN
        try {
            CaseMapper.stringToCaseDto("xx");
        } catch (Exception e) {
            throww = true;
        }

        // THEN
        assertThat(throww).isTrue();
    }
}
