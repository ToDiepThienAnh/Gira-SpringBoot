package cybersoft.backend.java11.gira.commondata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericServiceImpl<T extends AbstractEntity, ID> implements GenericService<T, ID> {
	@Autowired
	private JpaRepository<T, ID> _repository;
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return _repository.findAll();
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		_repository.save(entity);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		_repository.deleteById(id);
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

}
