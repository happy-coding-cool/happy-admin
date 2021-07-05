package com.happy.admin.auth.common;

import cool.happycoding.code.base.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:37 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HappyPrincipal implements Serializable {

    private User user;

}
