package Countries;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CountryEntity {

    @Id
    @Column(name = "UID", nullable = false, length = 15)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long uid;

    @Column(name = "NAME")
    private String name;

    public CountryEntity() { }

    public CountryEntity(String name) {
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RegionEntity> region = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRegion(Set<RegionEntity> region) {
        this.region = region;
    }
    public Set<RegionEntity> getRegion() {
        return region;
    }
}
