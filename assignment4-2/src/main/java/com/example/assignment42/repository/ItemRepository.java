package com.example.assignment42.repository;
import com.example.assignment42.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // 필요한 경우, 사용자 정의 쿼리를 여기에 추가할 수 있습니다.
}