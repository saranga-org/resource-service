package FuelPass.Dev.FuelPass.Repo;

import FuelPass.Dev.FuelPass.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
