package io.github.anthogdn.iataaa.checkersApi;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;

public class PlayerUtil {

    private PlayerUtil() {
    }

    public static PlayerEntity getPlayer(String token, String name, PlayerNbEntity playerNbEntity) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(name);
        playerEntity.setToken(token);
        playerEntity.setPlayerNb(playerNbEntity);

        return playerEntity;
    }
}
