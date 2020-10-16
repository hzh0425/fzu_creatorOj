package com.moxi.auth.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 0:27
 */
@Data
@Builder
public class Oauth2TokenVo {
    /**
     * 访问令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 访问令牌头前缀
     */
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    private int expiresIn;

    private String userId;
}
