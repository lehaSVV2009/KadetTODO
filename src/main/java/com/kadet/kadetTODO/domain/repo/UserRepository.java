package com.kadet.kadetTODO.domain.repo;

import com.kadet.kadetTODO.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * @author Alex Soroka
 */
@Resource
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername (String username);

}
