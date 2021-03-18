
package com.healer.user.domain;


public class RealName {

    private String code;
    private String message;
    private RealNameResult result;
    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setResult(RealNameResult result) {
         this.result = result;
     }
     public RealNameResult getResult() {
         return result;
     }

    @Override
    public String toString() {
        return "RealName{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}