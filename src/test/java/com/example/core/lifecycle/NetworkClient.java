package com.example.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient/* implements InitializingBean, DisposableBean 거의 사용하지 않음*/{

    private String url;

    public NetworkClient(){
        System.out.println("constructor call, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //call when service start
    public void connect(){
        System.out.println("connect : " + url);
    }


    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    public void disconnect(){
        System.out.println("close : " + url);
    }

    @PostConstruct//최신 스프링에서 가장 권장하는 방법
    public void init() throws Exception {
        connect();
        call("초기화 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
