package cn.xz.driftbottle.commons.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "account_bases")
public class AccountBases implements Serializable {
    /**
     * 用户id 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 环信登录id
     */
    @Column(name = "em_id")
    private String emId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 获取用户id 自增
     *
     * @return id - 用户id 自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id 自增
     *
     * @param id 用户id 自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取环信登录id
     *
     * @return em_id - 环信登录id
     */
    public String getEmId() {
        return emId;
    }

    /**
     * 设置环信登录id
     *
     * @param emId 环信登录id
     */
    public void setEmId(String emId) {
        this.emId = emId;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}