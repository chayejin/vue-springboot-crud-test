package com.test.vueproject.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialTestRepository extends JpaRepository<TutorialTest, Long> {
    List<TutorialTest> findByPublished(boolean published);
    List<TutorialTest> findByTitleContaining(String title);
}
