package com.example.entity;

import java.util.HashSet;

public class TokenPool {
    private HashSet<TokenEntity> tokenpool;

    private HashSet<String> tokens;

    public TokenPool() {
        this.tokenpool = new HashSet<TokenEntity> ();
        this.tokens = new HashSet<String> ();
    }

    public boolean containsToken(String name) {
        return tokens.contains(name);
    }

    public TokenEntity getToken(String name) {
        for (TokenEntity token : tokenpool){
            if (token.getToken()==name){
                return token;
            }
        }
        return null;
    }

    public void removeToken(String name) {
        for (TokenEntity token : tokenpool){
            if (token.getToken()==name){
                tokenpool.remove(token);
                tokens.remove(name);
            }
        }
    }

    public void addToken(String token,long lastAuthTime,User user){
        tokenpool.add(new TokenEntity(token, lastAuthTime, user));
        tokens.add(token);
    }
}
