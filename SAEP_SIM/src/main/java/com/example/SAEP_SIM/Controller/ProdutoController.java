package com.example.SAEP_SIM.Controller;


import com.example.SAEP_SIM.DTO.ProdutoDTO;
import com.example.SAEP_SIM.Model.Produto;
import com.example.SAEP_SIM.Repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.util.BeanUtil;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public  ResponseEntity<Produto> salvar(@RequestBody @Valid ProdutoDTO produtoDTO){
        var produto1 = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto1);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto1));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> lista(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable(value = "id")Long idProduto){
        Optional<Produto> produto0 = produtoRepository.findById(idProduto);
        if(produto0.isEmpty()){
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto0.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "idProduto")Long idProduto,
                                                   @RequestBody @Valid ProdutoDTO produtoDTO){
        Optional<Produto> produto0 = produtoRepository.findById(idProduto);
        if(produto0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produto = produto0.get();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "idProduto")Long idProduto){
        Optional<Produto> produto0 = produtoRepository.findById(idProduto);
        if(produto0.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.delete(produto0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso!");
    }


}
