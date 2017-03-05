package com.lisl.pay.app.Service.impl;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * Created by Mr_Li on 2017/3/5.
 *  资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色去访问。
 */
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource{
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
