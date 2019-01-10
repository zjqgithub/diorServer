package com.yang.dior.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2019-01-09 11:58
 *
 ***/
public class OrderCodeFactory {

    /**
     * 订单类别头
     */
    private static final String ORDER_CODE = "1";

    /**
     * 退货类别头
     */
    private static final String RETURN_ORDER = "2";

    /**
     * 退款类别头
     */
    private static final String REFUND_ORDER = "3";

    /**
     * 未付款重新支付别头
     */
    private static final String AGAIN_ORDER = "4";

    /**
     * 随机编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};

    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 7;


    private static String toCode(String id) {
        StringBuilder idsbs = new StringBuilder();
        for (int i = id.length() - 1; i >= 0; i--) {
            idsbs.append(r[id.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - id.length())).toString();
    }

    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }


    private static synchronized String getCode(String userId) {
        userId = userId == null ? "10000" : userId;
        return getDateTime() + toCode(userId);
    }

    public static String getOrderCode(String userId) {
        return String.format("%s%s", ORDER_CODE, getCode(userId));
    }

    public static String getReturnCode(String userId) {
        return String.format("%s%s", RETURN_ORDER, getCode(userId));
    }

    public static String getRefundCode(String userId) {
        return String.format("%s%s", REFUND_ORDER, getCode(userId));
    }

    public static String getAgainCode(String userId) {
        return String.format("%s%s", AGAIN_ORDER, getCode(userId));
    }

}
