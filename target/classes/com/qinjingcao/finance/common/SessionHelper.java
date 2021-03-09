package com.qinjingcao.finance.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionHelper implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event) {
    }
    /* Session失效事件 */
    public void sessionDestroyed(HttpSessionEvent event) {
        LockHelper.moveSession(event.getSession());
    }
}
