package in.ravi.springbootvalidationandexceptionhandling.repository;

import in.ravi.springbootvalidationandexceptionhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserId(int userId);
}
