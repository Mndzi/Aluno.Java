import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String nome = JOptionPane.showInputDialog("Inserisci il tuo nome:");
            String curso = JOptionPane.showInputDialog("Inserisci il tuo corso:");
            String idades = JOptionPane.showInputDialog("Inserisci la tua data di nascita (yyyy-MM-dd):");

            if (nome == null || nome.isEmpty()
                || curso == null || curso.isEmpty()
                || idades == null || idades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tutti i campi devono essere compilati.");
            return;
            }

        
            if (nome.matches("\\d+") || curso.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Nome e corso non possono essere apenas numeri.");
            return;
            }

            LocalDate nascimento = LocalDate.parse(idades, formatter);
            if (nascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("la data di nascita non puó essere futura");
            }

            Aluno aluno = new Aluno(nome, nascimento, curso);
            JOptionPane.showMessageDialog(null, "Nome: " + aluno.nome + "\nCurso: " + aluno.curso + "\n" + aluno.saudacao());

            String aula = JOptionPane.showInputDialog("Inserisci il nome della classe frequentata:");
            aluno.adicionarAulaAssistida(aula);

            JOptionPane.showMessageDialog(null, "Aulas assistidas: " + aluno.aulasAssistidas + "\nIdade do aluno: " + aluno.calcularIdade());

            Professor professor = new Professor("Carlos", LocalDate.of(1980, 5, 15), "Desenvolvimento de Sistemas", "Computação");
            JOptionPane.showMessageDialog(null, professor.saudacao());
            professor.exibirInfoProfessor();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar a data di nascita. Certifique-se di usare il formato corretto.");
        }
    }
}
    
