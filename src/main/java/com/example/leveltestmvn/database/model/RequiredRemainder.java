package com.example.leveltestmvn.database.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Getter
@Setter
@Builder
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class RequiredRemainder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int x;
    private int y;
    private int n;
    private int result;
}
