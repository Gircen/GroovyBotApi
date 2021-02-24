package api

import api.interfaces.IApiTask
import api.interfaces.IHandler

class WikiApiTaskImpl implements IApiTask{
    IHandler handler;
    @Override
    void setData(Object T) {

    }

    @Override
    IHandler getResult() {

        return IHandler;
    }

    @Override
    void worker() {

    }
}
