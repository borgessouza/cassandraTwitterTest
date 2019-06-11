package br.com.itau.teste.engenheiro.repositories;

import br.com.itau.teste.engenheiro.model.TwitterUsersByFollowers;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TwitterUsersRepository extends CassandraRepository<TwitterUsersByFollowers, UUID> {

    Iterable<TwitterUsersByFollowers> findTop5BytagName(String tagName);
    Iterable<TwitterUsersByFollowers> findTop5By();
}
