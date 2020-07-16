package kr.co.lunasoft.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ok")
@Slf4j
@Api(tags = { "10. OkHttpClient" })
public class OkController {

    @GetMapping(value = "/getSync")
    public Map<String, Object> getSync() {
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/posts")
                    .addHeader("Content-Type", "application/json")
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            String message = response.body().string();
            data.put("code", "100200");
            data.put("msg", "Success");
            data.put("data", message);
        } catch (Exception e) {
            log.error("{}", e.toString());
            data.put("code", "-1");
            data.put("msg", "Error");
            data.put("data", "fail");
        }

        return data;
    }

    @GetMapping(value = "/getAsync")
    public Map<String, Object> getAsync() {
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/posts")
                    .addHeader("Content-Type", "application/json")
                    .get()
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    log.error("{}", e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    log.info("{}", response.body().string());
                }
            });

            data.put("code", "100200");
            data.put("msg", "Success");
            data.put("data", "");
        } catch (Exception e) {
            log.error("{}", e.toString());
            data.put("code", "-1");
            data.put("msg", "Error");
            data.put("data", "fail");
        }

        return data;
    }

    @PostMapping(value = "/postSync")
    public Map<String, Object> postSync() {
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            String jsonMessage = "";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/posts")
                    .addHeader("Content-Type", "application/json")
                    .post(RequestBody.create(MediaType.parse("application/json"), jsonMessage))
                    .build();
            Response response = client.newCall(request).execute();
            String message = response.body().string();
            data.put("code", "100200");
            data.put("msg", "Success");
            data.put("data", message);
        } catch (Exception e) {
            log.error("{}", e.toString());
            data.put("code", "-1");
            data.put("msg", "Error");
            data.put("data", "fail");
        }

        return data;
    }

    @PostMapping(value = "/postAsync")
    public Map<String, Object> postAsync() {
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            String jsonMessage = "";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/posts")
                    .addHeader("Content-Type", "application/json")
                    .post(RequestBody.create(MediaType.parse("application/json"), jsonMessage))
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    log.error("{}", e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    log.info("{}", response.body().string());
                }
            });

            data.put("code", "100200");
            data.put("msg", "Success");
            data.put("data", "");
        } catch (Exception e) {
            log.error("{}", e.toString());
            data.put("code", "-1");
            data.put("msg", "Error");
            data.put("data", "fail");
        }

        return data;
    }

}
