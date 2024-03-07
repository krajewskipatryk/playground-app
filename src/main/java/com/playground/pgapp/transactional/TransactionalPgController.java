package com.playground.pgapp.transactional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/transactional")
class TransactionalPgController {
    private final TransactionalPgService transactionalPgService;

    public TransactionalPgController(TransactionalPgService transactionalPgService) {
        this.transactionalPgService = transactionalPgService;
    }

    @PostMapping(value = "/first/scenario")
    void saveToDb() {
        transactionalPgService.throwExceptionAfterSuccesfullSave();
    }

    @PostMapping(value = "/second/scenario")
    void saveToDb2() {
        transactionalPgService.throwExceptionInTryCatchBLock();
    }

    @PostMapping(value = "/third/scenario")
    void saveToDb3() {
        transactionalPgService.sendKafkaMessageThenThrowException();
    }
}
