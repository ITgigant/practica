package Countries;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    Iterable<CountryEntity> findById(long id);
    List<CountryEntity> findByName(String name);
}