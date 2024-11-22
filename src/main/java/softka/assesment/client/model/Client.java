package softka.assesment.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client extends Person{
    private Common.ClientStatus clientStatus;
    private String password;

    public Client(Long id, String name, int age, String ci, Common.Genders gender, String phone, String address, Common.ClientStatus clientStatus, String password) {
        super(id, name, age, ci, gender, phone, address);
        this.clientStatus = clientStatus;
        this.password = password;
    }
}
