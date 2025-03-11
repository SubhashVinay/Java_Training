package util;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends QueryItem>{

    private List<T> items;

    public QueryList(List<T> items){
        this.items=items;
    }

    public List<T> getMatches(String field,String value){
        List<T> macthes=new ArrayList<>();

        for(var item:items){
            if(item.matchFieldValues(field,value)){
                macthes.add(item);
            }
        }
        return macthes;
    }
}
