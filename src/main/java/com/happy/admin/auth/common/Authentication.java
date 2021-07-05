package com.happy.admin.auth.common;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:30 下午
 */
public interface Authentication extends Serializable {

    /**
     * 获取凭证
     * @return
     */
    HappyPrincipal getHappyPrincipal();
}
