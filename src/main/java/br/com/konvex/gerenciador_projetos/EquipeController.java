package br.com.konvex.gerenciador_projetos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    private List<Equipe> equipes = new ArrayList<>();
    private Long proximoId = 1L;

    @GetMapping
    public List<Equipe> listarEquipes() {
        return equipes;
    }

    @GetMapping("/{id}")
    public Equipe buscarEquipe(@PathVariable Long id) {
        for (Equipe equipe : equipes) {
            if (equipe.getId().equals(id)) {
                return equipe;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Equipe não encontrada."
        );
    }

    @PutMapping("/{id}")
    public Equipe editarEquipe(@PathVariable Long id, @RequestBody Equipe dados) {
        for (Equipe equipe : equipes) {
            if (equipe.getId().equals(id)) {

                if (dados.getLider() != null) {
                    if (dados.getLider().isBlank()) {
                        throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "O líder da equipe é obrigatório."
                        );
                    }

                    equipe.setLider(dados.getLider());
                }

                if (dados.getMembros() != null) {
                    equipe.setMembros(dados.getMembros());
                }

                return equipe;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Equipe não encontrada."
        );
    }

    @DeleteMapping("/{id}")
    public void excluirEquipe(@PathVariable Long id) {
        for (Equipe equipe : equipes) {
            if (equipe.getId().equals(id)) {
                equipes.remove(equipe);
                return;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Equipe não encontrada."
        );
    }

    @PostMapping
    public Equipe criarEquipe(@RequestBody Equipe equipe) {
        if (equipe.getLider() == null || equipe.getLider().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "O líder da equipe é obrigatório."
            );
        }

        equipe.setId(proximoId);
        proximoId++;
        equipes.add(equipe);

        return equipe;
    }
}