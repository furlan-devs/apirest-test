package seniortest.apirest.http.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import seniortest.apirest.entity.Item;
import seniortest.apirest.service.ItemService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item salvar(@RequestBody Item item) {
        return itemService.salvar(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listItem(){
         return itemService.listaItem();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item buscarItemPorId(@PathVariable("id") UUID id){
        return itemService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> atualizaItem(@PathVariable("id") UUID id, @RequestBody Item item){
        itemService.buscarPorId(id)
                .map(itemBase -> {
                    modelMapper.map(item, itemBase);
                    itemService.salvar(itemBase);
                    return  Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarPorId(id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void removerItem(@PathVariable("id") UUID id){
        itemService.buscarPorId(id)
                .map(item -> {
                    itemService.removerPorId(item.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }


}
