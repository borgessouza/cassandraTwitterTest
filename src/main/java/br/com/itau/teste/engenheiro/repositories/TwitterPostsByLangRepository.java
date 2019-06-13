package br.com.itau.teste.engenheiro.repositories;

import br.com.itau.teste.engenheiro.model.TwitterPostsByLang;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface TwitterPostsByLangRepository extends CassandraRepository<TwitterPostsByLang, UUID> {

    @Query("select count(lang) as count, tagName from twitter_posts_by_lang where lang = ?0 group by tagName;")
    List<Map<String, String>> findByPTLangGroupBy(String lang);

}
