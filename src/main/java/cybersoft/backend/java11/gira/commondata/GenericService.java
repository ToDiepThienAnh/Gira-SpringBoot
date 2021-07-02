package cybersoft.backend.java11.gira.commondata;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.backend.java11.gira.project.dto.CreateProjectTypeDto;

public interface GenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	void save(T entity );
	T update(T entity);
	void deleteById(ID id);
	Optional<T> findById(ID id);
}
