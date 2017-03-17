package com.lisl.pay.app.mango.trasaction;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/3/17.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Transaction {
}
