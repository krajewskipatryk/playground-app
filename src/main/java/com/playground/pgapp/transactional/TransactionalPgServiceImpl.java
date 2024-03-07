package com.playground.pgapp.transactional;

import com.playground.pgapp.kafka.UserKafkaPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class TransactionalPgServiceImpl implements TransactionalPgService {
    private final UsersDao usersDao;
    private final UserKafkaPublisher kafkaPublisher;

    public TransactionalPgServiceImpl(UsersDao usersDao, UserKafkaPublisher kafkaPublisher) {
        this.usersDao = usersDao;
        this.kafkaPublisher = kafkaPublisher;
    }

    @Override
    @Transactional
    public void throwExceptionAfterSuccesfullSave() {
        User user = new User("Patryk", "Krajewski", 25);

        usersDao.save(user);

        throw new RuntimeException("test");
    }

    @Override
    @Transactional
    public void throwExceptionInTryCatchBLock() {
        User user = new User("Patryk", "Krajewski", 25);

        try {
            usersDao.save(user);

            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            System.out.printf(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void sendKafkaMessageThenThrowException() {
        User user = new User("Patryk", "Test", 25);

        usersDao.save(user);

        kafkaPublisher.publish(new User("Andrzej", "Test", 27));

        throw new RuntimeException("test");
    }
}