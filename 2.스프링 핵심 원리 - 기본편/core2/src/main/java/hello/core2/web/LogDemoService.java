package hello.core2.web;

import hello.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
