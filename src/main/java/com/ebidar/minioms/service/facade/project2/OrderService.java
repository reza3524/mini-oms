package com.ebidar.minioms.service.facade.project2;

import com.ebidar.minioms.dto.project2.OrderDto;

public interface OrderService {

    OrderDto buy(OrderDto order);

    OrderDto sell(OrderDto order);
}
