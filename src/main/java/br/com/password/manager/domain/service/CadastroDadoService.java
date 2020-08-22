package br.com.password.manager.domain.service;

import br.com.password.manager.domain.model.Dado;
import br.com.password.manager.domain.repository.DadoRepository;
import exception.DadoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroDadoService {

    @Autowired
    private DadoRepository dadoRepository;

    @Transactional
    public Dado salvar(Dado dado) {
        Long infId = dado.getId();
        Dado dado1 = buscarOuFalhar(infId);

        return dadoRepository.save(dado);
    }

    @Transactional
    public void exluir(Long dadoId) {
        try {
            dadoRepository.deleteById(dadoId);
            dadoRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }

    public Dado buscarOuFalhar(Long dadoId) {
        return dadoRepository.findById(dadoId)
                .orElseThrow(() -> new DadoNaoEncontradoException(dadoId));
    }
}
