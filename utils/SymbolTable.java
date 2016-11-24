package utils;
import java.util.*;
import java.lang.*;
public class SymbolTable<E,F> implements ISymbolTable<E,F>{
    private HashMap<E,F> map;
    public SymbolTable(){
        map=new HashMap<E, F>();
    }

    @Override
    public void add(E key, F value){
        map.putIfAbsent(key,value);
    }

    @Override
    public boolean contains(E key){
        return map.containsKey(key);
    }

    @Override
    public void setValue(E key,F value){
        map.put(key,value);
    }

    @Override
    public F getValue(E key){
        F value=map.get(key);
        if(value==null){
            throw new RuntimeException("no such key");
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("SymbolTableImpl = [");

        if (!map.isEmpty()) string.append("\n");

        for (E key : map.keySet()) {
            string.append("   " + key + " <- " + map.get(key) + "\n");
        }

        string.append("]");
        return string.toString();
    }

    public Iterable<Map.Entry<E,F>> getAll(){
        return map.entrySet();
    }
}