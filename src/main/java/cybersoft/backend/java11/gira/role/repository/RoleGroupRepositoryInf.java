package cybersoft.backend.java11.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.backend.java11.gira.role.model.RoleGroup;

@Repository
public interface RoleGroupRepositoryInf extends JpaRepository<RoleGroup, Long> {

}
