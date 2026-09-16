package com.pedrohenrique.library_management_api.core.application.usecases.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.ProfileNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteProfileUseCase {
    private final ProfileRepository profileRepository;
    public DeleteProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public void execute(Long id) {
        profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        profileRepository.delete(id);
    }
}
