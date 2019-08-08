package com.cashregister.repos;

import com.cashregister.domain.Message;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
