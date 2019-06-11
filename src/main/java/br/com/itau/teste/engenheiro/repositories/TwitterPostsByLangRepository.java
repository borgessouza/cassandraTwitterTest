package br.com.itau.teste.engenheiro.repositories;

import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TwitterPostsByLangRepository extends CassandraRepository<TwitterPostsByLang, UUID> {

    List<TwitterPostsByLang> findByLang(String lang);
}
