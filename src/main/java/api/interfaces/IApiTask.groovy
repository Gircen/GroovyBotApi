package api.interfaces

interface IApiTask {
    public void setData(T);
    public IHandler getResult();
    void worker();
}