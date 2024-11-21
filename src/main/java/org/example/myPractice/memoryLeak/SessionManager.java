package org.example.myPractice.memoryLeak;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class SessionManager {
    // 静态集合，保存用户会话
//    private static Map<String, UserSession> sessionMap = new HashMap<>();
    private static Map<String, UserSession> sessionMap = new WeakHashMap<>();
    public static void addSession(String sessionId, String userData) {
        sessionMap.put(sessionId, new UserSession(sessionId, userData));
    }
    public static UserSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        // 模拟用户登录并创建会话
        addSession("123", "User1 Data");
        addSession("456", "User2 Data");

        // 获取会话
        UserSession session = getSession("123");
        System.out.println("Session Data: " + session.getUserData());

        // 用户登出，移除会话
        removeSession("123");

        // 此时 sessionMap 仍然可能包含大量未被及时移除的会话数据
        // 如果我们没有及时调用 removeSession，或者在大量会话创建后没有进行清理，会导致内存泄漏

        // 在某些情况下，即使用户已经不再使用这些会话，sessionMap 也会保留对它们的引用，导致内存无法被回收
    }
}
