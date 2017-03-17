package com.lisl.pay.app.mango.config;

import org.jfaster.mango.plugin.spring.MangoDaoScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/17.
 */
@Configuration
public class ScannerConfig {
    @Bean
    public MangoDaoScanner mangoDaoScanner() {
        MangoDaoScanner scanner = new MangoDaoScanner();
        ArrayList<String> list = new ArrayList<>();
        list.add("com.lisl.pay.app.mango.dao");
        scanner.setPackages(list);
        return scanner;
    }
}
