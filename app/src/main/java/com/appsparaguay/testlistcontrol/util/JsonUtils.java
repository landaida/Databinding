package com.appsparaguay.testlistcontrol.util;

import android.util.Log;

import com.appsparaguay.testlistcontrol.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrador on 9/8/2015.
 */
public class JsonUtils {

    /*public Collection<E> jsonToObject(JSONObject json){
        Type collectionType = new TypeToken<Collection<T>>(){}.getType();
        Collection<T> list = gson.fromJson(json, collectionType);
    }*/

    public static <T> T getObject(String json, Class<T> type){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, type);
        }catch (Exception e){
            LogUtil.e(e.getMessage());
        }
        return null;
    }

    public static <T> List<T> getList(String json, Class<T> type) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, type ));
        }catch (Exception e){
            LogUtil.e(e.getMessage());
        }
        return null;
    }
}
