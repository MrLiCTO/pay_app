package com.lisl.pay.app.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/3/9.
 * 支付宝账单查询
 */
public class TestService {
    public static void main(String[] args) throws Exception {
        Gson gson=new Gson();
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016073100131713", "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDUilFksqCOpJXUcmrq9LbxloPE8AR4J9ZZN8VF+6Gah4UYLEAX0ZJjA/rJCOq2ihpBNeWHGCwDnG8CuvOVX/3HVLdWQF/1lIIKVOeVu9EteL4fTQLCpVnuiXcZt15PCU9oH5mO3HB+MdLWFjbYma5IN/9GaaE1G5yakB8QNW4cgQPOQ/crqooJUg+/njF3Skpqrf9tF63elKMdZwTL8YEoW6MbjDCtpwp7xKx3JEovfA4tbuw0YV3XpupxoJ9isW6GxpnvkK495LD9cAqqVojnU+3fbBZZw+gWnC5i8/OzaYLUixRLlkOo1luKMrVeQGeFksrcaWppMDay3sV/VJaTAgMBAAECggEBAIJuvBKbGLNRR+3PpdO5CEhsgUMrtOJ0ODQaaMNQ8FTgFArIpTC42ShQuegDw97wE7qvM8PbTq+Moge/6VpjRV+9mqGg8gLI96EVh+W5FF7eeXbGEQqY5P7hd6jdgk/ou8V/lwI4QAUB2Iyvp0r3zR/e1ZdFnbv0zP+BsL6Gu6NbXht+IjRUsGawXO4xQIy/WzU7k47BhsLEEVEBqlImzylYYgCifPbvdeQG3YUPuMRpDIEYK8e80h7eyNHbekQjCMsD9/rGzNI8v3Ypb0PJz2maXuzUagqicvfmn++MU4LdNMUXmg+1oeeduUZ6q8+W8wdqGUiQ/P50viwfEuS4JZkCgYEA/2KcNx23BTEqNb1zrw9gkNVOD9hQG+R43TV+FAT3+BY/8AyWYBCIoJVTHFtccKV13KxPznGyI4PuBj0ozhaXoMLWupSWj0COr7LAIV5hdTCwY6r+7pduHPVYdWmSKAT29e2gBLFfKN6Qt6x6LcteWesnLuJfR/mfEySQxK/9WI8CgYEA1Q1NmJzx7elX1AJKzSvE70URJ923oOul4JGsy0znLsYSsMeUCtiHRjbK3m6iYRPtJaUrYfhTfoMzU7sleIgFOcZ6bDliF4xqIJB2bMe7y7VNs9NCnIirjBzbKCp2Rz80nQrKMlqpQnzs0kxvxIf5hHuZdzua82uDlwBhHhwq+70CgYEAozXG9eZUn8nS2vNPajJemVDoiXHJiHnT0DMudubR/kdh5yx0McJ/PnkP21B73DWyBCxO+HVqzg2zYWNWn5aKop/CEQ2CxtwQFDMdXHXvvLA4Ggoe0CYQpgsZ1Dd6w36gwXxyRm2AjiLmw6tDjd6pVrfUm77p+5qI0fgNWNXMB/sCgYB0eapjdeIZ1Eks4fftBTHMMbE4X1GFy27LQDj8iFWXT7hmJyY7a7dA3rG4OznQ4ujyfMMj83QKJUZJT3Yj2BErTeQeCJ0lDKH0naXwwJ1duAf7+NJg66MFnbz+z4AMYXStKnnyX3hLniqGqj0sb74s/Lmg4thKngu54P43TOT+7QKBgQDNHjQjfD1+K3t+PQJOaq6bwz6Py0a6qtSZnZAvgQvRyT4A3PBeyPlB8qPg0oP6/hP4FZPlOQ8JCucsGF9W4suQXvE7KZU5bPssk1W4pmbRKcd7NUrxYKtlRmlWzsnAHGxhgvIFecDy7eDCMbAuo+W5/9tPncd7elr3+keFPRsZxg==", "json", "GBK", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwDhZedCqR+oUHdr0R//6C2CJA8TpDZfiG7twVVaV7l+UeTHiZyVPW5cCx89lxct0bTgK1lx23bc1/280x6QBR29WmL5lPoOJpnWWPwAkh9Ooxyu1glxQlToDAP7lZuOfW1Mpa57P1uXzoxYnZ3ZbV3sIrgFsasiLFWmwq8zSOidqSwy3YSg5BBgkaehJeHbBgufl/e16YzXWaMj2tbTvu2LrA1phzZWQlfR5sSmZe+mMlPwcQNDBNv5swVzPqC5SWem+X5C/atZ3eoTYpsIHzTVGsktfCdzBu6HEJ4nJlRBmS/CQCt+gTdwGmY7sbyUXSXxPZjo+IzXCTXMCAHIkfwIDAQAB", "RSA2");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"1011398286\"," +
                "    \"trade_no\":\"\"" +
                "  }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功"+response.toString());
        } else {
            System.out.println("调用失败"+gson.toJson(response));
        }
    }
}
