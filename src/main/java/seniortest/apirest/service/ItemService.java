package seniortest.apirest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seniortest.apirest.entity.Item;
import seniortest.apirest.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public Item salvar(Item item){
        return itemRepository.save(item);
    }

    public List<Item> listaItem(){
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorId(UUID id){
        return itemRepository.findById(id);
    }

    public void removerPorId(UUID id){
        itemRepository.deleteById(id);
    }
}
