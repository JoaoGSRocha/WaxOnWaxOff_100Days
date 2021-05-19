package com.joaogsrocha._SpringREST.skin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
class Skin {
    private @Id @GeneratedValue Long id;
    private String name;
    private String rarity;
    private String condition;
    private String expansionCode;
    private Double price;
    private Date releaseDate;


    Skin() {}

    Skin(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    Skin(String name, String rarity, String condition, String expansionCode, Double price, Date releaseDate) {
        this.name = name;
        this.rarity = rarity;
        this.condition = condition;
        this.expansionCode = expansionCode;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String role) {
        this.condition = role;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getExpansionCode() {
        return expansionCode;
    }

    public void setExpansionCode(String expansionCode) {
        this.expansionCode = expansionCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skin skin = (Skin) o;
        return id.equals(skin.id) &&
                name.equals(skin.name) &&
                Objects.equals(rarity, skin.rarity) &&
                Objects.equals(condition, skin.condition) &&
                Objects.equals(expansionCode, skin.expansionCode) &&
                price.equals(skin.price) &&
                Objects.equals(releaseDate, skin.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rarity, condition, expansionCode, price, releaseDate);
    }

    @Override
    public String toString() {
        return "Skin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", condition='" + condition + '\'' +
                ", expansionCode='" + expansionCode + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
