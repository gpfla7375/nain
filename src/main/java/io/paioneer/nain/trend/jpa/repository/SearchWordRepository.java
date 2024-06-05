package io.paioneer.nain.trend.jpa.repository;

import io.paioneer.nain.trend.jpa.entity.SearchWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchWordRepository extends JpaRepository<SearchWordEntity, Long>, SearchWordRepositoryCustom{
}
