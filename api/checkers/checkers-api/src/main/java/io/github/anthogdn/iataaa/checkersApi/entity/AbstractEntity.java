package io.github.anthogdn.iataaa.checkersApi.entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
abstract class AbstractEntity implements Entity {
    @Id
    private String id;

    AbstractEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
