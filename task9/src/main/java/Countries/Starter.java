package Countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Starter {

    public static void main(String[] args) {



//        configurableApplicationContext context = SpringBootApplication.run(Startup.class);
//        MarkRepository repository = context.getBeen(MarkRepository.clas);
//        ModelRepository repository = context.getBeen(ModelRepository.clas);
//
//
//
//        MarkEntity mark1 = new MarkEntity();
//        mark1.setName("audi");
//        mark1.setPattern("Ауди");
//        mark1.setActive(true);
//        repository.save(mark1);
//
//        ModelEntity model1 = new ModelEntity();
//        model1.setName("A6");
//        model1.setMark(mark1);
//        modelRepository.save(model1);
//
//
//
//        MarkEntity mark2 = new MarkEntity();
//        mark1.setName("opel");
//        mark1.setPattern("опель");
//        mark1.setActive(false);
//        repository.save(mark2);
//
//
//        List<MarkEntity> marks = repository.findAll();
//
//        List<MarkEntity> models =  modelRepository.findAll();
//        for (ModelEntity model: models){
//            System.out.println(" " + model.getName() );
//        }
//
//        for (MarkEntity mark: marks){
//            System.out.println(mark.getName());
//            Set<MarkEntity> models = mark.getModels();
//
//            for (ModelEntity model: models){
//                System.out.println(" " + model.getName() );
//            }



        ConfigurableApplicationContext context = SpringApplication.run(Starter.class);
        CountryRepository repository = context.getBean(CountryRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);

        CountryEntity Country1 = new CountryEntity();
        Country1.setName("Россия");
        repository.save(Country1);

        RegionEntity Region1 = new RegionEntity();
        Region1.setName("Вологодская область");
        Region1.setCountry(Country1);
        regionRepository.save(Region1);

        CityEntity City1 = new CityEntity();
        City1.setName("Вологда");
        City1.setRegion(Region1);
        cityRepository.save(City1);

        CityEntity City2 = new CityEntity();
        City2.setName("Череповец");
        City2.setRegion(Region1);
        cityRepository.save(City2);


        CityEntity City3 = new CityEntity();
        City3.setName("Кириллов");
        City3.setRegion(Region1);
        cityRepository.save(City3);

        CountryEntity Country2 = new CountryEntity();
        Country2.setName("Соединенные штаты Америки");
        repository.save(Country2);

        RegionEntity Region2 = new RegionEntity();
        Region2.setName("Калифорния");
        Region2.setCountry(Country2);
        regionRepository.save(Region2);

        RegionEntity Region3 = new RegionEntity();
        Region3.setName("Вашингтон");
        Region3.setCountry(Country2);
        regionRepository.save(Region3);

        CityEntity City4 = new CityEntity();
        City4.setName("Лос-Анджелес");
        City4.setRegion(Region2);
        cityRepository.save(City4);

        CityEntity City5 = new CityEntity();
        City5.setName("Вашингтон");
        City5.setRegion(Region3);
        cityRepository.save(City5);

        List<CountryEntity> Countries = (List<CountryEntity>) repository.findAll();
        System.out.println("Справочник локаций");
        System.out.println();
        for (CountryEntity country : Countries) {
            System.out.println("Страна: " + country.getName());
            Set<RegionEntity> Regions = country.getRegion();
            for (RegionEntity region : Regions) {
                System.out.println(" Регион: " + region.getName());
                Set<CityEntity> Cities = region.getCity();
                for (CityEntity city : Cities) {
                    System.out.println("  Город: " + city.getName());
                }
            }
            System.out.println();
        }

        context.close();
    }
}