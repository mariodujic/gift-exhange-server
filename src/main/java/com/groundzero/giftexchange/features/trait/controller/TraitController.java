package com.groundzero.giftexchange.features.trait.controller;

import com.groundzero.giftexchange.base.BaseController;
import com.groundzero.giftexchange.data.EmptyDataResponse;
import com.groundzero.giftexchange.data.Response;
import com.groundzero.giftexchange.features.jwt.service.JwtUserDetailsService;
import com.groundzero.giftexchange.features.trait.api.TraitRequest;
import com.groundzero.giftexchange.features.trait.api.TraitResponseData;
import com.groundzero.giftexchange.features.trait.data.TraitDto;
import com.groundzero.giftexchange.features.trait.entity.TraitEntity;
import com.groundzero.giftexchange.features.trait.repository.TraitRepository;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
import com.groundzero.giftexchange.features.user.repository.UserRepository;
import com.groundzero.giftexchange.utils.JwtType;
import com.groundzero.giftexchange.utils.JwtUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trait")
public class TraitController extends BaseController {

  private final TraitRepository traitRepository;
  private final JwtUserDetailsService userDetailsService;

  public TraitController(JwtUtils jwtUtils, TraitRepository traitRepository, UserRepository userRepository, JwtUserDetailsService userDetailsService) {
    super(jwtUtils, userRepository);
    this.traitRepository = traitRepository;
    this.userDetailsService = userDetailsService;
  }

  @PostMapping("/update")
  public Response addTrait(
      @RequestHeader(value = "Authorization") String bearerAuthorization,
      @RequestBody TraitRequest traitRequest
  ) {
    if (jwtUtils.getTokenType(jwtUtils.getTokenFromBearer(bearerAuthorization)) != JwtType.ACCESS) {
      return new Response(500, "Access token required", new EmptyDataResponse());
    }
    UserEntity userEntity = getUserEntityFromToken(bearerAuthorization);
    int traitId = userEntity.getTrait().getId();
    TraitEntity traitEntity = traitRepository.getOne(traitId);
    traitEntity.setId(traitId);
    traitRepository.save(TraitDto.fromRequest(traitEntity, traitRequest));
    return new Response(200, "Trait updated successfully", new TraitResponseData(traitEntity));
  }

  @GetMapping("/get/{id}")
  public Response getTrait(
      @PathVariable("id") int userId
  ) {
    UserEntity userEntity;
    try {
      userEntity = userDetailsService.loadById(userId);
    } catch (UsernameNotFoundException e) {
      return new Response(500, "User not found", new EmptyDataResponse());
    }
    TraitEntity traitEntity = traitRepository.getOne(userEntity.getTrait().getId());
    return new Response(200, "Trait successfully fetched for user with id: " + userId, new TraitResponseData(traitEntity));
  }

  private UserEntity getUserEntityFromToken(String bearerAuthorization) {
    String username = jwtUtils.getUsernameFromToken(bearerAuthorization.substring(7));
    return userRepository.findByUsername(username);
  }
}
