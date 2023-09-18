package com.rd.epam.autotasks.scopes.config.threetimes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeTimesScope implements Scope {

    private static final int QUANTITY_REQUESTS = 3;
    private static int counterBeans;
    private final Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<>());
    private final Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String bean, ObjectFactory<?> objectFactory) {
        ++counterBeans;
        if (!scopedObjects.containsKey(bean) || counterBeans == QUANTITY_REQUESTS) {
            scopedObjects.put(bean, objectFactory.getObject());
            counterBeans = 0;
        }
        return scopedObjects.get(bean);
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
        return "threeTimes";
    }
}