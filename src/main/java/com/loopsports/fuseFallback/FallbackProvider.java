package com.loopsports.fuseFallback;

import com.loopsports.exception.GlobalException;
import com.loopsports.utils.JSONResult;
import com.loopsports.utils.ResultCode;
import com.loopsports.utils.ResultGenerator;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class FallbackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.GONE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 410;
            }

            @Override
            public String getStatusText() throws IOException {
                return "Gone";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                GlobalException exception = new GlobalException(
                        ResultCode.GONE.msg(),
                        ResultCode.GONE.code()
                );
                JSONResult result = ResultGenerator.genErrorResult(exception);
                return new ByteArrayInputStream(result.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
