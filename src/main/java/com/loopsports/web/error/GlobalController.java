package com.loopsports.web.error;

import org.springframework.boot.autoconfigure.web.ErrorController;

public class GlobalController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }
}
