package com.lss.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */

@Controller
@RequestMapping(value = "user")
public class UserController {
    @RequestMapping(value = "/check")
    public ModelAndView checkUser() {
        Map<String, Object> map = new HashedMap();
        String data = "{\"total\":7,\"rows\":[\n" +
                "\t{\"id\":1,\"name\":\"All Tasks\",\"begin\":\"3/4/2010\",\"end\":\"3/20/2010\",\"progress\":60,\"iconCls\":\"icon-ok\"},\n" +
                "\t{\"id\":2,\"name\":\"Designing\",\"begin\":\"3/4/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":1,\"state\":\"closed\"},\n" +
                "\t{\"id\":21,\"name\":\"Database\",\"persons\":2,\"begin\":\"3/4/2010\",\"end\":\"3/6/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":22,\"name\":\"UML\",\"persons\":1,\"begin\":\"3/7/2010\",\"end\":\"3/8/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":23,\"name\":\"Export Document\",\"persons\":1,\"begin\":\"3/9/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":3,\"name\":\"Coding\",\"persons\":2,\"begin\":\"3/11/2010\",\"end\":\"3/18/2010\",\"progress\":80},\n" +
                "\t{\"id\":4,\"name\":\"Testing\",\"persons\":1,\"begin\":\"3/19/2010\",\"end\":\"3/20/2010\",\"progress\":20}\n" +
                "],\"footer\":[\n" +
                "\t{\"name\":\"Total Persons:\",\"persons\":7,\"iconCls\":\"icon-sum\"}\n" +
                "]}\n";
        JSONObject json = JSONObject.parseObject(data);
        map.put("data", JSON.toJSONString(data));
        return new ModelAndView("trace");
    }

    @ResponseBody
    @RequestMapping(value = "/check1", method = RequestMethod.GET)
    public Object check1() {
        String data = new String("{\"total\":7,\"rows\":[\n" +
                "\t{\"id\":2,\"name\":\"All Tasks\",\"begin\":\"3/4/2010\",\"end\":\"3/20/2010\",\"progress\":60,\"iconCls\":\"icon-ok\"},\n" +
                "\t{\"id\":3,\"name\":\"Designing\",\"begin\":\"3/4/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":2,\"state\":\"closed\"},\n" +
                "\t{\"id\":21,\"name\":\"Database\",\"persons\":2,\"begin\":\"3/4/2010\",\"end\":\"3/6/2010\",\"progress\":100,\"_parentId\":3},\n" +
                "\t{\"id\":22,\"name\":\"UML\",\"persons\":1,\"begin\":\"3/7/2010\",\"end\":\"3/8/2010\",\"progress\":100,\"_parentId\":3},\n" +
                "\t{\"id\":23,\"name\":\"Export Document\",\"persons\":1,\"begin\":\"3/9/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":3},\n" +
                "\t{\"id\":4,\"name\":\"Coding\",\"persons\":2,\"begin\":\"3/11/2010\",\"end\":\"3/18/2010\",\"progress\":80,\"_parentId\":2,\"state\":\"closed\"},\n" +
                "\t{\"id\":31,\"name\":\"子节点1\",\"persons\":2,\"begin\":\"3/11/2010\",\"end\":\"3/18/2010\",\"spend\":\"30ms\",\"progress\":80,\"_parentId\":4},\n" +
                "\t{\"id\":32,\"name\":\"子节点2\",\"persons\":2,\"begin\":\"3/11/2010\",\"end\":\"3/18/2010\",\"spend\":\"30ms\",\"progress\":80,\"_parentId\":4},\n" +
                "\t{\"id\":5,\"name\":\"Testing\",\"persons\":1,\"begin\":\"3/19/2010\",\"end\":\"3/20/2010\",\"progress\":20}\n" +
                "],\"footer\":[\n" +
                "\t{\"name\":\"Total Persons:\",\"persons\":7,\"iconCls\":\"icon-sum\"}\n" +
                "]}\n");
        String data1 = data.replace("\n", "");
        String data2 = data1.replace("\t", "");
        String data3 = data2.replace("", "");
        JSONObject json = JSONObject.parseObject(data2);
//        Object d = JSON.toJSON(json);
        return json;
    }
}
