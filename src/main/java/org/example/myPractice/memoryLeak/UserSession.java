package org.example.myPractice.memoryLeak;

public class UserSession {
    private String sessionId;
    private String userData;

    public UserSession(String sessionId, String userData) {
        this.sessionId = sessionId;
        this.userData = userData;
    }

    // Getters and Setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}
