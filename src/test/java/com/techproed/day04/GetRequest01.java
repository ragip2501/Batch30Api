package com.techproed.day04;

import io.restassured.response.Response;
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

            Response response = given().accept("application/json").when().get(url);

            //4-actual result olustur
            //5-doğrulama yap(assertion)

            response.prettyPrint();

        }
}
