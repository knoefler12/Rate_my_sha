package com.example.demo.controllers;

import com.example.demo.models.KebabShop;
import com.example.demo.repositories.KebabShopRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Kebab Shop Controller", description = "Rest endpoints for Kebab shops")
@RestController
public class KebabShopController {

    @Autowired
    KebabShopRepo kebab;

    @PostMapping("/kebab-shops")
    public KebabShop addKebabShop(@RequestBody KebabShop newKebabShop){
        newKebabShop.setId(null);
        return kebab.save(newKebabShop);
    }

    @GetMapping("/kebab-shops/{id}")
    public KebabShop getKebabShops(@PathVariable Long id) {
        return kebab.findById(id).get();
    }

    @PatchMapping("/kebab-shops/{id}")
    public String patchArtistById(@PathVariable Long id,@RequestBody KebabShop kebabShopToPatch){
        return kebab.findById(id).map(foundKebabShops ->{
            if(kebabShopToPatch.getName()!=null) foundKebabShops.setName(kebabShopToPatch.getName());
            if(kebabShopToPatch.getAddress()!=null)foundKebabShops.setAddress(kebabShopToPatch.getAddress());
            if(kebabShopToPatch.getRating()!=-1)foundKebabShops.setRating(kebabShopToPatch.getRating());
            kebab.save(foundKebabShops);
            return "kebab shop found and patched";
        }).orElse("kebab shop not found");
    }

    @GetMapping("/kebab-shops/sorted")
    public Iterable<KebabShop> kebabShopsSorted(@RequestParam KebabShop kebabShop, int rating){
        return kebab.findKebabShopsByOOrderByRating(kebabShop,rating);
    }

    @DeleteMapping("/kebab-shops/{id}")
    public void deleteKebabShop(@PathVariable Long id){
        kebab.deleteById(id);
    }

    @GetMapping("/kebab-shops")
    public Iterable<KebabShop> getKebabShops(){
       return kebab.findAll();
    }

}
