package com.test.vueproject.domain.Tutorial;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TutorialTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @Builder
    public TutorialTest(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

}
