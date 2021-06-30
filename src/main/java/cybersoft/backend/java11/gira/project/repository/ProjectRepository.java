package cybersoft.backend.java11.gira.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.backend.java11.gira.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
