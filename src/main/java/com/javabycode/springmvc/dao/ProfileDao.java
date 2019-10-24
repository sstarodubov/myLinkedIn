package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Profile;
import com.javabycode.springmvc.model.Skills;
import org.springframework.stereotype.Repository;

@Repository("profileDao")
public class ProfileDao extends AbstractDao<Integer, Profile>{

    public void saveSkills(Profile profile) {
        persist(profile);
    }
    
    public void updateProfile(Profile profile, Skills skills, String photo) {
        profile.setSkills(skills);
        profile.setPhoto(photo);
        getSession().update(profile);
    }
}
