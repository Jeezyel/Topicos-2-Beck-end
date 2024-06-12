package br.unitins.service;

import br.unitins.DTO.LivroDTO;
import br.unitins.DTO.LivroResponceDTO;
import br.unitins.model.Autor;
import br.unitins.model.Editora;
import br.unitins.model.Livro;
import br.unitins.repository.AutorRepository;
import br.unitins.repository.EditoraRepository;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class LivroServiceMPL implements LivroService{
    @Inject
    LivroRepository livroRepository;

    @Inject
    AutorRepository autorRepository;

    @Inject
    EditoraRepository editoraRepository;

    @Inject
    Validator validator;

    @Override
    public List<LivroResponceDTO> getAll(Integer page, Integer pageSize) {


        List<Livro> list = livroRepository.findAll().page(page,pageSize).list();


        return list.stream().map(LivroResponceDTO::new).collect(Collectors.toList());
    }



    @Override
    @Transactional
    public LivroResponceDTO create(LivroDTO livroDTO) throws ConstraintViolationException{
        validar(livroDTO);

        var entity = new Livro();
        entity.setTitulo(livroDTO.titulo());
        entity.setAutor(autorRepository.findById(livroDTO.autor()));
        entity.setEditora(editoraRepository.findById(livroDTO.editora()));
        entity.setAnoPublicacao(livroDTO.anoPublicacao());
        entity.setCategoriaLivro(livroDTO.categoriaLivro());
        entity.setNumPaginas(livroDTO.numPaginas());



        livroRepository.persist(entity);

        return new LivroResponceDTO(entity);

    }

    @Override
    @Transactional
    public LivroResponceDTO update(Long id, LivroDTO livroDTO) throws ConstraintViolationException{
        validar(livroDTO);

        Livro entity = livroRepository.findById(id);

        entity.setTitulo(livroDTO.titulo());
        entity.setAutor(autorRepository.findById(livroDTO.autor()));
        entity.setEditora(editoraRepository.findById(livroDTO.editora()));
        entity.setAnoPublicacao(livroDTO.anoPublicacao());
        entity.setCategoriaLivro(livroDTO.categoriaLivro());
        entity.setNumPaginas(livroDTO.numPaginas());

        return new LivroResponceDTO(entity);
    }

    @Override
    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    @Override
    public List<LivroResponceDTO> findByNome(String nome) {
        List<Livro> list = livroRepository.findByNome(nome);
        return list.stream().map(LivroResponceDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return livroRepository.count();
    }

    private void validar(LivroDTO livroDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<LivroDTO>> violations = validator.validate(livroDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}
