package com.qatester.springbootYazar.repositories;

import com.qatester.springbootYazar.beans.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YazarRepository extends JpaRepository<Yazar, Long> {



}
