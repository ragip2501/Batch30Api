package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    //https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    //HTTP status kodunun 200
    //Content Type'in Json
    //Ve Status Line'in HTTP/1.1 200 OK
    //Oldugunu test edin

        @Test
        public void test01() {
            //1-api testi yaparken ilk olarak URL belirlenmeli

            String url = "https://restful-booker.herokuapp.com/booking/3";

            //2-beklenen sonuc(expected result) olusturulur.Bu case de benden body doğrulanması istenmediği için şimdilik beklenen
            //sonuc oluşturmuyoruz.

            //3-request gönder.

            Response response = given().
                    accept("application/json").
                    when().
                    get(url);

            response.prettyPrint();

            //4-actual result olustur

            //response body ile ilgili işlem yapmayacağımız için şimdi olusturmayacağız

            //5-doğrulama yap(assertion)

            System.out.println("Status code : "+response.getStatusCode());//response den gelen status code verir
            System.out.println("Content type : "+response.getContentType());//responseden gelen content type verir
            System.out.println("Status line : "+response.getStatusLine());//responseden geelen status line verir
            System.out.println("response.getHeaders() = " + response.getHeaders());

            Assert.assertEquals(200,response.getStatusCode());
            //expected kısmı bize text olarak verilen degerdir, actual kısmı ise response den dönen değerdir.

            Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
            Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        }
}
