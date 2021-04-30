package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Integer>{

}
