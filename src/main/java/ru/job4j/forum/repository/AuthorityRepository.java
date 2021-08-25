package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.entity.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority,Integer> {

    Authority findByAuthority(String authority);
}
