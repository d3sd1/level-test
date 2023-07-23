package com.example.leveltestmvn.service;

import com.example.leveltestmvn.database.model.RequiredRemainder;
import com.example.leveltestmvn.database.repository.RequiredRemainderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RequiredRemainderService {
    private final RequiredRemainderRepository requiredRemainderRepository;

    public RequiredRemainder calculate(int x, int y, int n) {
        Optional<RequiredRemainder> requiredRemainderDb = this.requiredRemainderRepository.findByXAndYAndN(x, y, n);
        if (requiredRemainderDb.isPresent()) {
            return requiredRemainderDb.get();
        }
        StringBuilder sb = new StringBuilder();
        int z = n % x;
        if (z > y) {
            n -= (z - y);
            sb.append(n);
        } else if (z == y)
            sb.append(n);
        else {
            n -= x;
            n += (y - z);
            sb.append(n);
        }
        return this.requiredRemainderRepository.save(RequiredRemainder.builder().x(x).y(y).n(n).result(Integer.parseInt(sb.toString())).build());
    }

    public Set<RequiredRemainder> getAll() {
        return new HashSet<>(requiredRemainderRepository.findAll());
    }
}
