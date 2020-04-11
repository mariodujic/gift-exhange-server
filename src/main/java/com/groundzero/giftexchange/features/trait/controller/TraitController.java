package com.groundzero.giftexchange.features.trait.controller;

import com.groundzero.giftexchange.data.Response;
import com.groundzero.giftexchange.features.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.features.trait.api.TraitRequest;
import com.groundzero.giftexchange.features.trait.api.TraitResponseData;
import com.groundzero.giftexchange.features.trait.data.TraitDto;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;
import com.groundzero.giftexchange.features.trait.repository.TraitRepository;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
import com.groundzero.giftexchange.features.user.repository.UserRepository;
import com.groundzero.giftexchange.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trait")
public class TraitController {

  private final JwtUtils jwtUtils;
  private final TraitRepository traitRepository;
  private final UserRepository userRepository;
  private final JwtUserDetailsService userDetailsService;

  public TraitController(JwtUtils jwtUtils, TraitRepository traitRepository, UserRepository userRepository, JwtUserDetailsService userDetailsService) {
    this.jwtUtils = jwtUtils;
    this.traitRepository = traitRepository;
    this.userRepository = userRepository;
    this.userDetailsService = userDetailsService;
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

  @GetMapping("/get/{id}")
  public Response getTrait(
      @PathVariable("id") int userId
  ) {
    UserEntity userEntity = userDetailsService.loadById(userId);
    TraitEntity traitEntity = traitRepository.getOne(userEntity.getId());
    return new Response(200, "Trait successfully fetched for user with id: " + userId, new TraitResponseData(traitEntity));
  }

  private UserEntity getUserEntityFromToken(String bearerAuthorization) {
    String username = jwtUtils.getUsernameFromToken(bearerAuthorization.substring(7));
    return userRepository.findByUsername(username);
  }
}
