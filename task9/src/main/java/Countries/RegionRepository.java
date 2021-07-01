package Countries;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<RegionEntity, Long> {
    Iterable<RegionEntity> findById(long id);
    List<RegionEntity> findByName(String name);
}