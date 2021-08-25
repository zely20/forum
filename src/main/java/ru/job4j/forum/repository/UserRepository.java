package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
