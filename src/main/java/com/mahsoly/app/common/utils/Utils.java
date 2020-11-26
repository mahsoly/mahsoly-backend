package com.mahsoly.app.common.utils;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Utils {

	public static <T> Mono<T> getMonoBlockingCall(Callable<T> supplier) {
		return Mono.fromCallable(supplier).subscribeOn(Schedulers.boundedElastic());
	}

	public static <T> Flux<T> getFluxBlockingCall(Supplier<Iterable<T>> iterableSupplier) {
		return Flux.defer(() -> Flux.fromIterable(iterableSupplier.get())).timeout(Duration.ofSeconds(30l))
				.subscribeOn(Schedulers.boundedElastic());
	}
}
