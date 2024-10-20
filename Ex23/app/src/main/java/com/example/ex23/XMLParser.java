package com.example.ex23;

import androidx.arch.core.internal.SafeIterableMap;

import java.util.concurrent.Executor;

public class XMLParser<HttpEntity> {
    public <HttpPost> String getXmlFromUrl(String url) {

        String xml = null;
        try {
//Tạo đối tượng Client và tạo Http Connetction
DefaultHttpClient httpClient = new DefaultHttpClient(); HttpPost httpPost = new HttpPost(url);
//Tiến hành Request lên server và nhận đáp ứng Response
            Executor httpClient = null;
            HttpResponse httpResponse = httpClient.execute(httpPost);
//Lấy các Thực thể trong đáp ứng Response chuyển qua kiểu String và gắn vào file xml
            HttpEntity httpEntity = httpResponse.getEntity();
            SafeIterableMap.Entry<Object, Object> EntityUtils;
            xml = EntityUtils.toString(httpEntity);
        } catch (UnsupportedEncodingException e) { e.printStackTrace();
        } catch (ClientProtocolException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        }
// return XML
        return xml;
    }
}