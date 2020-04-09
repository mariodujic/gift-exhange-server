package com.groundzero.giftexchange.trait.controller;

import com.groundzero.giftexchange.common.Response;
import com.groundzero.giftexchange.jwt.utils.JwtUtils;
import com.groundzero.giftexchange.trait.repository.TraitRepository;
import com.groundzero.giftexchange.trait.api.TraitRequest;
import com.groundzero.giftexchange.trait.api.TraitResponseData;
import com.groundzero.giftexchange.trait.data.TraitDto;
import com.groundzero.giftexchange.trait.entity.TraitEntity;
import com.groundzero.giftexchange.user.entity.UserEntity;
import com.groundzero.giftexchange.user.repository.UserRepository;
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
