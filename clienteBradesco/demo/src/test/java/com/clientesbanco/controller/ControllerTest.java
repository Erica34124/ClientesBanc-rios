package com.clientesbanco.controller;

import com.clientesbanco.domain.Cliente;
import com.clientesbanco.repository.ClientesRepository;
import com.clientesbanco.web.ClientesServicesImpl;
import com.clientesbanco.web.dto.ContaDTO;
import com.clientesbanco.web.request.ClienteRequest;
import com.clientesbanco.web.request.ContasRequestService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static mocks.Mocks.clientWithAllFields;
import static mocks.Mocks.clienteRequestWithAllFields;
import static mocks.Mocks.contaDTOWithAllFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    ClientesServicesImpl clientesServicesImpl;
    @MockBean
    ContasRequestService contasRequestService;
    @MockBean
    private ClientesRepository repository;
    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void deveriaCadastrar_comSucesso() throws Exception {
        ClienteRequest clienteRequest = clienteRequestWithAllFields();

        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/clientes/clienteCadastro")
                                .content(gson.toJson(clienteRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void deveriaCadastrar_comFalha() throws Exception {
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/clientes/clienteCadastro")
                                .content(gson.toJson(null))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void deveriaDeletar_comSucesso() throws Exception {
        Cliente cliente = clientWithAllFields();
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/clienteDelete/" + cliente.getId())
                                .content(gson.toJson(cliente))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void deveriaDeletar_comFalha() throws Exception {
        //Verificar porque não retorna 400

        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/clienteDelete/", " ")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isNotFound())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
    }

    @Test
    public void deveriaAtualizarComSucesso() throws Exception {
        Cliente cliente = clientWithAllFields();
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.put("/clientes/clienteAtualizar/" + cliente.getId())
                                .content(gson.toJson(cliente))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void deveriaBuscarTodosComSucesso() throws Exception {
        Cliente cliente = clientWithAllFields();
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/clientes/buscarTodos")
                                .content(gson.toJson(cliente))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void buscarPorId() throws Exception {
        Cliente cliente = clientWithAllFields();
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/clientes/buscarClientePorId/" + cliente.getId())
                                .content(gson.toJson(cliente))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void deveriaBuscarContaPorIdComSucesso() throws Exception {
        ContaDTO conta = contaDTOWithAllFields();

        var response =
                mockMvc.perform(MockMvcRequestBuilders.get("/clientes/buscarConta/" + conta.getId())
                                .content(gson.toJson(conta))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(response.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void deveriaBuscarContaPorIdComFalha() throws Exception {
        ContaDTO conta = contaDTOWithAllFields();

        var response =
                mockMvc.perform(MockMvcRequestBuilders.get("/clientes/buscarConta/", " ")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isNotFound())
                        .andReturn();

        org.assertj.core.api.Assertions.assertThat(response.getResponse()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}