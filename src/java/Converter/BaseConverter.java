package Converter;

public abstract class BaseConverter<T> {

    public String ConvertToString(T entity){
        String string = null;
        return string;
    };
    
    public T ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        
        T entity = null;
        return entity;
    }
}
