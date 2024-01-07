package com.example.inventoryservice.mapper;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public InventoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public InventoryResponse mapToInventoryResponse(Inventory inventory) {
        return modelMapper.map(inventory, InventoryResponse.class);
    }
}
