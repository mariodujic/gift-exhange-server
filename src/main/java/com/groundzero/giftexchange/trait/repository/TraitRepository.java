package com.groundzero.giftexchange.trait.repository;

import com.groundzero.giftexchange.trait.entity.TraitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<TraitEntity, Integer> {
}
