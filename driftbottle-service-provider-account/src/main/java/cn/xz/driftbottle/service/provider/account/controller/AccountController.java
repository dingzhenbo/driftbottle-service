package cn.xz.driftbottle.service.provider.account.controller;

import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.commons.domain.AccountRelation;
import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.commons.provider.AccountRelationService;
import cn.xz.driftbottle.commons.provider.AccountService;
import cn.xz.driftbottle.commons.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRelationService accountRelationService;

    /**
     * 注册
     * @param accountBasesJson
     * @return
     */
    @PostMapping(value = "reg")
    public BaseResult reg(String accountBasesJson){
        AccountBases accountBases = null;
        try {
            accountBases = MapperUtils.json2pojo(accountBasesJson, AccountBases.class);
            accountBases.setPassword(DigestUtils.md5DigestAsHex(accountBases.getPassword().getBytes()));
            accountBases.setCreatDate(new Date());//设置创建时间
            accountBases.setPhone(accountBases.getEmId()); //设置手机号
            accountBases.setNickname(accountBases.getEmId()); //默认昵称为手机号
        } catch (Exception e) {
            e.printStackTrace();
        }

        int insert = accountService.insert(accountBases);
        if (insert>0){
            return BaseResult.ok();
        }
        return BaseResult.notOk("注册失败");
    }

    /**
     * 查询用户信息
     * @param id 环信id
     * @return
     */
    @GetMapping(value = "search/{id}")
    public BaseResult searchAccount(@PathVariable String id){
        AccountBases accountBases = new AccountBases();
        accountBases.setEmId(id);
        Object o = accountService.selectOne(accountBases);
        if (o!=null){
            return BaseResult.ok(o);
        }
        return BaseResult.notOk("用户不存在");
    }

    /**
     * 根据环信id 查询用户id
     * @param emid 环信id
     * @return Integer
     */
    @GetMapping(value = "get/id/{emid}")
    public Integer getCurrentId(@PathVariable String emid){

        AccountBases accountBases = new AccountBases();
        accountBases.setEmId(emid);
        AccountBases account = (AccountBases) accountService.selectOne(accountBases);
        if (account!=null){
            return account.getId();
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
        AccountRelation accountRelation = new AccountRelation();
        accountRelation.setAccount(Integer.valueOf(current));
        accountRelation.setAttentionAccount(Integer.valueOf(attention));
        accountRelationService.insert(accountRelation);
    }

    /**
     * 取消 关注
     * @param current 当前登录用户id
     * @param attention 关注用户id
     */
    @PostMapping(value = "attention/cancel/{current}/{attention}")
    public void cancelAttention(@PathVariable String current,@PathVariable String attention){
        AccountRelation accountRelation = new AccountRelation();
        accountRelation.setAccount(Integer.valueOf(current));
        accountRelation.setAttentionAccount(Integer.valueOf(attention));
        accountRelationService.delete(accountRelation);
    }

    /**
     * 关注状态
     * @param current 当前用户id
     * @param other_account 其他用户
     * @return true 已关注 false未关注
     */
    @GetMapping(value = "attention/state/{current}/{other_account}")
    public Boolean attentionState(@PathVariable String current,@PathVariable String other_account){
        AccountRelation accountRelation = new AccountRelation();
        accountRelation.setAccount(Integer.valueOf(current));
        accountRelation.setAttentionAccount(Integer.valueOf(other_account));
        Object object = accountRelationService.selectOne(accountRelation);
        if (object!=null){
            return true;
        }
        return false;
    }

    @GetMapping(value = "attention/list/{account_id}")
    public BaseResult attentionList(@PathVariable Integer account_id){
        List<AccountBases> accountBasesList = new ArrayList<>();  //
        AccountRelation accountRelation = new AccountRelation();
        accountRelation.setAccount(account_id);
        List<AccountRelation> accountRelationList = accountRelationService.select(accountRelation);
        for (AccountRelation _accountRelation:accountRelationList) {
            AccountBases accountBases = new AccountBases();
            accountBases.setId(_accountRelation.getAttentionAccount());
            accountBasesList.add((AccountBases) accountService.selectOne(accountBases));
        }
        return BaseResult.ok(accountBasesList);
    }
}
