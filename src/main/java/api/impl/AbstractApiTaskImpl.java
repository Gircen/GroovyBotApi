package api.impl;

import api.interfaces.IApiTask;
import api.interfaces.IHandler;
import lombok.SneakyThrows;

import java.util.Map;

public abstract class AbstractApiTaskImpl implements IApiTask {
    private IHandler ret;


    @Override
    public void setData(Map<String, String> commands) {

    }

    @Override
    public IHandler getResult() {
        return ret;
    }

    public abstract void work() throws Exception;

    @SneakyThrows
    @Override
    public void run() {
        work();
    }
}
