package br.com.fiap.controller;

import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class ServerController {

    private final ApplicationContext context;
    private final CacheManager cacheManager;

    public ServerController(ApplicationContext ctx, CacheManager cacheManager) {
        this.context = ctx;
        this.cacheManager = cacheManager;
    }

    @PostMapping("/shutdownContext")
    public void shutdownContext() {
        ((ConfigurableApplicationContext) context).close();
    }

    @PostMapping("clearCache")
    public void clearCache(){
        cacheManager.getCache("produtoCache").clear();
        cacheManager.getCache("allProdutosCache").clear();
        cacheManager.getCache("clienteCache").clear();
        cacheManager.getCache("allClientesCache").clear();
    }
}
