package softka.assesment.client.model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softka.assesment.client.model.Common;


@Entity(name = "ClientObjDao")
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientObjDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "id_ci")
    private String ci;

    @Enumerated(EnumType.ORDINAL)
    private Common.Genders gender;

    @Enumerated(EnumType.ORDINAL)
    private Common.ClientStatus clientStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;
}
