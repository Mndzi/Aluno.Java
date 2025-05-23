import javax.swing.JOptionPane;
import java.time.LocalDate;

import java.util.ArrayList;

public class Aluno {
    protected String nome;
    protected LocalDate nascimento;
    protected String curso;
    protected ArrayList<String> aulasAssistidas;

    public Aluno(String nome, LocalDate nascimento, String curso) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.curso = curso;
        this.aulasAssistidas = new ArrayList<>();
    }

    public String saudacao() {
        return "Olá, " + nome + ". Seja bem-vindo ao curso de " + curso + "!";
    }

    public void adicionarAulaAssistida(String aula) {
        if (aula == null || aula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O aluno não assistiu nenhuma aula.");
        } else {
            this.aulasAssistidas.add(aula);
        }
    }

    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - nascimento.getYear();
    }

}
