package com.academiadigital.academiadigital.service;

import com.academiadigital.academiadigital.entity.AvaliacaoFisica;
import com.academiadigital.academiadigital.entity.form.AvaliacaoFisicaForm;
import com.academiadigital.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

  AvaliacaoFisica create(AvaliacaoFisicaForm form);

  AvaliacaoFisica get(Long id);

  List<AvaliacaoFisica> getAll();

  AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

  void delete(Long id);
}
