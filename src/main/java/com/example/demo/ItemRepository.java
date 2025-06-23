package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Item 实体的仓库接口，继承自 JpaRepository。
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
