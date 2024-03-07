package com.playground.pgapp.kafka;

import com.playground.pgapp.transactional.User;
import com.playground.pgapp.transactional.UsersDao;
import com.playground.pgapp.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class UserKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserKafkaConsumer.class);
    private final UsersDao usersDao;

    public UserKafkaConsumer(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @KafkaListener(topics = "test-topic", groupId = "users")
    public void onMessage(String user) {
        LOGGER.info("User consumed" + user);

        usersDao.save(JsonUtil.unmarshalJson(user, User.class));
    }
}
