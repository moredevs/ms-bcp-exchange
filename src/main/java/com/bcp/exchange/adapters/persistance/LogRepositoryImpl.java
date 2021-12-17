package com.bcp.exchange.adapters.persistance;


import com.bcp.exchange.application.ports.out.LogRepositoryPort;
import com.bcp.exchange.infrastructure.repository.LogRepository;
import com.bcp.exchange.infrastructure.repository.entities.Log;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogRepositoryImpl implements LogRepositoryPort {

    @Autowired
    LogRepository logRepository;

    public Single<Log> saveLog(String user, String method, String resource) {
        return Single.just( logRepository.save(new Log(user,method,resource))).observeOn(Schedulers.io());
    }

}
