package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.model.Profile;
import com.javabycode.springmvc.model.Skills;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository("profileDao")
public class ProfileDao extends AbstractDao<Integer, Profile>{

    public void saveProfile(Profile profile) {
        persist(profile);
    }

    public void updateProfile(Profile profile, Skills skills, String photo) {
        profile.setSkills(skills);
        profile.setPhoto(photo);
        getSession().update(profile);
    }

    public Profile findProfileByAccountId(Account account) {
        Query query = getSession().createQuery("from Profile p where p.account=:account");
        query.setEntity("account", account);
        Profile profile = (Profile) query.uniqueResult();
        return profile;
    }
}
