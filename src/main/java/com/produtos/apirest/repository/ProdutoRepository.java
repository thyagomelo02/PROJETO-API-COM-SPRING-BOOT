package com.produtos.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    /*JPAREPOSITORY, para facilitar persistencia nos banco de dados, save, save all, find by id, find all */
    Produto findById(long id);
}

/*http://localhost:8080/swagger-ui.html*/