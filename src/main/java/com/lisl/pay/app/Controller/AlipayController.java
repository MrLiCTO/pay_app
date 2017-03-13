package com.lisl.pay.app.Controller;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
@RestController
@RequestMapping("ali")
public class AlipayController {
    public Logger log = LoggerFactory.getLogger(this.getClass());

    //@RolesAllowed("ROLE_role0")
    //@Secured({"world0"})
    //@PreAuthorize("hasRole('ROLE_role0O')")
    //@PreAuthorize("hasAuthority('world0') and hasAuthority('world1')")
    @RequestMapping("aliIndex")
    public ModelAndView aliIndex() {
        return new ModelAndView("ali/ali_index");
    }

    @RequestMapping("pay")
    public ModelAndView qrcode(HttpServletRequest request, ModelAndView modelAndView) {
        try {
            //ServletOutputStream out = response.getOutputStream();
            //if(request.getParameter("outTradeNo")!=null){
            // 一定要在创建AlipayTradeService之前设置参数
            Configs.init("zfbinfo.properties");
            AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

            // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
            // 需保证商户系统端不能重复，建议通过数据库sequence生成，
            //String outTradeNo = request.getParameter("outTradeNo");
            String outTradeNo = "1121112212122";

            // (必填) 订单标题，粗略描述用户的支付目的。如“喜士多（浦东店）消费”
            //String subject = request.getParameter("subject");
            String subject = "充值";

            // (必填) 订单总金额，单位为元，不能超过1亿元
            // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
            //String totalAmount = request.getParameter("totalAmount");
            String totalAmount = "1132";

            // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
            // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
            //String undiscountableAmount = request.getParameter("undiscountableAmount");
            String undiscountableAmount = "0";

            // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
            // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
            String sellerId = "";

            // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
            String body = "购买商品2件共" + totalAmount + "元";

            // 商户操作员编号，添加此参数可以为商户操作员做销售统计
            String operatorId = "test_operator_id";

            // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
            String storeId = "test_store_id";

            // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
            ExtendParams extendParams = new ExtendParams();
            extendParams.setSysServiceProviderId("2088100200300400500");

            // 支付超时，定义为120分钟
            String timeoutExpress = "120m";

            // 商品明细列表，需填写购买商品详细信息，
            List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
            // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
            GoodsDetail goods1 = GoodsDetail.newInstance("goods_id001", "全麦小面包", 1500, 1);
            // 创建好一个商品后添加至商品明细列表
            goodsDetailList.add(goods1);

            // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.05元，购买了两件
            GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "黑人牙刷", 505, 2);
            goodsDetailList.add(goods2);

            // AlipayTradePrecreateContentBuilder builder = new AlipayTradePrecreateContentBuilder()

            AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
                    .setSubject(subject)
                    .setTotalAmount(totalAmount)
                    .setOutTradeNo(outTradeNo)
                    .setUndiscountableAmount(undiscountableAmount)
                    .setSellerId(sellerId)
                    .setBody(body)
                    .setOperatorId(operatorId)
                    .setStoreId(storeId)
                    .setExtendParams(extendParams)
                    .setTimeoutExpress(timeoutExpress)
//              .setNotifyUrl("http://www.test-notify-url.com")//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
                    .setGoodsDetailList(goodsDetailList);

            AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);

            switch (result.getTradeStatus()) {
                case SUCCESS:
                    log.info("支付宝预下单成功: )");

                    AlipayTradePrecreateResponse res = result.getResponse();

                    String basePath = request.getSession().getServletContext().getRealPath("/");
                    File file = new File(basePath + "/images");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String fileName = String.format("images%sqr-%s.png", File.separator, res.getOutTradeNo());
                    String filePath = new StringBuilder(basePath).append(fileName).toString();
                    modelAndView = new ModelAndView("ali/ali_index").addObject("image", "/" + fileName);
                    //out.println("<img src=\"" + fileName + "\" />");
                    //out.println("filePath:" + filePath);
                    ZxingUtils.getQRCodeImge(res.getQrCode(), 256, filePath);
                    break;

                case FAILED:
                    log.error("支付宝预下单失败!!!");
                    break;

                case UNKNOWN:
                    log.error("系统异常，预下单状态未知!!!");
                    break;

                default:
                    log.error("不支持的交易状态，交易返回异常!!!");
                    break;
            }
            //out.println(result.getResponse().getBody());
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
