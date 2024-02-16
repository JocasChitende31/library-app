package com.atendestartup.library.repositories;

import com.atendestartup.library.entities.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReadingListRepository extends JpaRepository<ReadingList, String> {

    ReadingList getExistItem(Long id);
}
