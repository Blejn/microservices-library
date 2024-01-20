package com.example.orderservice.service;

import com.example.orderservice.config.WebClientConfig;
import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderLineItemsRequest;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.mapper.OrderLineItemsMapper;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl {
    private final OrderLineItemsMapper orderLineItemsMapper;
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());


        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsList().stream()
                .map(orderLineItemsMapper::mapToOrderLineItemEntity)
                .toList();

        order.setOrderLineItemsList(orderLineItems);


        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();


        InventoryResponse[] inventoryResponseArray =
                webClientBuilder
                        .build()
                        .get()
                        .uri("http://inventory-service/api/v1/inventory/check", uriBuilder ->
                                uriBuilder
                                        .queryParam("skuCode", skuCodes)
                                        .build())
                        .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                        .block();

        if (inventoryResponseArray.length != 0) {
            boolean sufficientQuantity = Arrays.stream(inventoryResponseArray)
                    .allMatch(response ->
                            order.getOrderLineItemsList().stream()
                                    .anyMatch(item ->
                                            item.getSkuCode().equals(response.getSkuCode()) &&
                                                    response.getQuantity() >= item.getQuantity()));
            logger.info("Wartość skuCodes: " + skuCodes);

            logger.info("WARTOSC" + sufficientQuantity);
            logger.info("Wartość inventoryResponseArray: " + Arrays.toString(inventoryResponseArray));
            if (sufficientQuantity) {


                this.orderRepository.save(order);
                return "Order Placed successfully";

            } else {
                throw new IllegalArgumentException("Something gone wrong");
            }
        } else {
            throw new IllegalArgumentException("Product is not in stock");
        }


    }
}



