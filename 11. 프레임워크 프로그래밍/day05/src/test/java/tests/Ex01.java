package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.choongang.config.MvcConfig;
import org.choongang.exam.PostData;
import org.choongang.member.controllers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class Ex01 {

    @Autowired
    private ObjectMapper om;

    @Test
    void test1(){
        // URL 구성
        URI url = UriComponentsBuilder.fromUriString("https://www.naver.com")
                //기본 URI "https://www.naver.com" 설정
                .path("/news/{0}") // 기본 URL 뒤에 /news 로 경로 추가
                .queryParam("t1", "v1") //쿼리 파라미터 추가
                .queryParam("t2", "v2")
                .queryParam("t3", "v3")
                .queryParam("t4", "aa{1}") //중괄호 - 교체 가능한 분분 = 변수
                .fragment("hash") // URL 끝에 프래그먼트(해시) 추가
                .encode() // URL 인코딩 -URL 내의 특수 문자를 적절히 변환하여 유효한 URL 로
                .build("AAAA", "BBBB");
        //build의 encoded -> 인코딩 되어있는 문자가 포함되어있음을 알려주는것!
        //한글일 경우 false(default) / true 일 경우, 영어, 숫자 % 정도

        System.out.println(url);
        //https://www.naver.com/news?t1=v1&t2=v2&t3=v3#hash
    }

    @Test
    void test2(){
        RestTemplate restTemplate = new RestTemplate();
        PostData data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", PostData.class);
        System.out.println(data);
    }

    @Test
    void test3() throws Exception{
        // JSON 형태의 데이터를 객체로 변환
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
        //System.out.println(body);

        // 단일 객체 변환 (단일 데이터일 경우)
        PostData data = om.readValue(body, PostData.class);
        System.out.println(data);

        // 복합 데이터 객체 변환 - List, Set, Map
        String itemsBody = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        //System.out.println(itemsBody);- JSON 형태

        List<PostData> items = om.readValue(itemsBody, new TypeReference<>(){});
        //TypeReference - 추상 클래스라서 {}

        items.forEach(System.out::println);
        // 대부분 단일 데이터, 목록 형태의 데이터... -> 자주 쓰임!
    }

    @Test
    @DisplayName("(예시) JSON 형식으로 POST 처리")
    void test4() throws Exception{
        //데이터 보내기~~ (데이터를 JSON 형태로 변환시켜서 보내기)
        RestTemplate restTemplate = new RestTemplate();
        RequestJoin form = new RequestJoin();
        form.setEmail("user999@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword(form.getPassword());
        form.setUserName("사용자999");
        form.setAgree(true);

        String params = om.writeValueAsString(form);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(params, headers);

        String url = "http://localhost:3000/day05/api/member";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response);

    }

    @Test
    @DisplayName("일반 양식 형식으로 전송 - Content-Type: application/x-www-form-urlencoded")
    void test5(){
        RestTemplate restTemplate = new RestTemplate();

        // 요청 데이터를 키와 값 형태로 변환
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", "user998@test.org");
        params.add("password", "12345678");
        params.add("confirmPassword", "12345678");
        params.add("userName", "사용자998");
        params.add("agree", "true");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        //System.out.println(request);

        String url = "http://localhost:3000/day05/member/join";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response);
    }
}
