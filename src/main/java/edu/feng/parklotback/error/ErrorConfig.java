package edu.feng.parklotback.error;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @program: parklot-back
 * @description: 错误处理类
 * @author: feng
 * @create: 2020-02-11 23:51
 */

@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
        registry.addErrorPages(error404Page);
    }

}