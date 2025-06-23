package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * 提供 Item 相关业务逻辑的服务层。
 */
@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取所有条目。
     */
    public List<Item> findAll() {
        return repository.findAll();
    }

    /**
     * 根据 ID 查找条目。
     */
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * 新建或更新条目。
     */
    public Item save(Item item) {
        return repository.save(item);
    }

    /**
     * 根据 ID 删除条目。
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
