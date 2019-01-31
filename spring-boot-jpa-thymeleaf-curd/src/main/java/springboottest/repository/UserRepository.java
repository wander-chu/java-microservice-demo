package springboottest.repository;

import springboottest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}