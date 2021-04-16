package bandtec.com.br.adrianotavaresac2.repositorio;


import bandtec.com.br.adrianotavaresac2.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<LutadorRepository,Integer> {

    static void save(Lutador novoLutador) {
    }

    @Query("SELECT COUNT(l) FROM Lutador l WHERE l.isVivo=true")
    long countByIsVivo();

    @Query("SELECT l FROM Lutador l ORDER BY l.forcaGolpe DESC")
    List<Lutador> orderByForcaGolpe();

}