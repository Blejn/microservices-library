package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderLineItemsRequest;
import com.example.orderservice.model.OrderLineItems;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemsMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public OrderLineItemsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderLineItemsRequest mapToOrderLineItemDto(OrderLineItems orderLineItems) {
        return modelMapper.map(orderLineItems, OrderLineItemsRequest.class);
    }

    public OrderLineItems mapToOrderLineItemEntity(OrderLineItemsRequest orderLineItemsRequest) {
        return modelMapper.map(orderLineItemsRequest, OrderLineItems.class);
    }
}
