package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        //判断
        try {
        if (s==null)throw new RuntimeException("请您传入数据");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

          return   sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("数据类型转换出错");
        }

    }
}
