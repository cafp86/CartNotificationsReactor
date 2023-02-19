package org.example.notifications;


import org.example.model.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class CartNotification {

    private final Sinks.Many<Integer> cartSink = Sinks.many().multicast().onBackpressureBuffer();

    public void send(Integer productId){
        cartSink.tryEmitNext(productId);
    }

    public Flux<Integer> getCartNotification(){
        return cartSink.asFlux();
    }


}
