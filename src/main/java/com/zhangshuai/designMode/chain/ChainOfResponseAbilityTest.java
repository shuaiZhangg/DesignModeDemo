package com.zhangshuai.designMode.chain;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2022/08/01
 * @Description: chain 责任链模式
 * @Version: 1.0
 */
public class ChainOfResponseAbilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOK(true).loggedOn(true).isPermits(true).build();

        Handle handle = new RequestFrequentHandle(new PermitsHandle(new LoginHandle(null)));
        if(handle.process(request)){
            System.out.println("正常处理业务");
        }else {
            System.out.println("访问异常");
        }
    }
}

class Request{

    private Boolean loggedOn;
    private Boolean frequentOK;
    private Boolean isPermits;
    private Boolean containSensitiveWords;

    public Request(Boolean loggedOn, Boolean frequentOK, Boolean isPermits, Boolean containSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOK = frequentOK;
        this.isPermits = isPermits;
        this.containSensitiveWords = containSensitiveWords;
    }

    public boolean isLoggedOn() {return loggedOn;}
    public boolean isFrequentOK() {return frequentOK;}
    public boolean isPermits() {return isPermits;}
    public boolean isContainSensitiveWords() {return containSensitiveWords;}


    static class RequestBuilder{
        private Boolean loggedOn;
        private Boolean frequentOK;
        private Boolean isPermits;
        private Boolean containSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn){
            this.loggedOn = loggedOn;
            return this;
        }
        RequestBuilder frequentOK(boolean frequentOK){
            this.frequentOK = frequentOK;
            return this;
        }
        RequestBuilder isPermits(boolean isPermits){
            this.isPermits = isPermits;
            return this;
        }
        RequestBuilder containSensitiveWords(boolean containSensitiveWords){
            this.containSensitiveWords = containSensitiveWords;
            return this;
        }
        public Request build(){
            Request request = new Request(loggedOn,frequentOK,isPermits,containSensitiveWords);
            return request;
        }
    }

}

abstract class Handle{
    Handle next;

    public Handle(Handle next) {
        this.next = next;
    }

    public Handle getNext() {
        return next;
    }

    public void setNext(Handle next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandle extends Handle{

    public RequestFrequentHandle(Handle next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制");
        if (!request.isFrequentOK()) {
            return false;
        }

        Handle next = getNext();
        if(null == next){
            return true;
        }
        if (next.process(request)) {
            return true;
        }
        return false;
    }
}

class LoginHandle extends Handle{

    public LoginHandle(Handle next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问登陆");
        if (!request.isLoggedOn()) {
            return false;
        }
        Handle next = getNext();
        if(null == next) return true;

        if (next.process(request)) {
            return true;
        }
        return false;
    }
}

class PermitsHandle extends Handle{

    public PermitsHandle(Handle next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问权限");
        if (!request.isPermits()) {
            return false;
        }
        Handle next = getNext();
        if(null == next) return true;

        if (next.process(request)) {
            return true;
        }
        return false;
    }
}