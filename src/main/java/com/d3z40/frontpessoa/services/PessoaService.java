package com.d3z40.frontpessoa.services;

import com.d3z40.frontpessoa.models.Pessoa;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class PessoaService {

    private final String URL_PESSOAS = "http://localhost:8080/pessoas";

    private RestTemplate restTemplate = new RestTemplate();

    public Pessoa[] getPessoas() {
        Pessoa[] pessoas = restTemplate.getForObject(URL_PESSOAS, Pessoa[].class);

        return pessoas;
    }

    public Pessoa getPessoaById(int id) {
        Pessoa pessoa = restTemplate.getForObject(URL_PESSOAS + "/" + id, Pessoa.class);

        return pessoa;
    }

    public void deletePessoa(int id) throws URISyntaxException {
        restTemplate.delete(new URI(URL_PESSOAS + "/" + id));
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        HttpEntity<Pessoa> requestBody = new HttpEntity<Pessoa>(pessoa);
        pessoa = restTemplate.postForObject(URL_PESSOAS, requestBody, Pessoa.class);

        return pessoa;
    }
}