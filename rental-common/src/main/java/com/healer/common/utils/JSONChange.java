package com.healer.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author 李泽炜
 * @package com.healer.common.utils
 * @time 2021/3/1 11:38
 * @Description TODO
 */
public class JSONChange {
        /*
         * 001.json转换成对象
         * @param:传入对象，json字符串
         * @return:Object
         */
        public Object jsonToObj(Object obj,String jsonStr) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            return obj = mapper.readValue(jsonStr, obj.getClass());
        }
        /*
         * 002.对象转换成json
         * @param:传入对象
         * @return:json字符串
         */
        public String objToJson(Object obj) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        }

}
