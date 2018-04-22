package io.github.anthogdn.iataaa.checkersApi.repository;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<PlayerEntity, UUID> {

}
