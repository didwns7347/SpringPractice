package hello.core.Order;

import hello.core.dicount.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
