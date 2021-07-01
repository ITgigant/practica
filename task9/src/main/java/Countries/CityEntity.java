package Countries;

import javax.persistence.*;

@Entity
public class CityEntity {

    @Id
    @Column(name = "UID", nullable = false, length = 15)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long uid;

    @Column(name = "NAME")
    private String name;

    public CityEntity() { }

    public CityEntity(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "регионы", nullable = false)
    private RegionEntity region;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRegion(RegionEntity region) {
        this.region = region;
    }
    public RegionEntity getRegion(RegionEntity region) {
        return region;
    }
}
