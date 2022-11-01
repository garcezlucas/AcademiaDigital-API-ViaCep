package com.academiadigital.academiadigital.service;

import com.academiadigital.academiadigital.entity.Aluno;
import com.academiadigital.academiadigital.entity.AvaliacaoFisica;
import com.academiadigital.academiadigital.entity.form.AlunoForm;
import com.academiadigital.academiadigital.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

  Aluno create(AlunoForm form);

  Aluno get(Long id);

  List<Aluno> getAll(String dataDeNascimento);

  Aluno update(Long id, AlunoUpdateForm formUpdate);

  void delete(Long id);

  List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);

}
