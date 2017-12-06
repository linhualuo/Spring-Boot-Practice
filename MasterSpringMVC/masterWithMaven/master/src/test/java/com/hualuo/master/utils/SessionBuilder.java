package com.hualuo.master.utils;

import com.hualuo.master.profile.UserProfileSession;
import org.springframework.mock.web.MockHttpSession;

import java.util.Arrays;

/**
 * @author Joseph
 * @create 2017/12/6 17:59
 */
public class SessionBuilder {

    private final MockHttpSession session;

    UserProfileSession userProfileSession;

    public SessionBuilder() {
        session = new MockHttpSession();
        userProfileSession = new UserProfileSession();
        session.setAttribute("scopedTarget.userProfileSession", userProfileSession);
    }

    public SessionBuilder useTastes(String... tastes) {
        userProfileSession.setTastes(Arrays.asList(tastes));
        return this;
    }

    public MockHttpSession build() {
        return session;
    }
}
