package com.poo.qualAReceitaDeHoje.service;

import com.poo.qualAReceitaDeHoje.exception.NotFoundEntityException;
import com.poo.qualAReceitaDeHoje.model.Item;
import com.poo.qualAReceitaDeHoje.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItens() {
        return itemRepository.findAll();
    }

    public Item getItemById(Integer id) throws NotFoundEntityException {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Item não encontrado"));
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Integer id, Item item) throws NotFoundEntityException {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Item não encontrado"));
        existingItem.setQuantidade(item.getQuantidade());
        existingItem.setGrupoalimentar(item.getGrupoalimentar());
        existingItem.setUnidadedemedida(item.getUnidadedemedida());
        existingItem.setNome(item.getNome());
        existingItem.setReceita(item.getReceita());

        return itemRepository.save(existingItem);
    }

    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }
}
