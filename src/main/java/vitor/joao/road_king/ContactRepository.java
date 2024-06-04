package vitor.joao.road_king;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Concat entidade que representa ta table e Long o tipo do coluna id da table
public interface ContactRepository extends JpaRepository<Contact, Long> {}
