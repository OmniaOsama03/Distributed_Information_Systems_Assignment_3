package com.example.CSC408Assignment3.Repository;

import com.example.CSC408Assignment3.Model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    List<Tree> findByUserId(Long userId);
}
