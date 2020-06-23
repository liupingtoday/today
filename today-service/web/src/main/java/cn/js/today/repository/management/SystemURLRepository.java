package cn.js.today.repository.management;

import cn.js.today.domain.management.SystemURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemURLRepository extends JpaRepository<SystemURL,Long> {

    Optional<SystemURL> findOneBySystemName(String systemName);

    Optional<SystemURL> findOneByEnvironment(String environment);

    Optional<SystemURL> findOneBySoftwareName(String softwareName);


}
