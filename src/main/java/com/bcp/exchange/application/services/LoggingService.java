package com.bcp.exchange.application.services;


import com.bcp.exchange.application.ports.in.LoggingRegister;
import com.bcp.exchange.application.ports.out.LogRepositoryPort;
import com.bcp.exchange.infrastructure.repository.entities.Log;
import io.reactivex.Single;

import javax.servlet.http.HttpServletRequest;


public class LoggingService implements LoggingRegister {

    LogRepositoryPort logRepositoryPort;

    public LoggingService(LogRepositoryPort logRepositoryPort) {
        this.logRepositoryPort = logRepositoryPort;
    }

    @Override
    public Single<Log> registerLogFromRequest(String user, HttpServletRequest req) {
        return logRepositoryPort.saveLog(user,req.getMethod(),req.getRequestURI());
    }
}
