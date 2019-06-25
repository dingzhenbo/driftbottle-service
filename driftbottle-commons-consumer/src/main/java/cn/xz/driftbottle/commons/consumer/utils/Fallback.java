package cn.xz.driftbottle.commons.consumer.utils;

import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.commons.utils.MapperUtils;

/**
 * 熔断回调工具类
 */
public class Fallback {

    public static String CommonsFallback(){
        try {
            return MapperUtils.obj2json(BaseResult.notOk("网络异常，请重试。")) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
