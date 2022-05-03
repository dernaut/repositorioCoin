package com.proyectocoin.coinsms.ProyectoCoinModuloCoins.service;

import com.proyectocoin.coinsms.ProyectoCoinModuloCoins.model.Coin;
import com.proyectocoin.coinsms.ProyectoCoinModuloCoins.repository.ICoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service
public class CoinService {
    @Autowired
    private ICoinRepository iCoinRepository;

    public void createCoin(Coin coin){
        List<Coin> coinsByName = iCoinRepository.findByName(coin.getName());
        if(!coinsByName.isEmpty()){
            throw new RuntimeException("Coin with that name already exists");
        }
        iCoinRepository.save(coin);
    }

    public List<Coin> getByName(String name_coin) {
        return iCoinRepository.findByName(name_coin);
    }

    public List<Coin> getByPrice(float price){
        return iCoinRepository.findByPrice(price);
    }
    public Iterable<Coin> getAll() {
        return iCoinRepository.findAll();
    }

    public Coin editarCoin(int id, Coin coin){
        iCoinRepository.findById(id).map(coin1 -> {
            coin1.setName((coin.getName() == null)? coin1.getName(): coin.getName());
            coin1.setUrl_icon((coin.getUrl_icon() == null)? coin1.getUrl_icon(): coin.getUrl_icon());
            coin1.setPrice((coin.getPrice() == 0)? coin1.getPrice(): coin.getPrice());
            coin1.setD_variation((coin.getD_variation() == 0)? coin1.getD_variation(): coin.getD_variation());
            coin1.setW_variation((coin.getW_variation() == 0)? coin1.getW_variation(): coin.getW_variation());
            coin1.setMarket_cap((coin.getW_variation() == 0)? coin1.getW_variation(): coin.getW_variation());
            coin1.setDay_volume((coin.getW_variation() == 0)? coin1.getW_variation(): coin.getW_variation());
            coin1.setCirculating_supply((coin.getW_variation() == 0)? coin1.getW_variation(): coin.getW_variation());
            return iCoinRepository.save(coin1);
        });
        return iCoinRepository.findById(id).orElse(null);
    }

    public Coin eliminarCoin(int id){
        Coin coin_aux= new Coin();
        iCoinRepository.findById(id).map(coin1 -> {
            coin_aux.setId(coin1.getId());
            coin_aux.setName(coin1.getName());
            coin_aux.setUrl_icon(coin1.getUrl_icon());
            coin_aux.setPrice(coin1.getPrice());
            coin_aux.setD_variation(coin1.getD_variation());
            coin_aux.setW_variation(coin1.getW_variation());
            coin_aux.setMarket_cap(coin1.getW_variation());
            coin_aux.setDay_volume(coin1.getW_variation());
            coin_aux.setCirculating_supply(coin1.getW_variation());
            return iCoinRepository.save(coin1);
        });
        iCoinRepository.deleteById(id);
        return coin_aux;
    }

    public Iterable<Coin> obtenerCoinPage(Pageable pageable){
        return iCoinRepository.findAll(pageable);
    }

}
