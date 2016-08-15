package com.alaso.wechat.server.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Created by adam on 8/4/16.
 */
@SuppressWarnings(value="unchecked")
public abstract class UrlUtil {

    private static final Logger logger = LoggerFactory.getLogger(UrlUtil.class);

    public static String queryUrl(String url){
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = br.readLine();
            while (line != null) {
                result += line;
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postUrl(String url,String param){
        PrintWriter out = null;
        BufferedReader br = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = br.readLine();
            while (line != null) {
                result += line;
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if (br != null){
                    br.close();
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String sendHttpsUrl(String url,String requestMethod,String outputStr){
        String result = "";
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL realUrl = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) {
                result += line;
                line = bufferedReader.readLine();
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
        } catch (ConnectException ce) {
            logger.error("连接超时：{}", ce.getMessage());
        } catch (Exception e) {
            logger.error("https请求异常：{}", e.getMessage());
        }
        return result;
    }

    public static String sendRedpocket(String url,String param) throws KeyStoreException, IOException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        String mchId = PropertiesUtil.getProperties("mchid");
        FileInputStream instream = new FileInputStream(new File("/Users/adam/Documents/apiclient_cert.p12"));
        try {
            keyStore.load(instream, mchId.toCharArray());
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }

        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        String result = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(param, "utf-8"); // 如果此处编码不对，可能导致客户端签名跟微信的签名不一致
            reqEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(entity.getContent(), "UTF-8"));
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        result += text;
                    }
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return result;
    }
}
