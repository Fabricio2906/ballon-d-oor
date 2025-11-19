//package com.example.Ballon.D.oor.config;
//
//import com.example.Ballon.D.oor.entity.Jogador;
//import com.example.Ballon.D.oor.entity.Titulo;
//import com.example.Ballon.D.oor.repository.BolaOuroRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//public class BolaOuroConfig {
//
//    @Bean
//    CommandLineRunner initDatabase(BolaOuroRepository repository) {
//        return args -> {
//            // Criando jogador DEMBÉLÉ com títulos reais de 2025
//            Jogador dembele = new Jogador();
//            dembele.setNome("Ousmane Dembélé");
//            dembele.setIdade(28);
//            dembele.setAssistencia(21);
//            dembele.setGols(30);
//            dembele.setTime("Paris Saint-Germain");
//            dembele.setGa(dembele.getGols() + dembele.getAssistencia()); // GA = 51
//
//            // Títulos conquistados em 2025
//            Titulo bolaDeOuro = new Titulo();
//            bolaDeOuro.setNome("Bola de Ouro");
//            bolaDeOuro.setImportancia(10);
//            bolaDeOuro.setJogador(dembele);
//
//            Titulo champions = new Titulo();
//            champions.setNome("Champions League");
//            champions.setImportancia(8);
//            champions.setJogador(dembele);
//
//            Titulo ligue1 = new Titulo();
//            ligue1.setNome("Ligue 1");
//            ligue1.setImportancia(6);
//            ligue1.setJogador(dembele);
//
//            Titulo artilheiro = new Titulo();
//            artilheiro.setNome("Artilheiro Ligue 1");
//            artilheiro.setImportancia(5);
//            artilheiro.setJogador(dembele);
//
//            Titulo melhorTemporada = new Titulo();
//            melhorTemporada.setNome("Jogador da temporada Ligue 1");
//            melhorTemporada.setImportancia(4);
//            melhorTemporada.setJogador(dembele);
//
//            // Associando títulos ao jogador
//            dembele.setTitulo(Arrays.asList(
//                    bolaDeOuro, champions, ligue1, artilheiro, melhorTemporada
//            ));
//
//            // Salvando no banco H2
//            repository.save(dembele);
//
//            System.out.println("✅ Banco H2 inicializado!");
//        };
//    }
//}
