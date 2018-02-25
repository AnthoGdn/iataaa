package io.github.anthogdn.iataaa.checkersApi.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerEntityTest {

    @Test
    public void instantiatePlayerEntity() {
        // WHEN
        PlayerEntity playerEntity = new PlayerEntity();

        // THEN
        assertThat(playerEntity.getId()).isNotEmpty();
        assertThat(playerEntity.getToken()).isNotEmpty();
    }
}
