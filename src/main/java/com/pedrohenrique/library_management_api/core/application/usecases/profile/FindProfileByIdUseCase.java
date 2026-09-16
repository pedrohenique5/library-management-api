package com.pedrohenrique.library_management_api.core.application.usecases.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.ProfileNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.stereotype.Component;

@Component
public class FindProfileByIdUseCase {
    private final ProfileRepository profileRepository;
    public FindProfileByIdUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public Profile execute(Long id){
        return profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
    }
}
