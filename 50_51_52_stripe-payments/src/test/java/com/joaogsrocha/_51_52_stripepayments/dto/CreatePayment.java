package com.joaogsrocha._51_52_stripepayments.dto;

import com.google.gson.annotations.SerializedName;

public class CreatePayment {
    @SerializedName("items")
    Object[] items;
    public Object[] getItems() {
        return items;
    }
}
