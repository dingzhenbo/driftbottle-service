package cn.xz.driftbottle.commons.domain;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "account_relation")
public class AccountRelation {
    /**
     * 用户id
     */
    private Integer account;

    /**
     * 关注用户的编号
     */
    @Column(name = "attention_account")
    private Integer attentionAccount;

    /**
     * 获取用户id
     *
     * @return account - 用户id
     */
    public Integer getAccount() {
        return account;
    }

    /**
     * 设置用户id
     *
     * @param account 用户id
     */
    public void setAccount(Integer account) {
        this.account = account;
    }

    /**
     * 获取关注用户的编号
     *
     * @return attention_account - 关注用户的编号
     */
    public Integer getAttentionAccount() {
        return attentionAccount;
    }

    /**
     * 设置关注用户的编号
     *
     * @param attentionAccount 关注用户的编号
     */
    public void setAttentionAccount(Integer attentionAccount) {
        this.attentionAccount = attentionAccount;
    }
}