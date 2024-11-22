package softka.assesment.client.model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softka.assesment.client.model.Common;


@Entity(name = "ClientDAO")
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDao {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addresses", referencedColumnName = "id")
    private AddressDao address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;


}
