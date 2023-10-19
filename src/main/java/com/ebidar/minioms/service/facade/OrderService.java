package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.dto.OrderDto;

public interface OrderService {

    OrderDto buy(OrderDto order);

    OrderDto sell(OrderDto order);
}
