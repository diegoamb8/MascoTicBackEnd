package com.misiontic.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.back.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}
