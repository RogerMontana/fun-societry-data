package com.funsocietry.noq.chache;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.funsocietry.noq.domain.Category;
import com.funsocietry.noq.domain.Item;
import com.funsocietry.noq.domain.Mod;
import com.funsocietry.noq.domain.TerminalResponse;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;


public class ResponseCache {

    private static final List<Category> category = Arrays.asList(new Category(1,"Coffee Drinks"));
    private static final List<Item> items = Arrays.asList(new Item(1, 1, "Coffee", true, BigDecimal.valueOf(19.99)),
                                                          new Item(2, 1, "Drip Coffee", true, BigDecimal.valueOf(9.99)));

    private static final List<Mod> mods = Arrays.asList(new Mod(1, "Sugar", 10, BigDecimal.valueOf(0.05), Collections.singletonList(1L)),
                                                        new Mod(2, "Milk", 2, BigDecimal.ONE, Collections.singletonList(1L)));

    private CacheManager cache;

    {
        cache = newCacheManagerBuilder()
                        .withCache("initCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, TerminalResponse.class, heap(100)))
                        .build(true);
    }

    public Map<String, TerminalResponse> readAllCache(Set<String> keys) {
        return getInitCache().getAll(keys);
    }


    public TerminalResponse readCache(String key) {
        return getInitCache().get(key);
    }

    public void writeCache(String key, TerminalResponse value) {
        getInitCache().put(key, value);
    }

    public void writeAllCache(String key, TerminalResponse value) {
        getInitCache().put(key, value);
    }

    public TerminalResponse getState() {
        getInitCache().put("test", new TerminalResponse("test", DateTime.now().getMillis(), category, items, mods));
        return getInitCache().get("test");
    }

    private Cache<String, TerminalResponse> getInitCache() {
        return cache.getCache("initCache", String.class, TerminalResponse.class);
    }
}
