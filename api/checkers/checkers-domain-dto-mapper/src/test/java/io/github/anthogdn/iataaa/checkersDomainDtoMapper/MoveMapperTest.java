package io.github.anthogdn.iataaa.checkersDomainDtoMapper;

import io.github.anthogdn.iataaa.checkersDomain.model.Move;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersPossibleMovesResponseDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static io.github.anthogdn.iataaa.checkersTestUtil.MoveUtil.getInitialMoveSet;
import static org.assertj.core.api.Assertions.assertThat;

public class MoveMapperTest {

    @Test
    public void moveSetToCheckersPossibleMovesResponseDtoTest() {
        // GIVEN
        Set<Move> moveSet = getInitialMoveSet();

        // WHEN
        CheckersPossibleMovesResponseDto dto = MoveMapper.moveSetToCheckersPossibleMovesResponseDto(moveSet);

        // THEN
        assertThat(dto).isNotNull();
        assertThat(dto.getPossibleMoves().size()).isEqualTo(moveSet.size());
    }
}
