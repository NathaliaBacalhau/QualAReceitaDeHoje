package com.poo.qualAReceitaDeHoje.controller;

import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Item;
import com.poo.qualAReceitaDeHoje.model.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.poo.qualAReceitaDeHoje.service.ItemService;

import java.util.List;
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Item> createItem
            (@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.createItem(item));

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<Item>> readItem() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.getAllItens());

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/update/{itemId}", method=RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(
            @PathVariable(value = "itemId") Integer id,
            @RequestBody Item item) throws ChangeSetPersister.NotFoundException, NotFoundEntityException {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.updateItem(id, item));

    }
    @CrossOrigin(origins="*", allowedHeaders="*")
    @RequestMapping(value="/delete/{itemId}", method=RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(
            @PathVariable(value = "itemId") Integer id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
