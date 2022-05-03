package com.proyectocoin.coinsms.ProyectoCoinModuloCoins.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_coin")
public class Coin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coin")
    private int id;

    @Column(name = "name_coin")
    private String name;

    @Column(name = "url_icon")
    private String url_icon;

    @Column(name = "price_coin")
    private float price;

    @Column(name = "day_variation")
    private int d_variation;

    @Column(name = "week_variation")
    private int w_variation;

    @Column(name = "market_cap")
    private int market_cap;

    @Column(name = "day_volume")
    private int day_volume;

    @Column(name = "circulating_supply")
    private int circulating_supply;

    public Coin(int id, String name, String url_icon, float price, int d_variation, int w_variation, int market_cap, int day_volume, int circulating_supply) {
        this.id = id;
        this.name = name;
        this.url_icon = url_icon;
        this.price = price;
        this.d_variation = d_variation;
        this.w_variation = w_variation;
        this.market_cap = market_cap;
        this.day_volume = day_volume;
        this.circulating_supply = circulating_supply;
    }

    public Coin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_icon() {
        return url_icon;
    }

    public void setUrl_icon(String url_icon) {
        this.url_icon = url_icon;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getD_variation() {
        return d_variation;
    }

    public void setD_variation(int d_variation) {
        this.d_variation = d_variation;
    }

    public int getW_variation() {
        return w_variation;
    }

    public void setW_variation(int w_variation) {
        this.w_variation = w_variation;
    }

    public int getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(int market_cap) {
        this.market_cap = market_cap;
    }

    public int getDay_volume() {
        return day_volume;
    }

    public void setDay_volume(int day_volume) {
        this.day_volume = day_volume;
    }

    public int getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(int circulating_supply) {
        this.circulating_supply = circulating_supply;
    }
}
