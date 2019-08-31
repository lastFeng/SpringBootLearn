package com.learn.hello.apache.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author guowf
 * @mail guowf_buaa@163.com
 * @description:
 * @data created in 2019-08-31 13:08
 */
public class MyEmail {
    public static void main(String[] args) throws EmailException {
        // 新建一个Email对象
        Email email = new SimpleEmail();

        // 设置发送邮件的服务器
        email.setHostName("smtp.qq.com");
        // 设置端口
        email.setSmtpPort(465);

        // 设置账户、密码
        email.setAuthentication("563805728@qq.com", "fupaohijnwckbbaf");

        // 设置SSL传输
        email.setSSLOnConnect(true);

        // 设置发送对象
        email.setFrom("563805728@qq.com");

        // 设置发送内容
        email.setMsg("This is just a test!");
        // 设置接收对象
        email.addTo("guowf_buaa@163.com");

        // 发送
        email.send();
    }
}
