package api

import api.impl.AbstractApiTaskImpl
import api.interfaces.IHandler
import org.springframework.context.annotation.Bean

class WikiApiTaskImpl extends AbstractApiTaskImpl{
    IHandler handler;
    @Bean("wiki")
    WikiApiTaskImpl getWiki(){
        return new WikiApiTaskImpl();
    }
    @Override
    void work() {

    }


}
