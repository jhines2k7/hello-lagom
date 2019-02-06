package com.hines.james.hellolagomstream.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

import com.hines.james.hellolagom.api.HellolagomService;
import com.hines.james.hellolagomstream.api.HellolagomStreamService;

/**
 * The module that binds the HellolagomStreamService so that it can be served.
 */
public class HellolagomStreamModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        // Bind the HellolagomStreamService service
        bindService(HellolagomStreamService.class, HellolagomStreamServiceImpl.class);
        // Bind the HellolagomService client
        bindClient(HellolagomService.class);
        // Bind the subscriber eagerly to ensure it starts up
        bind(HellolagomStreamSubscriber.class).asEagerSingleton();
    }
}
