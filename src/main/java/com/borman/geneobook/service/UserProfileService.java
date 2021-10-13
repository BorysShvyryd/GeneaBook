package com.borman.geneobook.service;

import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.UserProfileRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile findUserByEmail(String email) {
        return userProfileRepository.findByUser_Email(email).orElseThrow(() ->
                new UsernameNotFoundException("UserProfile Not Found with -> email : " + email)
        );
    }

    public UserProfile findUserProfileById(Long id) {
        return userProfileRepository.findUserProfileById(id).orElseThrow(() ->
                new UsernameNotFoundException("UserProfile Not Found with -> id : " + id)
        );
    }

    public List<UserProfile> findAllUserProfile() {
        return userProfileRepository.findAll();
    }

    public void saveUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    public Boolean existUserProfileById(Long id) {
        return userProfileRepository.existsById(id);
    }
}
