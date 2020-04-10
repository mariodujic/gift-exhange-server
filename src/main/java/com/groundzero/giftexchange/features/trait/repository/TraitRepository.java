package com.groundzero.giftexchange.features.trait.repository;

import com.groundzero.giftexchange.features.trait.entity.TraitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<TraitEntity, Integer> {
}
