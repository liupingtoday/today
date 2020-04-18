//package cn.js.today.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * Simple to Introduction
// *
// * @Description: 一句话描述该类的功能
// * @Author: liupingtoday
// * @Since 2020-04-18
// * @UpdateUser: liupingtoday
// * @UpdateDate: 2020-04-18
// * @UpdateRemark: 说明本次修改内容
// * @Version: v1.0
// */
//public class CacheUtils {
//    private static final String SYS_CACHE = "sysCache";
//    private static Logger logger = LoggerFactory.getLogger(CacheUtils.class);
//
//    public static <V> void put(String cacheName, String key, V value) {
//        getCache(cacheName).put(null(key), value);
//    }
//
//    public static Set<String> getCacheNames() {
//        return j.null().null();
//    }
//
//    public static void put(String key, Object value) {
//        put("sysCache", key, value);
//    }
//
//    public static <V> V get(String cacheName, String key, V defaultValue) {
//        Object a;
//        return (a = get(cacheName, null(key))) != null ? a : defaultValue;
//    }
//
//    public static <V> V get(String cacheName, String key) {
//        return getCache(cacheName).get(null(key));
//    }
//
//    public static void clear(String cacheName) {
//        getCache(cacheName).clear();
//        logger.info(ValidCodeController.null("}\n{\u0007l\\>\u001dc"), cacheName);
//    }
//
//    public static void clearCache() {
//        String a;
//        if (!StringUtils.isBlank(a = Global.getConfig(com.jeesite.common.mybatis.u.t.j.null("z\n{\u0013g\u001d'\u0019h\u0019a\u001f'\u0019e\u001fh\bG\u001bd\u001fz")))) {
//            String[] var1;
//            int var2 = (var1 = a.split(ValidCodeController.null("2"))).length;
//            int var10000 = 0;
//            boolean var10002 = true;
//
//            for(int var3 = 0; var10000 < var2; var10000 = var3) {
//                removeCache(var1[var3++]);
//            }
//
//        }
//    }
//
//    public static void removeByKeyPrefix(String cacheName, String keyPrefix) {
//        String a = null(keyPrefix);
//        C a;
//        Set a = (a = getCache(cacheName)).keys();
//        Set a = SetUtils.newHashSet();
//        Iterator a = a.iterator();
//
//        while(true) {
//            String a;
//            do {
//                if (!a.hasNext()) {
//                    logger.info(com.jeesite.common.mybatis.u.t.j.null("{\u001fd\u0015\u007f\u001fK\u0003B\u001fp*{\u001fo\u0013q@)\u0001tZ4D)\u0001t"), cacheName, a);
//                    return;
//                }
//
//                a = (String)a.next();
//            } while(a != null && !StringUtils.startsWith(a, a));
//
//            a.remove(a);
//            a.add(a);
//        }
//    }
//
//    public static void removeCache(String cacheName) {
//        j.null().null(cacheName);
//        logger.info(ValidCodeController.null("l\u0003s\th\u0003]\u0007}\u000e{\\>\u001dc"), cacheName);
//    }
//
//    public static <K, V> C<K, V> getCache(String cacheName) {
//        C a;
//        if ((a = j.null().null(cacheName)) == null) {
//            throw new RuntimeException((new StringBuilder()).insert(0, com.jeesite.common.mybatis.u.t.j.null("弩剄粁绖乗沨杳宓丳―")).append(cacheName).append(ValidCodeController.null("⁻过乌缍嬾〜")).toString());
//        } else {
//            return a;
//        }
//    }
//
//    public static void put(String key, Object value, long timeToLiveInSeconds) {
//        put("sysCache", key, value, timeToLiveInSeconds);
//    }
//
//    public static void removeByKeyPrefix(String keyPrefix) {
//        removeByKeyPrefix("sysCache", keyPrefix);
//    }
//
//    public CacheUtils() {
//    }
//
//    public static <V> void put(String cacheName, String key, V value, long timeToLiveInSeconds) {
//        getCache(cacheName).null(null(key), value, timeToLiveInSeconds);
//    }
//
//    public static void remove(String cacheName, String key) {
//        getCache(cacheName).remove(null(key));
//    }
//
//    public static <V> V get(String key) {
//        return get("sysCache", key);
//    }
//
//    public static <V> V get(String key, V defaultValue) {
//        Object a;
//        return (a = get(key)) != null ? a : defaultValue;
//    }
//
//    public static void remove(String key) {
//        remove("sysCache", key);
//    }
//}
