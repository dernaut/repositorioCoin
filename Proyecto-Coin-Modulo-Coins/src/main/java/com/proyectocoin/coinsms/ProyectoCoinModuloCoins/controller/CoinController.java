package com.proyectocoin.coinsms.ProyectoCoinModuloCoins.controller;

import com.proyectocoin.coinsms.ProyectoCoinModuloCoins.model.Coin;
import com.proyectocoin.coinsms.ProyectoCoinModuloCoins.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coin")
public class CoinController {
    @Autowired
    private CoinService coinService;


    @PostMapping
    public void create(@RequestBody Coin coin) {
        coinService.createCoin(coin);
    }

    @GetMapping("/all")
    public Iterable<Coin> getCoins() {
        return coinService.getAll();
    }

    @GetMapping("/byName")
    public List<Coin> getCoinsByName(@RequestParam(name = "name_coin") String name) {
        return coinService.getByName(name);
    }
    @GetMapping("/byPrice")
    public List<Coin> getCoinsByPrice(@RequestParam(name = "price_coin") float price) {
        return coinService.getByPrice(price);
    }
    @PutMapping("/edit/{id}")
    public Coin editarCoinId(@PathVariable("id") int id, @RequestBody Coin coin){
        return coinService.editarCoin(id, coin);
    }

    @DeleteMapping("/delete/{id}")
    public Coin eliminarUsuarioId(@PathVariable("id") int id){
        return coinService.eliminarCoin(id);
    }

}
