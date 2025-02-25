package com.Lins.RegisterUser_Java_Spring.domain.user;



import jakarta.persistence.*;
import lombok.*;

@Table(name="registered_user")
@Entity(name="registered_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private Integer age;

    public User(RequestUser requestUser){
        this.name = requestUser.name();
        this.email = requestUser.email();
        this.age = (Integer) requestUser.age();
    }

}
