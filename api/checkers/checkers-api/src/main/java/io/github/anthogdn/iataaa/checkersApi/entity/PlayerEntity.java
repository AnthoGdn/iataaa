package io.github.anthogdn.iataaa.checkersApi.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@javax.persistence.Entity
public class PlayerEntity extends AbstractEntity implements Entity {

    public PlayerEntity() {
        this.token = UUID.randomUUID().toString();
    }

    public PlayerEntity(String name, PlayerNbEntity playerNbEntity) {
        this();
        this.name = name;
        this.playerNb = playerNbEntity;
    }

    @NotNull
    @Size(min=1)
    private String name;
    @NotNull
    private PlayerNbEntity playerNb;
    @NotNull
    @Size(min=1)
    private String token;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PlayerNbEntity getPlayerNb() {
        return playerNb;
    }
    public void setPlayerNb(PlayerNbEntity playerNb) {
        this.playerNb = playerNb;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "name='" + name + '\'' +
                ", playerNb=" + playerNb +
                ", token='" + token + '\'' +
                '}';
    }
}
