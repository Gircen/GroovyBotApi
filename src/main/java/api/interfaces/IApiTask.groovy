package api.interfaces

interface IApiTask extends Runnable{
    void setData(Map<String,String> commands);
    IHandler getResult();
}