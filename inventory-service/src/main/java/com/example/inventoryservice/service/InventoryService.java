package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.mapper.InventoryMapper;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private  final InventoryMapper inventoryMapper;
    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);


    @Transactional(readOnly = true)

    public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {
        logger.info("Wait Started");
        Thread.sleep(1000);
        logger.info("Wait end");
        logger.info("Checking Inventory for SKU codes: {}", skuCode);

        List<InventoryResponse> inventoryResponses = inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory ->
                        InventoryResponse
                                .builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .quantity(inventory.getQuantity())
                                .build()).toList();

        logger.info("Inventory check results: {}", inventoryResponses);

        return inventoryResponses;
    }
}
