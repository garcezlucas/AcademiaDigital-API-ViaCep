package com.academiadigital.academiadigital.service;

import com.academiadigital.academiadigital.entity.Matricula;
import com.academiadigital.academiadigital.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

  Matricula create(MatriculaForm form);


  Matricula get(Long id);


  List<Matricula> getAll(String bairro);

  void delete(Long id);

}
