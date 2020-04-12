package com.groundzero.giftexchange.features.interconnect.controller;

import com.groundzero.giftexchange.data.EmptyDataResponse;
import com.groundzero.giftexchange.data.Response;
import com.groundzero.giftexchange.features.interconnect.api.InterconnectRequest;
import com.groundzero.giftexchange.features.interconnect.api.InterconnectResponseData;
import com.groundzero.giftexchange.features.interconnect.base.BaseController;
import com.groundzero.giftexchange.features.interconnect.data.InterconnectDto;
import com.groundzero.giftexchange.features.interconnect.entity.InterconnectEntity;
import com.groundzero.giftexchange.features.interconnect.repository.InterconnectRepository;
import com.groundzero.giftexchange.features.trait.repository.TraitRepository;
import com.groundzero.giftexchange.features.user.entity.UserEntity;
import com.groundzero.giftexchange.features.user.repository.UserRepository;
import com.groundzero.giftexchange.utils.JwtType;
import com.groundzero.giftexchange.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interconnect")
public class InterconnectController extends BaseController {

  private final InterconnectRepository interconnectRepository;
  private final TraitRepository traitRepository;

  public InterconnectController(TraitRepository traitRepository, UserRepository userRepository, JwtUtils jwtUtils, InterconnectRepository interconnectRepository) {
    super(jwtUtils, userRepository);
    this.traitRepository = traitRepository;
    this.interconnectRepository = interconnectRepository;
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

    for (String i : traitEligibilityVerification(userEntity)) {
      return new Response(500, "Not eligible. " + i, new EmptyDataResponse());
    }

    InterconnectEntity interconnectEntity = interconnectRepository.getOne(userEntity.getInterconnect().getId());
    userEntity.setInterconnect(InterconnectDto.fromRequest(interconnectEntity, request));
    userRepository.save(userEntity);
    return new Response(200, "Interconnection successfully updated", new InterconnectResponseData(userEntity.getInterconnect()));
  }

  private List<String> traitEligibilityVerification(UserEntity userEntity) {
    List<String> errors = new ArrayList<>();
    if (userEntity.getTrait().getDescription() == null) {
      errors.add("Trait description is missing");
    }
    return errors;
  }
}
