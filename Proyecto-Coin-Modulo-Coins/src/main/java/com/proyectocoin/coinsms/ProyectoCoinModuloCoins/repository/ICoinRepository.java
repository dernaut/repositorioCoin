package com.proyectocoin.coinsms.ProyectoCoinModuloCoins.repository;

import com.proyectocoin.coinsms.ProyectoCoinModuloCoins.model.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoinRepository extends CrudRepository<Coin, Integer>, PagingAndSortingRepository<Coin, Integer> {
    //select * from tb_coin where name_coin = ?
    //findBy{{nombreAtributo}}(tipoAtributo {{nombreAtributo}}
    List<Coin> findByName(String name);
    List<Coin> findByPrice(float price);

    Page<Coin> findAll(Pageable pageable);

    List<Coin> findAllByPrice(double price, Pageable pageable);

    //consultas JPQL
    //SELECT obj FROM Class obj WHERE {{predicados}},
    // los predicados son en base a los atributos de la clase
    //@Query("SELECT c FROM Coin c WHERE c.name = :name")
    //List<Coin> findByName(String name);
}
