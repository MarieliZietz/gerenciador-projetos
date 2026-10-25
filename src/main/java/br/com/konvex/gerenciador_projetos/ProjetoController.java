package br.com.konvex.gerenciador_projetos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private List<Projeto> projetos = new ArrayList<>();
    private Long proximoId = 1L;

    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetos;
    }

    @GetMapping("/{id}")
    public Projeto buscarProjetoPorId(@PathVariable Long id) {
        for (Projeto projeto : projetos) {
            if (projeto.getId().equals(id)) {
                return projeto;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Projeto não encontrado."
        );
    }

    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto) {
        if (projeto.getNome() == null || projeto.getNome().isBlank()
                || projeto.getCliente() == null || projeto.getCliente().isBlank()
                || projeto.getDataInicio() == null
                || projeto.getDataEntrega() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Preencha todos os campos obrigatórios."
            );
        }

        projeto.setId(proximoId);
        proximoId++;

        projeto.setStatus("nao iniciado");
        projetos.add(projeto);

        return projeto;
    }

    @PutMapping("/{id}")
    public Projeto atualizarProjeto(
            @PathVariable Long id,
            @RequestBody Projeto dadosAtualizados) {

        for (Projeto projeto : projetos) {
            if (projeto.getId().equals(id)) {

                if (dadosAtualizados.getNome() != null) {
                    if (dadosAtualizados.getNome().isBlank()) {
                        throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "O nome do projeto não pode ser vazio."
                        );
                    }

                    projeto.setNome(dadosAtualizados.getNome());
                }

                if (dadosAtualizados.getCliente() != null) {
                    if (dadosAtualizados.getCliente().isBlank()) {
                        throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "O cliente não pode ser vazio."
                        );
                    }

                    projeto.setCliente(dadosAtualizados.getCliente());
                }

                if (dadosAtualizados.getDataInicio() != null) {
                    projeto.setDataInicio(dadosAtualizados.getDataInicio());
                }

                if (dadosAtualizados.getDataEntrega() != null) {
                    projeto.setDataEntrega(dadosAtualizados.getDataEntrega());
                }

                if (dadosAtualizados.getStatus() != null) {
                    String status = dadosAtualizados.getStatus();

                    if (!status.equals("nao iniciado")
                            && !status.equals("em andamento")
                            && !status.equals("concluido")) {
                        throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Status inválido."
                        );
                    }

                    projeto.setStatus(status);
                }

                if (dadosAtualizados.getIdEquipe() != null) {
                    projeto.setIdEquipe(dadosAtualizados.getIdEquipe());
                }

                return projeto;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Projeto não encontrado."
        );
    }

    @DeleteMapping("/{id}")
    public void excluirProjeto(@PathVariable Long id) {
        for (Projeto projeto : projetos) {
            if (projeto.getId().equals(id)) {
                projetos.remove(projeto);
                return;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Projeto não encontrado."
        );
    }
}