package com.funsocietry.snippy.cache;

import com.funsocietry.snippy.dto.ImgSnippet;
import com.funsocietry.snippy.dto.SnippetRequest;
import com.funsocietry.snippy.dto.SnippetResponse;
import com.funsocietry.snippy.service.ImgService;
import lombok.AllArgsConstructor;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;

@AllArgsConstructor
public class ResponseCache {

    public static final String CACHE = "initCache";
    private final ImgService imgService;

    private static CacheManager cache;

    {
        cache = newCacheManagerBuilder()
                .withCache("initCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, SnippetResponse.class, heap(100)))
                .build(true);
    }

    public Map<String, SnippetResponse> readAllCache(Set<String> keys) {
        return getInitCache().getAll(keys);
    }


    public SnippetResponse readCache(String key) {
        return getInitCache().get(key);
    }

    public void writeCache(SnippetRequest value) {
        UUID uuid = UUID.randomUUID();
        getInitCache().put(uuid.toString(), new SnippetResponse(value.getName(), "test", new ImgSnippet("bytes")));
    }

    public SnippetResponse getState() throws IOException {
        getInitCache().put("test", new SnippetResponse("test", "test",

                imgService.getImage()));
        return getInitCache().get("test");
    }

    private Cache<String, SnippetResponse> getInitCache() {
        return cache.getCache(CACHE, String.class, SnippetResponse.class);
    }
}
