package com.borman.geneobook.service;

import com.borman.geneobook.entity.Relationship;
import com.borman.geneobook.repository.RelationshipRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public Relationship findById(Long id) {
        return relationshipRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("Relationship Not Found with -> id : " + id)
        );
    }

    public void save(Relationship relationship) {
        relationshipRepository.save(relationship);
    }
}
