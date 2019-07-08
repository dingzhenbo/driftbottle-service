package cn.xz.driftbottle.service.consumer.account.controller;

import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.commons.utils.MapperUtils;
import cn.xz.driftbottle.service.consumer.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "test/{str}")
    public BaseResult sayHi(@PathVariable String str){
        AccountBases accountBases = new AccountBases();
        accountBases.setNickname("丁振波");
        return BaseResult.ok(accountBases);
    }

    /**
     * 注册
     * @param accountBases
     * @return
     */
    @PostMapping(value = "reg")
    public BaseResult reg(AccountBases accountBases){
        String json = null;
        try {
            json = MapperUtils.obj2json(accountBases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fallbackJson = accountService.reg(json); //调用服务提供者
        try {
            BaseResult baseResult = MapperUtils.json2pojo(fallbackJson, BaseResult.class);
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 搜索用户
     * @param id 用户环信id
     * @return
     */
    @GetMapping("search/{id}")
    public BaseResult search(@PathVariable String id){
        String json = accountService.searchAccount(id); //调用服务提供者
        try {
            BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);
            return  baseResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 关注
     * @param current 当前登录用户id
     * @param attention 关注用户id
     */
    @PostMapping(value = "attention/{current}/{attention}")
    public void  attention(@PathVariable String current,@PathVariable String attention){
        accountService.attention(current,attention); //调用服务提供者
    }

    @PostMapping(value = "attention/cancel/{current}/{attention}")
    public void cancelAttention(@PathVariable String current,@PathVariable String attention){
        accountService.cancelAttention(current,attention);
    }

    /**
     * 关注状态
     * @param current 当前用户id
     * @param other_account 其他用户
     * @return
     */
    @GetMapping(value = "attention/state/{current}/{other_account}")
    public Boolean attentionState(@PathVariable String current,@PathVariable String other_account){
        String state = accountService.attentionState(current, other_account);
        if (state!=null){
           return Boolean.valueOf(state);
        }
        return null;
    }

    /**
     * 获取用户id
     * @param emid
     * @return
     */
    @GetMapping(value = "get/id/{emid}")
    public Integer getCurrentId(@PathVariable String emid){
        String currentId = accountService.getCurrentId(emid);
        if (currentId!=null){
            return Integer.valueOf(currentId);
        }
        return null;
    }

    /**
     * 关注列表
     * @param account_id 用户id
     * @return
     */
    @GetMapping(value = "attention/list/{account_id}")
    public BaseResult attentionList(@PathVariable Integer account_id){
        String baseResultJson = accountService.attentionList(account_id);
        try {
            BaseResult baseResult = MapperUtils.json2pojo(baseResultJson, BaseResult.class);
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
