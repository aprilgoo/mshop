package mshop.common.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * Map을 대신할 CommandMap 클래스
 * 내부적으로 Map을 하나 생성하여 그 Map에 모든 데이터를 담는 역할
 * map의 여러 기능들을 재정의 함
 * CommandMap 클래스를 Map과 똑같이 사용할 수 있도록 getMap 메서드 추가
 * 
 * */


public class CommandMap {
	
    Map<String,Object> map = new HashMap<String,Object>();
    
    public Object get(String key){
        return map.get(key);
    }
     
    public void put(String key, Object value){
        map.put(key, value);
    }
     
    public Object remove(String key){
        return map.remove(key);
    }
     
    public boolean containsKey(String key){
        return map.containsKey(key);
    }
     
    public boolean containsValue(Object value){
        return map.containsValue(value);
    }
     
    public void clear(){
        map.clear();
    }
     
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
     
    public Set<String> keySet(){
        return map.keySet();
    }
     
    public boolean isEmpty(){
        return map.isEmpty();
    }
     
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
     
    public Map<String,Object> getMap(){
        return map;
    }	
	
}
