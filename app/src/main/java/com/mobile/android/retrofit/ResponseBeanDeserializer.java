package com.mobile.android.retrofit;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobile.hyoukalibrary.base.BaseEntity;
import com.mobile.hyoukalibrary.utils.L;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

@Deprecated
/**
 * 描述: 此类 就是为了让 GSON 不解析data字段里的json数据 直接返回里面的字符串
 * --------------------------------------------
 * 工程:
 * #0000     mwy     创建日期: 2016-09-13 19:57
 */
public class ResponseBeanDeserializer implements JsonDeserializer<BaseEntity> {
    @Override
    public BaseEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        JSONObject jsono = null;
        final BaseEntity baseEntity = new BaseEntity();
        try {
            String mjson = json.toString();
            mjson.substring(mjson.indexOf("{"), mjson.lastIndexOf("}"));
            L.d("获取的json" + mjson);
            jsono = new JSONObject(mjson);
            baseEntity.setGeneralErrMsg(jsono.getString("generalErrMsg"));
            baseEntity.setErrMsg(jsono.getString("errMsg"));
            baseEntity.setSuccess(jsono.getString("success"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return baseEntity;
    }
}
