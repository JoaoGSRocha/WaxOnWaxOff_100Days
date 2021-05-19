package com.joaogsrocha._SpringREST.skin;

public class SkinNotFoundException extends RuntimeException {
    public SkinNotFoundException(Long id) {
        super("Could not find employee " + id +"\n");
    }
}
