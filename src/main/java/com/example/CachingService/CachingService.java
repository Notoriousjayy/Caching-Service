package com.example.CachingService;

import net.spy.memcached.MemcachedClient;
import java.io.IOException;
import java.net.InetSocketAddress;

public class CachingService {
    private MemcachedClient memcachedClient;

    public CachingService(String cacheEndpoint, int cachePort) throws IOException {
        memcachedClient = new MemcachedClient(new InetSocketAddress(cacheEndpoint, cachePort));
    }

    public void put(String key, Object value, int expirationTimeInSeconds) {
        memcachedClient.set(key, expirationTimeInSeconds, value);
    }

    public Object get(String key) {
        return memcachedClient.get(key);
    }

    public void delete(String key) {
        memcachedClient.delete(key);
    }

    public void close() {
        memcachedClient.shutdown();
    }

//    public class YourApplication {
//        public static void main(String[] args) {
//            try (CachingService cachingService = new CachingService("your-elasticache-endpoint", 11211)) {
//                // Cache data
//                cachingService.put("key1", "value1", 3600); // Cache for 1 hour
//
//                // Retrieve cached data
//                String cachedValue = (String) cachingService.get("key1");
//                if (cachedValue != null) {
//                    System.out.println("Cached Value: " + cachedValue);
//                } else {
//                    System.out.println("Data not found in cache.");
//                }
//
//                // Delete cached data
//                cachingService.delete("key1");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

