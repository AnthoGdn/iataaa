package io.github.anthogdn.iataaa.checkersApi.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckersEntityTest {

    @Test
    public void instantiateCheckersEntity() {
        // WHEN
        CheckersEntity checkersEntity = new CheckersEntity();

        // THEN
        assertThat(checkersEntity.getId()).isNotEmpty();
    }
}
