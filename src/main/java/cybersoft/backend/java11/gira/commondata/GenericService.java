package cybersoft.backend.java11.gira.commondata;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	void save(T entity);
	T update(T entity);
	void deleteById(ID id);
	Optional<T> findById(ID id);
}
