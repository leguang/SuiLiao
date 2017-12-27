package cn.itsite.suiliao.common;


import cn.itsite.abase.common.BaseConstants;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class Constants extends BaseConstants {
    private final String TAG = this.getClass().getSimpleName();

    /**
     * 不允许new
     */
    private Constants() {
        throw new Error("Do not need instantiate!");
    }

    public static final String KEY_POSITION = "key_position";

}
