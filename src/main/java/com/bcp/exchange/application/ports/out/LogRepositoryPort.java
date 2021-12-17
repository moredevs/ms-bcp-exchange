package com.bcp.exchange.application.ports.out;

import com.bcp.exchange.infrastructure.repository.entities.Log;
import io.reactivex.Single;

public interface LogRepositoryPort {
   Single<Log> saveLog(String user, String method, String resource);
}
