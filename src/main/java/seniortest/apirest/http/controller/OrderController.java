package seniortest.apirest.http.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import seniortest.apirest.entity.Order;
import seniortest.apirest.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order salvar(@RequestBody Order order) {
        return orderService.salvar(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> listOrder(){
         return orderService.listaOrder();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order buscarOrderPorId(@PathVariable("id") UUID id){
        return orderService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> atualizaOrder(@PathVariable("id") UUID id, @RequestBody Order order){
        orderService.buscarPorId(id)
                .map(orderBase -> {
                    modelMapper.map(order, orderBase);
                    orderService.salvar(orderBase);
                    return  Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order não encontrado."));
        return ResponseEntity.status(HttpStatus.OK).body(orderService.buscarPorId(id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void removerOrder(@PathVariable("id") UUID id){
        orderService.buscarPorId(id)
                .map(order -> {
                    orderService.removerPorId(order.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order não encontrado."));
    }


}
