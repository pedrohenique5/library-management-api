package com.pedrohenrique.library_management_api.core.application.usecases.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.profile.request.ProfileRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.stereotype.Component;

@Component
public class CreateProfileUseCase {
    private final ProfileRepository profileRepository;

    public CreateProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile execute(ProfileRequestDTO dto){
        Profile profile = new Profile(null, dto.name(), dto.loanLimit(), dto.loanPeriodDays());
        return profileRepository.save(profile);
    }
}
