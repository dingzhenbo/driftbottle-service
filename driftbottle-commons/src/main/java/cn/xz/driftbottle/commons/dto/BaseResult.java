package cn.xz.driftbottle.commons.dto;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 数据传输对象
 */
public class BaseResult implements Serializable {
    private String result;  //返回结果 ok // not_ok
    private Object data;   //返回数据
    private String success; //操作成功。保存操作成功提示信息
    private String error; //操作失败提示信息


    /**
     * 不携带数据返回成功
     * @param
     * @return
     */
    public static BaseResult ok(){
        return createResult("ok",null,"成功操作",null);
    }

    /**
     * 携带数据返回成功
     * @param data  携带数据
     * @return
     */
    public static BaseResult ok(Object data){
        return createResult("ok",data,"操作成功",null);
    }


    /**
     * 失败
     * @param error 错误信息
     * @return
     */
    public static BaseResult notOk(String error){
        return createResult("not_ok",null,"",error);
    }


    private static BaseResult createResult(String result,Object data,String success,
                                           String error){

        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setError(error);

        return baseResult;
    }


}
