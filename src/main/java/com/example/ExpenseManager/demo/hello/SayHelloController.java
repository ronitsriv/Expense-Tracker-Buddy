package com.example.ExpenseManager.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        //http:localhost:8080/say-hello
        return "Hello! What is";
    }

    @RequestMapping("say-helloHtml")
    @ResponseBody
    public String sayHelloHtml(){
        //http:localhost:8080/say-hello
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first HTML page with body");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    //   \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    public String sayHelloJsp(){
        return "sayHello";
    }

}
