package com.bcp.exchange.application.ports.in;


import com.bcp.exchange.infrastructure.repository.entities.Log;
import io.reactivex.Single;

import javax.servlet.http.HttpServletRequest;

public interface LoggingRegister {
    Single<Log> registerLogFromRequest(String user, HttpServletRequest req);
}
