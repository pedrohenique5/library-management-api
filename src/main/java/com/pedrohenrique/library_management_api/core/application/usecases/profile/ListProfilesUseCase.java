package com.pedrohenrique.library_management_api.core.application.usecases.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProfilesUseCase {
    private final ProfileRepository profileRepository;
    public ListProfilesUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public List<Profile> execute() {
        return profileRepository.findAll();
    }
}
