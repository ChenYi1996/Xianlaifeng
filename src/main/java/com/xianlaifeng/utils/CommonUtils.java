package com.xianlaifeng.utils;

import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    public static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }


    public static String getFileNameFromHttp(String url) {
        if (url==null||!url.contains("/")){
            return null;
        }
        return url.substring(url.lastIndexOf("/")+1);
    }

    public static String covertToUrlList(String files,String url){
        String[] file =  files.split(",");
        List<String> list = new ArrayList<String>();
        for(String f:file){
            list.add(url+f);
        }
        return list.toString().replace("[","").replace("]","");
    }


    public static String add(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(className.toLowerCase()+" ");
        sql.append("set ");
        String str= getClassValueObj(object).toString().replace("{","").replace("}","");
        sql.append(str);
        return sql.toString();


    }


    public static String delete(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("delete from ");
        sql.append(className+" ");
        sql.append("where id=");
        String str= (String)getClassValueObj(object).get("id");
        sql.append(str);
        return sql.toString();


    }



    public static Map<String, Object> getClassValueObj(Object object) {


        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, Object> paraMap = new HashMap<String, Object>();
        for (int i = 0; i < fields.length; i++) {
            try {
                //获得目标类的接入权限
                boolean isAccess = fields[i].isAccessible();
                if (!isAccess) fields[i].setAccessible(true);


                if(fields[i].getGenericType().toString().equals("class java.lang.String")){
                    paraMap.put(fields[i].getName(), fields[i].get(object)==null?null:"'"+fields[i].get(object)+"'");

                }
                else if(fields[i].getGenericType().toString().equals(
                        "class java.util.Date")){
                    if(fields[i].get(object)==null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        paraMap.put(fields[i].getName(), "'" + sdf.format(new Date().getTime()) + "'");
                    }
                    else {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        paraMap.put(fields[i].getName(), "'" + sdf.format(fields[i].get(object)) + "'");
                    }
                }
                //如果属性名为id，即在数据库中自增长，不用插入id字段入数据库，进行空操作
                else if(fields[i].getName().equals("id")){

                }
                else {
                    paraMap.put(fields[i].getName(), fields[i].get(object));
                }


                if (!isAccess) fields[i].setAccessible(false);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(paraMap);
        return paraMap;
    }


    public static Map<String, Object> objectToMap(Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        try {
            System.out.println(clazz);
            for(Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }

        }catch(IllegalAccessException e){
            return null;
        }
        return map;
     }
}
