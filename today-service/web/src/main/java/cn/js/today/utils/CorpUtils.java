//package cn.js.today.utils;
//
//import cn.js.today.common.lang.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
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
//public class CorpUtils {
//    public static final String DEFAULT_CORP_NAME = "JeeSite";
//    public static final String DEFAULT_CORP_CODE = "0";
//    private static final String CORP_CACHE = "corpCache";
//
//    public static String getCurrentCorpCode() {
//        String a = "0";
//        if (Global.isUseCorpModel() && ObjectUtils.toBoolean(H.do().get(NetInfo.null("PDeKWY")))) {
//            HttpServletRequest a;
//            if (StringUtils.isBlank((a = ServletUtils.getRequest()) != null ? (a = (String)a.getAttribute(ProcessFinder.null("3G\"X\u0013G4M\u000fw"))) : (a = ""))) {
//                Subject var10000 = UserUtils.getSubject();
//                boolean var10003 = true;
//                Session a;
//                if ((a = var10000.getSession(false)) != null) {
//                    a = ObjectUtils.toString(a.getAttribute(NetInfo.null("UEDZuERO")));
//                }
//            }
//
//            if (StringUtils.isBlank(a)) {
//                a = "0";
//            }
//
//            if (a != null) {
//                a.setAttribute(ProcessFinder.null("3G\"X\u0013G4M\u000fw"), a);
//            }
//        }
//
//        return ObjectUtils.toStringIgnoreNull(a);
//    }
//
//    public static <V> V getCache(String key, V defaultValue) {
//        Object a;
//        return (a = getCache(key)) != null ? a : defaultValue;
//    }
//
//    public static <V> void putCache(String key, V value) {
//        CacheUtils.put("corpCache", (new StringBuilder()).insert(0, key).append(NetInfo.null("iu")).append(getCurrentCorpCode()).toString(), value);
//    }
//
//    public CorpUtils() {
//    }
//
//    public static String getCurrentCorpName() {
//        String a = "JeeSite";
//        if (Global.isUseCorpModel()) {
//            HttpServletRequest a;
//            if (StringUtils.isBlank((a = ServletUtils.getRequest()) != null ? (a = (String)a.getAttribute(ProcessFinder.null("3G\"X\u001eI=M\u000fw"))) : (a = ""))) {
//                Subject var10000 = UserUtils.getSubject();
//                boolean var10003 = true;
//                Session a;
//                if ((a = var10000.getSession(false)) != null) {
//                    a = ObjectUtils.toString(a.getAttribute(NetInfo.null("UEDZxK[O")));
//                }
//            }
//
//            if (StringUtils.isBlank(a)) {
//                a = "JeeSite";
//            }
//
//            if (a != null) {
//                a.setAttribute(ProcessFinder.null("3G\"X\u001eI=M\u000fw"), a);
//            }
//        }
//
//        return ObjectUtils.toStringIgnoreNull(a);
//    }
//
//    public static void removeCache(String key) {
//        CacheUtils.removeByKeyPrefix("corpCache", (new StringBuilder()).insert(0, key).append(NetInfo.null("iu")).toString());
//    }
//
//    public static <V> V getCache(String key) {
//        return CacheUtils.get("corpCache", (new StringBuilder()).insert(0, key).append(ProcessFinder.null("\u000fw")).append(getCurrentCorpCode()).toString());
//    }
//}
