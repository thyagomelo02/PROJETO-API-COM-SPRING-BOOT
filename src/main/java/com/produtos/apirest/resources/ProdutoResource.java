package com.produtos.apirest.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class ProdutoResource {
    
    @Autowired
    ProdutoRepository produtoRepository;

    
    @ApiOperation(value = "Retorna lista de produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll(); 
    }
    @ApiOperation(value = "Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){/*especificando o campo id para busca */
        return produtoRepository.findById(id); 
    }

    @ApiOperation(value = "Salva um produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody @Valid Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Deleta um produto")
    @DeleteMapping("/produto")
    public void DeletaProduto(@RequestBody @Valid Produto produto){
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Atualiza um produto")
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody  @Valid Produto produto){
        return produtoRepository.save(produto);
    }
}
