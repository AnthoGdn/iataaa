package io.github.anthogdn.iataaa.checkersApi.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractEntityTest {
    private class Entity extends AbstractEntity {
    }

    @Test
    public void instantiateEntity() {
        // WHEN
        Entity entity = new Entity();

        // THEN
        assertThat(entity.getId()).isNotNull();
    }
}
