package com.funsocietry.vision.chache;

import java.util.Map;
import java.util.Set;

import com.funsocietry.vision.domain.ImageSnapshot;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;


public class ImageCache {

    private CacheManager cache;

    {
        cache = newCacheManagerBuilder()
                        .withCache("initCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, ImageSnapshot.class, heap(100)))
                        .build(true);
    }

    public Map<String, ImageSnapshot> readAllCache(Set<String> keys) {
        return getInitCache().getAll(keys);
    }


    public ImageSnapshot readCache(String key) {
        return getInitCache().get(key);
    }

    public void writeCache(String key, ImageSnapshot value) {
        getInitCache().put(key, value);
    }

    public void writeAllCache(String key, ImageSnapshot value) {
        getInitCache().put(key, value);
    }

    public ImageSnapshot health() {
        getInitCache().put("test", new ImageSnapshot("test", 111111L, "BYTES"));
        return getInitCache().get("test");
    }

    private Cache<String, ImageSnapshot> getInitCache() {
        return cache.getCache("initCache", String.class, ImageSnapshot.class);
    }
}