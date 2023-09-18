package com.rd.epam.autotasks.scopes.config.justasecond;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JustSecondScope implements Scope {

    private final Map<String, Long> beanTimes = Collections.synchronizedMap(new HashMap<>());
    private final Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<>());
    private final Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String bean, ObjectFactory<?> objectFactory) {
        createObj(bean, objectFactory);
        if (!isActual(bean)) {
            beanTimes.remove(bean);
            remove(bean);
            createObj(bean, objectFactory);
        }
        return scopedObjects.get(bean);
    }

    private boolean isActual(String bean) {
        long borderLife = 1000;
        long currentTime = System.currentTimeMillis();
        return currentTime - beanTimes.get(bean) < borderLife;
    }

    private void createObj(String bean, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(bean)) {
            scopedObjects.put(bean, objectFactory.getObject());
            beanTimes.put(bean, System.currentTimeMillis());
        }
    }

    @Override
    public Object remove(String bean) {
        destructionCallbacks.remove(bean);
        return scopedObjects.remove(bean);
    }

    @Override
    public void registerDestructionCallback(String bean, Runnable callback) {
        destructionCallbacks.put(bean, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "justASecond";
    }
}