package entities;

import lombok.*;

/**
 * Created by Дмитрий on 23.11.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Abonent {

    private int id;
    private String name;
    private String surname;
    private String midname;
    private String address;
    private String skype;
    private String email;
    private String number;

}
