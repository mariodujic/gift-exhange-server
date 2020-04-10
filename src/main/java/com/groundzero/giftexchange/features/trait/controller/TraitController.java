package com.groundzero.giftexchange.features.trait.controller;

import com.groundzero.giftexchange.data.Response;
import com.groundzero.giftexchange.utils.JwtUtils;
import com.groundzero.giftexchange.features.trait.repository.TraitRepository;
import com.groundzero.giftexchange.features.trait.api.TraitRequest;
import com.groundzero.giftexchange.features.trait.api.TraitResponseData;
import com.groundzero.giftexchange.features.trait.data.TraitDto;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
import com.groundzero.giftexchange.features.user.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trait")
public class TraitController {

  private final JwtUtils jwtUtils;
  private final TraitRepository traitRepository;
  private final UserRepository userRepository;

  public TraitController(JwtUtils jwtUtils, TraitRepository traitRepository, UserRepository userRepository) {
    this.jwtUtils = jwtUtils;
    this.traitRepository = traitRepository;
    this.userRepository = userRepository;
  }

  @PostMapping("/add")
  public Response addTrait(
      @RequestHeader(value = "Authorization") String bearerAuthorization,
      @RequestBody TraitRequest traitRequest
  ) {
    UserEntity userEntity = getUserEntityFromToken(bearerAuthorization);
    int traitId = userEntity.getTrait().getId();
    TraitEntity traitEntity = TraitDto.fromRequest(traitRequest);
    traitEntity.setId(traitId);
    traitRepository.save(traitEntity);
    return new Response(200, "Trait added", new TraitResponseData(traitEntity));
  }

  private UserEntity getUserEntityFromToken(String bearerAuthorization) {
    String username = jwtUtils.getUsernameFromToken(bearerAuthorization.substring(7));
    return userRepository.findByUsername(username);
  }
}
