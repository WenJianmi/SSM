package com.briup.ssm.common.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091800536999";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC4CjB4NpM32GVxOU3qH22ZJnmsbfnD7WO8MT40BRAcmzS5DgsnMSVi4EY/w01hunGobfXcxFTLQqNKdBm5giVaUU+iSpiMoCQA8Dd6xyUQnXQ9u4HcPGNM9kntLUmIsshsnm3XUxJw3nu/C/3FKcMZQ6k0HIt7IiQKkN34qOj7ekP5gFRxzdov5MNCS+sztJFjoSTT9j/O+aDqpfGvMvpQW6AtQFuw7JbIh+QN8mSOuzIMPYo73afw1Vtsog0dzp0oEli5qpWYuGGc+DKze7tbAp4Sum8CbrX6zkXCTpPgXM6ASoYS6oDYNm4Cf6HZll1fJyc0xIR6KmtJ1p2BP6IrAgMBAAECggEBALHXltLz2ftjL1PkTjhpulz+YyGO/IaqhXA8HaHjKpiaGq6gtYJf6YLMutWvAr3njyF1cNqvFkl80ZKG8rzi2PmYDV4Eu7lYnrIRb2tDubt+i++DnI+YA1VBwlphIufn6+mahwZGjlFnjSkmi0nVe2SUj5N96gNJEI7tQrKhdtJawW0tpzzghDNKCf695zqDnW/GMS+gy3VK3mfb50VGVXzNWWBzpehJbqb8p8enwrqSr/8ghjJQB9hB5GZJJgXXfRVVp8cyj84VtCQqzyWlAUI5TuoYKPN1D+9uB/p9J35SABM85T+rpdVDICbllNX93XvDCpK1kIimoqau1tA6kPECgYEA/aqOpiWX7PEKZADbcetDG8nMOvqduoV0a14ROz0mUd4LmJMjjqvXwCgFGzAocd1EeFPfvFhDWIKDExFdPQumXiQdpdnSbO4D5vAmEUz9fnQSXMm9rvgYv+27oQUSMK/mkOPfYGJW5cmwYPaVAFaYK/JA671JLxnHdKJ7hOdlug8CgYEAubulTbl93hh/n/x0HKnofVtGNzxh9YivLYCCYVeEa7O66GmLQG+2W4dUfSkbcImNYmgoGcrWr4o4+Z6ZdzuiJH6Yx65Iv+EVkRHueErNeMWekkNjbcwC4siMLqck4q+mw1eQ3C6UgU2xb3woF2U/Kc+ovTv2TcrQ6thHLXaOYiUCgYAMOyUVrcpdimHN4Jy0KXva4ygNz/e6/qRWaPq7uH8Yg3RbrvyP7IlCoqtcXD4W/2xFwQWQt1DH+8MGMFgmkWE8ONGVJaOXzQIzKHEtdGDksAQSpUeYIC5RUs0xPmVaI6Eia1ph81vtSIRQqJMWqRY9SDkJJN9afgu3+/2ost+c0QKBgC+NTk4u/n29UfeY//VSvvZRRxHfQMlHPGpu63KWoI2ej2zvkLpnn42hgU0mGCNg5DTcq9+mof6BagLmyy3Os72aN+1vvqp5qzbgG2jq5d5U4jtaS3uR7u83H0TWgEgVZqG+qpTkzBqq1JHRfMY4ospGo1IHpxDVq1VlGBwYrW2NAoGAeATU3jAIPFvK1kZT6y68Nsl271baJnisyl/DoLzLhYnb+sWogNQN8vYlEP7sOwAdTBJ9hMQj2zG7c5wepOmDcliFQ+ySwB5UAdA8nmZvPe/DHmy7CLIAjmqLmb2Ttdg2l2R37FhvuXxXXMFT1lkp12O9tkVVXyo6EEY3BLSLj28=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuAoweDaTN9hlcTlN6h9tmSZ5rG35w+1jvDE+NAUQHJs0uQ4LJzElYuBGP8NNYbpxqG313MRUy0KjSnQZuYIlWlFPokqYjKAkAPA3esclEJ10PbuB3DxjTPZJ7S1JiLLIbJ5t11MScN57vwv9xSnDGUOpNByLeyIkCpDd+Kjo+3pD+YBUcc3aL+TDQkvrM7SRY6Ek0/Y/zvmg6qXxrzL6UFugLUBbsOyWyIfkDfJkjrsyDD2KO92n8NVbbKINHc6dKBJYuaqVmLhhnPgys3u7WwKeErpvAm61+s5Fwk6T4FzOgEqGEuqA2DZuAn+h2ZZdXycnNMSEeiprSdadgT+iKwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

