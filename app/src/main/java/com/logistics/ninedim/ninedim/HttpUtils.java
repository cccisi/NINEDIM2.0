package com.logistics.ninedim.ninedim;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CZH on 2017/8/3.
 */

public class HttpUtils {
    /*
     * Function  :   发送Post请求到服务器
     * Param     :   params请求体内容，encode编码格式
     * Author    :   CZH
     */

    private static final String urlPath = "http://192.168.90.3:8080/JsonWeb/JsonServlet";

    public static String submitPostData(String para, String encode) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("param", para);//备用
        params.put("para", para);
        byte[] data = getRequestData(params, encode).toString().getBytes();//获得请求体

        try {
            URL url = new URL(urlPath);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);        //设置连接超时时间
            httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
            httpURLConnection.setDoOutput(true);                 //打开输出流，以便向服务器提交数据
            httpURLConnection.setRequestMethod("POST");     //设置以Post方式提交数据
            httpURLConnection.setUseCaches(false);               //使用Post方式不能使用缓存
            //设置请求体的类型是文本类型
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置请求体的长度
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            //获得输出流，向服务器写入数据
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);

            int response = httpURLConnection.getResponseCode();            //获得服务器的响应码
            if (response == HttpURLConnection.HTTP_OK) {
                InputStream inptStream = httpURLConnection.getInputStream();
                return getTogether(dealResponseResult(inptStream),dealResponseV_id(inptStream),dealResponseTele(inptStream));                     //处理服务器的响应结果
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * Function  :   封装请求体信息
     * Param     :   params请求体内容，encode编码格式
     * Author    :   CZH
     */
    public static StringBuffer getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();        //存储封装好的请求体信息
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }


    /*
     * Function  :   处理服务器的响应结果（将输入流转化成字符串）
     * Param     :   inputStream服务器的响应输入流
     * Author    :   CZH
     */
    public static String dealResponseResult(InputStream inputStream) throws Exception {
        String name = null;      //存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);

                byte[] result = byteArrayOutputStream.toByteArray();
                JSONArray array = new JSONArray(new String(result));
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);
                    name = item.getString("name");


                }
            }

//            resultData = new String(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static String dealResponseV_id(InputStream inputStream) throws Exception {
        String vehicle_id = null;      //存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);

                byte[] result = byteArrayOutputStream.toByteArray();
                JSONArray array = new JSONArray(new String(result));
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);
                    vehicle_id = item.getString("vehicle_id");
                }
            }

//            resultData = new String(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicle_id;
    }


    public static String dealResponseTele(InputStream inputStream) throws Exception {
        String tele = null;      //存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);

                byte[] result = byteArrayOutputStream.toByteArray();
                JSONArray array = new JSONArray(new String(result));
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);
                    tele = item.getString("tele");

                }
            }

//            resultData = new String(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tele;
    }

    public static String getTogether(String name, String vehicle_id, String tele)  {

        StringBuffer sb = new StringBuffer();//数据缓存
        try{

        //输出设置


        sb.append("司机姓名:").append(""+name+"").append("\n").append("车牌号:").append(""+vehicle_id+"")
                .append("\n").append("手机号:").append(""+tele+"");
        }

        catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
        }
        return sb.toString();
        }



}