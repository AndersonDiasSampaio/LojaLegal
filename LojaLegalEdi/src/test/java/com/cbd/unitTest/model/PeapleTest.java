package com.cbd.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.cdb.model.People;

public class PeapleTest {

	public PeapleTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void testCreatePeapleAtributs() {
		People testPeaple= new People("Anderson","09339394429", "rua feia");
		assertThat(testPeaple.getAddress()).isEqualTo("rua feia");
        assertThat(testPeaple.getCpf()).isEqualTo("09339394429");
        assertThat(testPeaple.getNome()).isEqualTo("Anderson");
		}
	@Test
	public void testCreatePeapleNoAtributs() {
		People testPeaple= new People();
        assertThat(testPeaple.getAddress()).isEqualTo("endereco nao informado");
        assertThat(testPeaple.getCpf()).isEqualTo("CPF nao informado");
        assertThat(testPeaple.getNome()).isEqualTo("Nome nao informado");
		}
	@Test
	public void testChangeAtributsPeaple() {
		People testPeaple= new People("Anderson","09339394429", "rua feia");
        assertThat(testPeaple.getAddress()).isEqualTo("rua feia");
        assertThat(testPeaple.getCpf()).isEqualTo("09339394429");
        assertThat(testPeaple.getNome()).isEqualTo("Anderson");
        testPeaple.setNome("Mudou");
        testPeaple.setCpf("09339394428");
        testPeaple.setAddress("Rua Mudou");
        assertThat(testPeaple.getAddress()).isEqualTo("Rua Mudou");
        assertThat(testPeaple.getCpf()).isEqualTo("09339394428");
        assertThat(testPeaple.getNome()).isEqualTo("Mudou");
        

	}
}
