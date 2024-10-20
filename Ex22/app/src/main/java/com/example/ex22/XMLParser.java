package com.example.ex22;

Public class XMLParser {

    public String getXmlFromUrl(String url) { String xml = null;
        try {
//Tạo đối tượng Client và tạo Http Connetction DefaultHttpClient httpClient = new DefaultHttpClient(); HttpPost httpPost = new HttpPost(url);
//Tiến hành Request lên server và nhận đáp ứng Response
            HttpResponse httpResponse = httpClient.execute(httpPost);
//Lấy các Thực thể trong đáp ứng Response chuyển qua kiểu String và gắn


            HttpEntity httpEntity = httpResponse.getEntity(); xml = EntityUtils.toString(httpEntity);


        } catch (UnsupportedEncodingException e) { e.printStackTrace();
        } catch (ClientProtocolException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        }
// return XML
        return xml;
    }
}
