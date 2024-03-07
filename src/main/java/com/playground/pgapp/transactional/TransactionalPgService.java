package com.playground.pgapp.transactional;

public interface TransactionalPgService {
    void throwExceptionAfterSuccesfullSave();
    void throwExceptionInTryCatchBLock();
    void sendKafkaMessageThenThrowException();
}
