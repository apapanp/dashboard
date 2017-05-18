package criminalcase.model;

import sun.jvm.hotspot.memory.Generation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by apapan on 5/15/2017 AD.
 */
@Entity
public class Pie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    public Pie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //for JPA
    public Pie() {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}