package com.pedrohenrique.library_management_api.core.application.usecases.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.profile.request.ProfileRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.ProfileNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.stereotype.Component;

@Component
public class UpdateProfileUseCase {
    private final ProfileRepository profileRepository;
    public UpdateProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public Profile execute(Long id, ProfileRequestDTO dto){
        Profile existing = profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        existing.setName(dto.name());
        existing.setLoanLimit(dto.loanLimit());
        existing.setLoanPeriodDays(dto.loanPeriodDays());
        return profileRepository.save(existing);
    }
}
