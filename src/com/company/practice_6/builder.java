package com.company.practice_6;
class Account {
    private String userId;
    private String token;

    private Account(){}

    @Override
    public String toString() {
        return "User Id: " + userId + "\nToken: " + token + "\n-------------------";
    }

    public static Builder newBuilder(){
        return new Account().new Builder();
    }
    public class Builder {

        private Builder(){}

        public Builder setUserId(String userId) {
            Account.this.userId = userId;
            return this;
        }

        public Builder setToken(String token) {
            Account.this.token = token;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}
public class builder {
    public static void main(String[] args){
        System.out.println(Account.newBuilder().setToken("203318").setUserId("54").build());
        System.out.println(Account.newBuilder().setUserId("89").build());
        System.out.println(Account.newBuilder().setToken("168526").build());
    }
}
