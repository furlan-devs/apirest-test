package seniortest.apirest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seniortest.apirest.entity.Order;
import seniortest.apirest.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order salvar(Order order){return orderRepository.save(order);}

    public List<Order> listaOrder(){return orderRepository.findAll();}

    public Optional<Order> buscarPorId(UUID id){return orderRepository.findById(id);}

    public void removerPorId(UUID id){
        orderRepository.deleteById(id);
    }


}
