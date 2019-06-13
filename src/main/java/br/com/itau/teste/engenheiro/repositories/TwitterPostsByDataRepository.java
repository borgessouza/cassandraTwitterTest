package br.com.itau.teste.engenheiro.repositories;

import br.com.itau.teste.engenheiro.model.TwitterPostByData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface TwitterPostsByDataRepository extends CassandraRepository<TwitterPostByData, UUID> {

    @Query("select count(id) as total, hora from twitter_posts_by_date group by hora;")
    List<Map<String, String>> findByData();

}
