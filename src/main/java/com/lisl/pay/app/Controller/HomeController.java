package com.lisl.pay.app.Controller;

import com.google.gson.Gson;
import com.lisl.pay.app.result.Msg;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by sang on 2017/1/10.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "msg", required = false) String msg, Model model) {
        Map<String, String[]> map = request.getParameterMap();
        Gson gson=new Gson();
        System.out.println(gson.toJson(map));
        if (error != null) {
            return "login-failure";
        }
        System.out.println(error);
        System.out.println(msg);
        return "login";
    }
}
