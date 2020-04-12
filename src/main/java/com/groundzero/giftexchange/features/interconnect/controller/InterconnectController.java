package com.groundzero.giftexchange.features.interconnect.controller;

import com.groundzero.giftexchange.data.EmptyDataResponse;
import com.groundzero.giftexchange.data.Response;
import com.groundzero.giftexchange.features.interconnect.api.InterconnectRequest;
import com.groundzero.giftexchange.features.interconnect.api.InterconnectResponseData;
import com.groundzero.giftexchange.features.interconnect.base.BaseController;
import com.groundzero.giftexchange.features.interconnect.data.InterconnectDto;
import com.groundzero.giftexchange.features.trait.repository.TraitRepository;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
import com.groundzero.giftexchange.features.user.repository.UserRepository;
import com.groundzero.giftexchange.utils.JwtType;
import com.groundzero.giftexchange.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/interconnect")
public class InterconnectController extends BaseController {

  private final TraitRepository traitRepository;
  private final UserRepository userRepository;

  public InterconnectController(TraitRepository traitRepository, UserRepository userRepository, JwtUtils jwtUtils) {
    super(jwtUtils);
    this.traitRepository = traitRepository;
    this.userRepository = userRepository;
  }

  @PostMapping("/update")
  public Response updateInterconnectStatus(
      @RequestHeader("Authorization") String bearerAuthorization,
      @RequestBody InterconnectRequest request
  ) {
    if (jwtUtils.getTokenType(jwtUtils.getTokenFromBearer(bearerAuthorization)) != JwtType.ACCESS) {
      return new Response(500, "Access token required", new EmptyDataResponse());
    }

    UserEntity userEntity = userRepository.getOne(request.getUserId());
    userEntity.setInterconnect(InterconnectDto.fromRequest(userEntity.getInterconnect(), request));
    userRepository.save(userEntity);

    return new Response(200, "Interconnection successfully changed", new InterconnectResponseData(userEntity.getInterconnect()));
  }
}
