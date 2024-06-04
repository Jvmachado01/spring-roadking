package vitor.joao.road_king;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // toString, equals, hashCode, getters and setters
@Entity // JPA - mepeamento da tabela
public class Contact {
    @Id //JPA - primary key
    // identifica como a coluna id será gerada (no caso o próprio db vai definir)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
}

/*
  CREATE TABLE `mydatabase`.`contact` (
 `id` INT NOT NULL,
 `name` VARCHAR(255) NULL,
 `email` VARCHAR(255) NULL,
 `phone` VARCHAR(45) NULL,
 PRIMARY KEY (`id`));

 ALTER TABLE `mydatabase`.`contact`
 CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
 ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

* */