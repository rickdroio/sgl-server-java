package com.rdr.sglserverjava;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rdr.sglserverjava.cidade.Cidade;
import com.rdr.sglserverjava.cidade.CidadeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepositoriesTests {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Test
    public void CidadeRepository_Save() {

        Cidade cidade = new Cidade();
        cidade.setNome("Teste");
        cidade.setIbge("12345");
        cidade.setUf("SP");

        Cidade saveCidade = cidadeRepository.save(cidade);

        Assertions.assertThat(saveCidade).isNotNull();
        Assertions.assertThat(saveCidade.getId()).isGreaterThan(0);
    }
    
}
