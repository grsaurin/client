package softka.assesment.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Person {

    protected Long id;

    protected String name;
    protected int age;
    protected String ci;
    protected Common.Genders gender;
    protected String phone;
    protected String address;
}
