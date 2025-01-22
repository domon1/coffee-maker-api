package com.komarov.coffee_maker_api.repository;

import com.komarov.coffee_maker_api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
