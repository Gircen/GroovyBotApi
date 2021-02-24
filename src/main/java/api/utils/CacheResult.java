package api.utils;

import api.impl.handlers.HandlerResultImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CacheResult {
    private List<HandlerResultImpl> handlerResultList;

    public void initPersons(List<HandlerResultImpl> handlerResultList) {
        this.handlerResultList.addAll(handlerResultList);
    }

    private HandlerResultImpl findByName(String name) {
        HandlerResultImpl handlerResult = handlerResultList.stream()
                .filter(p -> p.getClass().equals(name))
                .findFirst()
                .orElse(null);
        return handlerResult;
    }

    @Cacheable(cacheNames="HandlerResult")
    public HandlerResultImpl findCacheByName(String name) {
        final  HandlerResultImpl handlerResult = findByName(name);
        return handlerResult;
    }

}
