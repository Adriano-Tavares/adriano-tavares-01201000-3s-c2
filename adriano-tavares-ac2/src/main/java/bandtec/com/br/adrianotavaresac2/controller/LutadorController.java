package bandtec.com.br.adrianotavaresac2.controller;


import bandtec.com.br.adrianotavaresac2.dominio.Lutador;
import bandtec.com.br.adrianotavaresac2.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    LutadorRepository LutadorRepository;

    @PostMapping//A) POST/lutadores
    public ResponseEntity cadastraUsuario(@RequestBody @Valid Lutador novoUsuario){
        LutadorRepository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping //B) EndPoint GET/Lutadores
    public ResponseEntity getLutadores(){
        List<Lutador> lutadores = LutadorRepository.orderByForceGolpe();
        return !lutadores.isEmpty() ? ResponseEntity.status(200).body(lutadores) :
                ResponseEntity.status(204).build();
    }


    @GetMapping("/contagem-vivos") //C) GET/lutadores/contagem-vivos
    public ResponseEntity getContagemVivos(){
        return ResponseEntity.ok(LutadorRepository.countByIsVivo());
    }



    @PostMapping("/{id}/concentrar")//D) POST/lutadores/X/concentrar
    public ResponseEntity cadastrarUsuario(@PathVariable Integer id){
        if(LutadorRepository.existsById(id)) {
            LutadorRepository.findById(id).ifPresent(lutador1 -> lutador1.concentra());
            return ResponseEntity.ok().build();
           }

    //E
    @PostMapping("/golpe/{JSON}" ) //D) POST/lutadores/golpe {JSON}
    public ResponseEntity cadastraUsuario(@RequestBody HttpServletResponse response){
        Integer id;


}

