package com.example.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script> 欢迎访问 www.xxx.com ,大家都是996 ");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
                .add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter())
                .add(new URLFilter());

        fc.add(fc2);
        //处理msg
//        new HTMLFilter().doFilter(msg);
//        new SensitiveFilter().doFilter(msg);

        System.out.println(msg);
    }

}

class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class  HTMLFilter implements Filter{

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        msg.setMsg(r);
        return true;
    }
}



class  SensitiveFilter implements Filter{

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996", "955");
        msg.setMsg(r);
        return false;
    }
}

class  FaceFilter implements Filter{

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace(":)", "^V^");
        msg.setMsg(r);
        return true;
    }
}

class  URLFilter implements Filter{

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("www.xxx.com", "http://www.xxx.com");
        msg.setMsg(r);
        return true;
    }
}
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg m){
        for (Filter f:filters ) {
            if(!f.doFilter(m))
                return false;
        }
        return true;
    }
}