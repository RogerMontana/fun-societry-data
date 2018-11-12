package com.funsocietry.noq.chache;

import com.funsocietry.noq.domain.Category;
import com.funsocietry.noq.domain.Item;
import com.funsocietry.noq.domain.Mod;
import com.funsocietry.noq.domain.TerminalResponse;
import com.funsocietry.noq.service.QrPaymentService;
import lombok.AllArgsConstructor;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;

@AllArgsConstructor
public class ResponseCache {

    private final QrPaymentService qrPaymentService;

    private static final List<Category> category = Arrays.asList(new Category(1, "Coffee Drinks"));
    private static final List<Item> items = Arrays.asList(new Item(1, 1, "Coffee", true, BigDecimal.valueOf(1999)),
            new Item(2, 1, "Drip Coffee", true, BigDecimal.valueOf(999)));

    private static final List<Mod> mods = Arrays.asList(new Mod(1, "Sugar", 10, BigDecimal.valueOf(0.05), Collections.singletonList(1L)),
            new Mod(2, "Milk", 2, BigDecimal.ONE, Collections.singletonList(1L)));

    private static CacheManager cache;

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

    public TerminalResponse getState() throws IOException {
        getInitCache().put("test", new TerminalResponse("test",
                0L, category, items, mods,
                qrPaymentService.getPaymentCode()));
        return getInitCache().get("test");
    }

    private Cache<String, TerminalResponse> getInitCache() {
        return cache.getCache("initCache", String.class, TerminalResponse.class);
    }
}
